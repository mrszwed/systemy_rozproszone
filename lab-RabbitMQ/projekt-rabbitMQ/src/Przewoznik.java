import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Przewoznik implements Runnable {
    String typZlecenia1;
    String typZlecenia2;
    Channel inputChannel; //kanał do odbierania zleceń
    Channel outputChannel; //kanał do wysyłania potwierdzeń
    Channel adminChannel; //kanał do wiadomości od admina
    Consumer consumer;
    String queueName;
    String queueName2;
    String adminQueueName;
    String nazwa;

    Przewoznik(String typZlecenia1, String typZlecenia2, String nazwa){
        this.typZlecenia1 = typZlecenia1;
        this.typZlecenia2 = typZlecenia2;
        queueName=Settings.otypeToQueue.get(typZlecenia1);
        queueName2=Settings.otypeToQueue.get(typZlecenia2);
        this.nazwa=nazwa;
    }


    void setup() throws IOException, TimeoutException {
        System.out.printf("[PRZEWOZNIK %s] obsługuje: %s i %s\n", nazwa,typZlecenia1,typZlecenia2);


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        inputChannel = connection.createChannel();

        outputChannel = connection.createChannel();
        adminChannel = connection.createChannel();

        inputChannel.exchangeDeclare(Settings.CONSUMER_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        outputChannel.exchangeDeclare(Settings.AGENCY_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        adminChannel.exchangeDeclare(Settings.ADMIN_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);


        inputChannel.queueDeclare(queueName, true, false, false, null);
        inputChannel.queueDeclare(queueName2, true, false, false, null);

        inputChannel.queueBind(queueName, Settings.CONSUMER_EXCHANGE_NAME, typZlecenia1);
        System.out.println("created queue: " + queueName);

        inputChannel.queueBind(queueName2,Settings.CONSUMER_EXCHANGE_NAME, typZlecenia2);
        System.out.println("created queue: " + queueName2);

        adminQueueName = adminChannel.queueDeclare().getQueue();
        adminChannel.queueBind(adminQueueName, Settings.ADMIN_EXCHANGE_NAME, Settings.CONSUMER_TOPIC);


        consumer = new DefaultConsumer(inputChannel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(String.format("[PRZEWOZNIK %s] received: %s",nazwa,message));

                Zlecenie z=Zlecenie.fromJSON(message);
                z.setKtoZrealizowal(nazwa);
                z.setStatusZlecenia("done");
                String returnMessage=z.toJson();
                outputChannel.basicPublish(Settings.AGENCY_EXCHANGE_NAME, z.getNazwaAgencji(), null, returnMessage.getBytes("UTF-8"));
                inputChannel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

    }

    void handleAdminChannel() throws IOException {
        Consumer consumer = new DefaultConsumer(adminChannel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.printf("[PRZEWOZNIK %s] Received admin message: %s\n", nazwa, message);
            }};
        adminChannel.basicConsume(adminQueueName, true, consumer);
    }

    @SneakyThrows
    public void run(){
        handleAdminChannel();
        System.out.println("Waiting for messages...");
        inputChannel.basicConsume(queueName, false, consumer);
        inputChannel.basicConsume(queueName2, false, consumer);
    }

    public static void main(String[] argv) throws Exception {
        if(argv.length!=3){
            System.out.println("call: java -cp JARFILE Przewoznik TYP_ZLECENIA_1 TYP_ZLECENIA_2 NAZWA");
            System.exit(0);
        }
        Przewoznik p = new Przewoznik(argv[0],argv[1], argv[2]);
        p.setup();
        p.run();
    }
}
