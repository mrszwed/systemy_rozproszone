package com.company;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    int port;
    ExecutorService executor = Executors.newFixedThreadPool(32);
    Set<ClientHandler> clientHandlers = new HashSet<>();


    Server(int port){
        this.port=port;
    }

    void broadcast(String message, ClientHandler source){
        JSONObject jo = new JSONObject();
        jo.put("command", "msg");
        jo.put("content", message);
        jo.put("nick", source.nick);
        for(var ch:clientHandlers){
            if(ch==source){
                continue;
            }
            ch.sendMessage(jo.toString());
        }
    }

    void removeClientHandler(ClientHandler ch){
        clientHandlers.remove(ch);
    }

    void run(){
        ServerSocket serverTCPSocket = null;

        try {
            serverTCPSocket = new ServerSocket(port);

            while(true){
                Socket clientSocket = serverTCPSocket.accept();
                ClientHandler ch=new ClientHandler(clientSocket, this);
                clientHandlers.add(ch);
                executor.execute(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverTCPSocket != null) {
                try {
                    serverTCPSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            executor.shutdown();
        }

    }

    public static void main(String[] args) {
        if (args.length<1){
            System.out.println("Wywołaj: java Server port_number");
            System.exit(-1);
        }
        int port = Integer.parseInt(args[0]);

        UDPServerThread udpServer=new UDPServerThread(port);
        udpServer.start();

        Server server=new Server(port);
        server.run();
    }
}
