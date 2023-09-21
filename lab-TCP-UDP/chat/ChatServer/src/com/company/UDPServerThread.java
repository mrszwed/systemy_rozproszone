package com.company;

import org.json.JSONObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class UDPServerThread extends Thread{
    DatagramSocket serverUDPSocket = null;
    Set<UDPClient> udpClients = new HashSet<>();
    int port;


    class UDPClient{
        int port;
        InetAddress inetAddress;
        String nick;
        UDPClient(int port, InetAddress inetAddress, String nick){
            this.inetAddress=inetAddress;
            this.port=port;
            this.nick=nick;
        }
    }

    UDPServerThread(int port){
        this.port=port;
    }

    void broadcast(String message, UDPClient source) throws IOException {
        JSONObject jo = new JSONObject();
        jo.put("command", "msg");
        jo.put("content", message);
        jo.put("nick", source.nick);
        String packetData=jo.toString();
        byte[] b = packetData.getBytes(StandardCharsets.UTF_8);
        for(var ch:udpClients){
            if(ch==source){
                continue;
            }
            DatagramPacket packet = new DatagramPacket(b, b.length, ch.inetAddress, ch.port);
            serverUDPSocket.send(packet);
        }
    }

    public void run(){
        try {
            serverUDPSocket = new DatagramSocket(port);
            while(true){
                byte[] buf = new byte[1024];

                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                serverUDPSocket.receive(packet);
                String str = new String(packet.getData(), StandardCharsets.UTF_8);
//                System.out.println(str.length());
                System.out.println(str);

                JSONObject jo = new JSONObject(str);

                String command=(String)jo.get("command");
                int pPort=packet.getPort();
                InetAddress pInetAddress=packet.getAddress();
                if(command.equals("nick")){
                    String nick=(String)jo.get("content");
                    udpClients.add(new UDPClient(pPort, pInetAddress, nick));
                    continue;
                }
                if(command.equals("quit")){
                    udpClients.removeIf(p->p.port==pPort&&p.inetAddress.equals(pInetAddress));
                    continue;
                }
                if(command.equals("msg")){
                    UDPClient source=null;
                    for(var c:udpClients){
                        if(c.port==pPort && c.inetAddress.equals(pInetAddress)){
                            source=c;
                            break;
                        }
                    }
                    if(source==null){
                        continue;
                    }
                    broadcast((String)jo.get("content"), source);
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
