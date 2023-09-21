package com.company;

import org.json.JSONObject;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable{
    Socket socket;
    Server server;
    PrintWriter writer;
    String nick;

    ClientHandler(Socket socket, Server server){
        this.socket=socket;
        this.server=server;
    }

    void sendMessage(String message) {
        writer.println(message);
    }

    public void run(){
        try {
            System.out.println("running");
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

            String line= reader.readLine();
            JSONObject jo = new JSONObject(line);
            String command=(String)jo.get("command");
            if(!command.equals("nick")){
                System.out.println("błąd protokołu (nick)");
            }
            nick=(String)jo.get("content");


            server.broadcast("Witam na czacie!", this);


            while(socket.isConnected()){
                String message= reader.readLine();
                System.out.println(message);
                jo = new JSONObject(message);
                command=(String)jo.get("command");
                if(command.equals("quit")){
                    break;
                }
                if(command.equals("msg")){
                    String content=(String)jo.get("content");
                    server.broadcast(content, this);
                }

            }

            server.removeClientHandler(this);
            socket.close();

            server.broadcast("Do widzenia!", this);

        }
        catch (SocketException ex) {
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
