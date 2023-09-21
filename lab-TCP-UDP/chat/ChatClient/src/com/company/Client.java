package com.company;

import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {
    String hostname;
    int port;
    Socket socket;
    PrintWriter writer;

    Client(String hostname, int port){
        this.hostname=hostname;
        this.port=port;
    }

    class TCPClientThread extends Thread{
        public void run(){
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                writer = new PrintWriter(output, true);
                while(socket.isConnected()){
                    String messageFromServer= reader.readLine();
                    if(messageFromServer==null)return;
                    JSONObject jo = new JSONObject(messageFromServer);
                    System.out.println("["+(String)jo.get("nick")+"]: "+(String)jo.get("content"));
                }
            } catch (IOException e) {
//                e.printStackTrace();
                //wyjątek może powstać kiedy socket zostanie zamknięty po wyjściu klienta za pomocą quit
                //nie wypisujemy informacji o wyjątku
                //
            }
        }
    }

    class UDPClientThread extends Thread{
        InetAddress inetAddress;
        int port;
        DatagramSocket socket = null;
        boolean end=false;

        UDPClientThread(String hostname, int port) throws UnknownHostException, SocketException {
            this.inetAddress=InetAddress.getByName(hostname);
            this.port=port;
            socket=new DatagramSocket();
        }

        void sendToServer(String command, String content) throws IOException {
            JSONObject jo = new JSONObject();
            jo.put("command", command);
            jo.put("content", content);
            String packetData=jo.toString();

            byte[] b = packetData.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(b, b.length, inetAddress, port);
            socket.send(packet);
        }

        void sendNick(String nick){
            try {
                sendToServer("nick", nick);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void sendMessage(String message){
            try {
                sendToServer("msg", message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void sendQuit(){
            try {
                sendToServer("quit", "");
                end=true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run(){
            try {
                while(!end){
                    byte[] buf=new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);
                    String received = new String(packet.getData(), 0, packet.getLength());
                    JSONObject jo = new JSONObject(received);
                    System.out.println("<UDP> ["+(String)jo.get("nick")+"]: "+(String)jo.get("content"));

                }

            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class MulticastClientThread extends Thread{
        boolean end=false;
        MulticastSocket socket = null;
        InetSocketAddress group;
        NetworkInterface netIf;
        String nick;

        MulticastClientThread(String groupAddr, int port){
            try {
                InetAddress mcastaddr = InetAddress.getByName(groupAddr);
                group = new InetSocketAddress(mcastaddr, port);
                netIf = NetworkInterface.getByName("bge0");
                socket = new MulticastSocket(port);
                socket.joinGroup(group, netIf);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void setNick(String nick){
            this.nick=nick;
        }

        void quit(){
            try {
                end=true;
                socket.leaveGroup(group, netIf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void sendMulticastMessage(String message) throws IOException {
            JSONObject jo = new JSONObject();
            jo.put("command", "msg");
            jo.put("content", message);
            jo.put("nick", nick);
            String packetData=jo.toString();

            byte[] b = packetData.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(b, b.length, group);

            socket.send(packet);
        }

        public void run(){
            try {
                while(!end) {
                    byte[] buf = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);
                    String received = new String(packet.getData(), 0, packet.getLength());
                    JSONObject jo = new JSONObject(received);
                    String mNick=(String)jo.get("nick");
                    if(mNick.equals(nick))continue;
                    System.out.println("<Multicast> ["+(String)jo.get("nick")+"]: "+(String)jo.get("content"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void sendToServer(String command, String content){
        JSONObject jo = new JSONObject();
        jo.put("command", command);
        jo.put("content", content);
        writer.println(jo.toString());
    }

    public void run(){
        UDPClientThread udpClientThread=null;
        MulticastClientThread multicastClientThread=null;

        try {
            udpClientThread=new UDPClientThread(hostname, port);
            udpClientThread.start();
            multicastClientThread=new MulticastClientThread("230.0.0.1", port+1);
            multicastClientThread.start();

            socket = new Socket(hostname, port);
            System.out.println("");

            new TCPClientThread().start();

            System.out.println("Podaj nick.");

//            Console cs=System.console();
//            String nick=cs.readLine();

            BufferedReader cs = new BufferedReader(new InputStreamReader(System.in));
            String nick=cs.readLine();

            sendToServer("nick", nick);
            udpClientThread.sendNick(nick);
            multicastClientThread.setNick(nick);

            boolean multilineUDP=false;
            while(true){
                String line=cs.readLine();
                if(line==null)break;
                if(line.equals("quit") && !multilineUDP)break;
                //UMON, UMOFF - UDP multiline on off, do wysyłania ASCII Art
                if(line.equals("UMON")){
                    multilineUDP=true;
                    continue;
                }

                if(line.equals("UMOFF")){
                    multilineUDP=false;
                    continue;
                }
                if(multilineUDP){
                    udpClientThread.sendMessage(line);
                }
                else if(line.startsWith("U ")){
                    udpClientThread.sendMessage(line.substring(2));
                }

                else if(line.startsWith("M ")){
                    multicastClientThread.sendMulticastMessage(line.substring(2));
                }
                else{
                    sendToServer("msg", line);
                }
            }

            sendToServer("quit", "");
            udpClientThread.sendQuit();
            multicastClientThread.quit();
            System.exit(0);


        } catch (UnknownHostException e) {
            System.out.println("Nie odnaleziono serwera: " + hostname + ":" + port);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        if(args.length<2){
            System.out.println("Wywołaj java Client hostname numer_portu");
            System.exit(-1);
        }
        int port = Integer.parseInt(args[1]);
        Client c=new Client(args[0], port);
        c.run();
    }
}
