import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class Agencja {

    String nazwa;
    Channel outputChannel; //kanał za pośrednictwem, którego wysyła się zlecenia do przewoźników
    Channel inputChannel; //kanał, do którego będą przychodziły potwierdzenia
    Channel adminChannel; //kanał do wiadomości od admina
    int numerZlecenia=0;
    String inputQueueName;
    String adminQueueName;

    Agencja(String nazwa){
        this.nazwa=nazwa;
    }

    void setup() throws IOException, TimeoutException {


        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        outputChannel = connection.createChannel();
        inputChannel = connection.createChannel();
        adminChannel = connection.createChannel();


        // exchange

        outputChannel.exchangeDeclare(Settings.CONSUMER_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        inputChannel.exchangeDeclare(Settings.AGENCY_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        adminChannel.exchangeDeclare(Settings.ADMIN_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        inputQueueName = inputChannel.queueDeclare().getQueue();
        inputChannel.queueBind(inputQueueName, Settings.AGENCY_EXCHANGE_NAME, nazwa);

        adminQueueName = adminChannel.queueDeclare().getQueue();
        adminChannel.queueBind(adminQueueName, Settings.ADMIN_EXCHANGE_NAME, Settings.AGENCY_TOPIC);
    }

    void handleInputChannel() throws IOException {
        Consumer consumer = new DefaultConsumer(inputChannel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.printf("[AGENCJA %s] Received potwierdzenie: %s\n",nazwa, message);
            }};
        inputChannel.basicConsume(inputQueueName, true, consumer);
    }

    void handleAdminChannel() throws IOException {
        Consumer consumer = new DefaultConsumer(adminChannel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.printf("[AGENCJA %s] Received admin message: %s\n",nazwa,message);
            }};
        adminChannel.basicConsume(adminQueueName, true, consumer);
    }

    void run() throws IOException {
        handleInputChannel();
        handleAdminChannel();
        while (true) {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter key: ");
            String typZlecenia = br.readLine();

            var zlecenia = Zlecenie.getNazwyZlecen();
            if(!zlecenia.contains(typZlecenia)){
                System.out.println("zła nazwa zlecenia");
                continue;
            }

            Zlecenie z=new Zlecenie(nazwa, typZlecenia, numerZlecenia++);


            // publish
            String message=z.toJson();
            outputChannel.basicPublish(Settings.CONSUMER_EXCHANGE_NAME, typZlecenia, null, message.getBytes("UTF-8"));
            System.out.println("Sent: " + message);
        }
    }

    public static void main(String[] argv) throws Exception {
        String nazwaAgencji;
        if(argv.length==0){
            Random rand=new Random();
            nazwaAgencji="Agencja"+rand.nextInt(1000);
        }
        else{
            nazwaAgencji=argv[0];
        }


        Agencja a=new Agencja(nazwaAgencji);
        a.setup();
        a.run();
    }
}
