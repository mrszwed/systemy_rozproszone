package grpcdemo;


import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class Serwer {
    String host;
    int port;
    Semaphore sem;
    Serwer(String host, int port, Semaphore sem){
        this.host =host;
        this.port=port;
        this.sem=sem;
    }

    void execute(){
        SocketAddress socket;
        Logger logger = Logger.getLogger(Serwer.class.getName());
        try {

            socket = new InetSocketAddress(InetAddress.getByName(host), port);


            Server server;
            server = NettyServerBuilder.forAddress(socket).executor(Executors.newFixedThreadPool(16))
                    .addService(new STestImp())
                    .build()
                    .start();
            logger.info("Server started, listening on " + port);
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.err.println("*** shutting down gRPC server since JVM is shutting down");
                    if (server != null) {
                        server.shutdown();
                    }
                    System.err.println("*** server shut down");
                }
            });
            if(sem!=null)sem.release();
            if (server != null) {
                server.awaitTermination();
            }
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        int port=10000;
        String host="127.0.0.2";
        if(args.length>=1){
            host=args[0];
        }
        if(args.length>=2){
            port=Integer.parseInt(args[1]);
        }
        Serwer app = new Serwer(host, port, null);
        app.execute();
    }
}
