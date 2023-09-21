package grpcdemo;


import java.util.concurrent.Semaphore;

public class LoopbackTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem=new Semaphore(0);
        Serwer serwer=new Serwer("127.0.0.1", 10000, sem);
        Client client=new Client("127.0.0.1", 10000);

        Thread t=new Thread(()->{serwer.execute();});
        t.start();
        sem.acquire();
        client.execute();
        System.exit(0);
    }
}
