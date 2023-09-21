import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.sleep;

public class Admin implements Runnable {
    Channel agencyChannel; //kanał do odczytu tego co idzie do agencji
    Channel przewoznikChannel; //kanał, do którego będą przychodziły potwierdzenia
    Channel adminChannel; //kanał, do wysyłania komunikatów administracyjncych
    String agencyQueueName;
    String przewoznikQueueName;
    String adminQueueName;
    boolean autorun=false;

    Admin(){

    }

    void setup() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        agencyChannel = connection.createChannel();
        przewoznikChannel = connection.createChannel();
        adminChannel= connection.createChannel();

        agencyChannel.exchangeDeclare(Settings.AGENCY_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        przewoznikChannel.exchangeDeclare(Settings.CONSUMER_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        adminChannel.exchangeDeclare(Settings.ADMIN_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        agencyQueueName = agencyChannel.queueDeclare().getQueue();
        agencyChannel.queueBind(agencyQueueName, Settings.AGENCY_EXCHANGE_NAME, "*");

        przewoznikQueueName = przewoznikChannel.queueDeclare().getQueue();
        przewoznikChannel.queueBind(przewoznikQueueName, Settings.CONSUMER_EXCHANGE_NAME, "*");

        adminQueueName = adminChannel.queueDeclare().getQueue();
        adminChannel.queueBind(adminQueueName, Settings.ADMIN_EXCHANGE_NAME, "*");

        Consumer consumer = new DefaultConsumer(agencyChannel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("[ADMIN] monitor: " + message);
            }};
        agencyChannel.basicConsume(agencyQueueName, true, consumer);
        przewoznikChannel.basicConsume(przewoznikQueueName, true, consumer);
    }

    void sendToAgencies(String message) throws IOException {
        LocalTime time = LocalTime.now();
        String toSend=String.format("[AGENCIES at %s] %s", time.toString(), message);
        adminChannel.basicPublish(Settings.ADMIN_EXCHANGE_NAME, Settings.AGENCY_TOPIC, null, toSend.getBytes("UTF-8"));
    }

    void sendToPrzewoznicy(String message) throws IOException {
        LocalTime time = LocalTime.now();
        String toSend=String.format("[Przewoznicy at %s] %s", time.toString(), message);
        adminChannel.basicPublish(Settings.ADMIN_EXCHANGE_NAME, Settings.CONSUMER_TOPIC, null, toSend.getBytes("UTF-8"));
    }

    void sendToAll(String message) throws IOException {
        LocalTime time = LocalTime.now();
        String toSend=String.format("[ALL at %s] %s", time.toString(), message);
        adminChannel.basicPublish(Settings.ADMIN_EXCHANGE_NAME, Settings.AGENCY_TOPIC, null, toSend.getBytes("UTF-8"));
        adminChannel.basicPublish(Settings.ADMIN_EXCHANGE_NAME, Settings.CONSUMER_TOPIC, null, toSend.getBytes("UTF-8"));
    }

    public void run(){
        if(autorun){
            while(true){
                try {
                    sleep(6000);
                    sendToAgencies("witam witam agencje!");
                    sleep(6000);
                    sendToPrzewoznicy("dobry wieczor przewoznicy!");
                    sleep(6000);
                    sendToAll("witajcie wszyscy!");
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                try {
                    String adresat="all";
                    System.out.println("Podaj adresata [all, agencje, przewoznicy], default=all...");
                    adresat = br.readLine();
                    if(adresat.isEmpty()){
                        adresat="all";
                    }
                    System.out.println("Podaj tekst wiadomosci...");
                    String wiadomosc = br.readLine();
                    switch (adresat){
                        case "all":
                            sendToAll(wiadomosc);
                            break;
                        case "agencje":
                            sendToAgencies(wiadomosc);
                            break;
                        case "przewoznicy":
                            sendToPrzewoznicy(wiadomosc);
                            break;
                        default:
                            System.out.println("nieznany adresat");
                            break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] argv) throws Exception {
        Admin admin=new Admin();
        admin.setup();
        admin.run();
    }

}
