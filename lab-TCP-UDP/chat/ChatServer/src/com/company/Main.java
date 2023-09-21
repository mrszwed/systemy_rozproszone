package com.company;

import org.json.JSONObject;

import java.util.Scanner;

public class Main {

    public static void testjson() {
	// write your code here
        JSONObject jo = new JSONObject();
        jo.put("name", "jon doe");
        jo.put("age", "22");
        jo.put("city", "chicago");

        String jstring=jo.toString();
        System.out.println(jstring);

        JSONObject jo2 = new JSONObject(
                jstring
        );
        System.out.println((String)jo2.get("name"));
    }

    static void testScanner(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder b=new StringBuilder();
        while(scanner.hasNextLine()){
            b.append(scanner.nextLine());
        }
        System.out.println(b.toString());
    }

    public static void main(String[] args) {
//        if (args.length<1)System.out.println("Wywołaj: java Server port_number");
//        int port = Integer.parseInt(args[0]);
//        Server server=new Server(port);
//        server.run();

        testScanner();
    }
}
