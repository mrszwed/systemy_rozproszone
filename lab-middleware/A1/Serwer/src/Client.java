import IHouse.*;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.LocalException;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Client {

    @AllArgsConstructor
    static class SessionResult{
        boolean exit=true;
        int port=-1;
        int status;

    }
    static class Session{
        Map<String, Map<String, ObjectPrx>> roomToDevices=new HashMap<>();
        Map<String, String> nameToType=new HashMap<>();
        Map<String, List<String>> typeToMethod=new HashMap<>();

        SessionResult execute(String[] args, int serverPort){
            int status = 0;
            Communicator communicator = null;

            try {
                communicator = Util.initialize(args);

                String connectionString=String.format("discover/discover:tcp -h 127.0.0.2 -p %d -z : udp -h 127.0.0.2 -p %d -z", serverPort, serverPort);
                ObjectPrx discover = communicator.stringToProxy(connectionString); //opcja -z włącza możliwość kompresji wiadomości

                DiscoverPrx discoverprx = DiscoverPrx.checkedCast(discover);
                if (discoverprx == null) throw new Error("Invalid proxy");
                var devices=discoverprx.listDevices();
                System.out.println(devices.length);
                for(var d:devices){
                    System.out.println(d);
                    connectionString=String.format("%s/%s:tcp -h 127.0.0.2 -p %d -z : udp -h 127.0.0.2 -p %d -z", d.type, d.name, serverPort, serverPort);
                    ObjectPrx deviceBase=communicator.stringToProxy(connectionString);
                    var nameToProxy=roomToDevices.getOrDefault(d.location, new HashMap<String, ObjectPrx>());
                    String name=d.name.substring(0, d.name.indexOf("-"));
                    nameToProxy.put(name, deviceBase);
                    roomToDevices.put(d.location,nameToProxy);
                    nameToType.put(name, d.type);

                }

                CompletableFuture<Long> cfl = null;
                String line = null;
                java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

                while(true)	{
                    try	{
                        System.out.print("==> ");
                        line = in.readLine();

                        if (line == null)
                        {
                            break;
                        }
                        String[] words=line.split(" ");
                        if(words.length==1 && words[0].equals("x")){
                            break;
                        }
                        if(words.length==2 && words[0].equals("activate")){
                            int newPort=Integer.parseInt(words[1]);
                            if(newPort==serverPort){
                                System.out.println("continue current session");
                            }
                            else{
                                SessionResult sr=new SessionResult(false, newPort, 0);
                                return sr;
                            }
                        }
                        if(words.length<3){
                            System.out.println("wywołaj: pomieszczenie urzadzenie funkcja <argumenty>");
                        }
                        var devicesInRoom=roomToDevices.getOrDefault(words[0], null);
                        if(devicesInRoom==null){System.out.println("nie ma takiego pokoju"); continue;}
                        var deviceProxy=devicesInRoom.getOrDefault(words[1], null);
                        if(deviceProxy==null){System.out.println("nie ma takiego urzadzenia"); continue;}
                        String typ=nameToType.getOrDefault(words[1], null);
                        if(typ==null){System.out.println("nieznany typ urzadzenia"); continue;}
                        switch(typ){
                            case "light":
                                LightPrx lightprx = LightPrx.checkedCast(deviceProxy);
                                if (lightprx == null) throw new Error("Invalid proxy");
                                switch(words[2]){
                                    case "on":
                                    {
                                        var result=lightprx.on();
                                        System.out.println("rezultat: "+result);
                                    }
                                    break;
                                    case "off":
                                    {
                                        var result = lightprx.off();
                                        System.out.println("rezultat: " + result);
                                    }
                                    break;
                                    default:
                                        System.out.println("nieznana funkcja "+words[2]);
                                        break;
                                }
                                break;
                            case "dimmableLight":
                                DimmableLightPrx dimmableLightprx = DimmableLightPrx.checkedCast(deviceProxy);
                                if (dimmableLightprx == null) throw new Error("Invalid proxy");
                                switch(words[2]){
                                    case "on":
                                    {
                                        var result=dimmableLightprx.on();
                                        System.out.println("rezultat: "+result);
                                    }
                                    break;
                                    case "off":
                                    {
                                        var result = dimmableLightprx.off();
                                        System.out.println("rezultat: " + result);
                                    }
                                    break;
                                    case "setLevel":
                                    {
                                        if(words.length<4){System.out.println("brak argumentu"); break;}
                                        int level=Integer.parseInt(words[3]);
                                        var result = dimmableLightprx.setLevel(level);
                                        System.out.println("rezultat: " + result);
                                    }
                                    break;
                                    default:
                                        System.out.println("nieznana funkcja "+words[2]);
                                        break;
                                }
                                break;
                            case "heating":
                                HeatingPrx heatingprx = HeatingPrx.checkedCast(deviceProxy);
                                if (heatingprx == null) throw new Error("Invalid proxy");
                                switch(words[2]){
                                    case "on":
                                    {
                                        var result=heatingprx.on();
                                        System.out.println("rezultat: "+result);
                                    }
                                    break;
                                    case "off":
                                    {
                                        var result = heatingprx.off();
                                        System.out.println("rezultat: " + result);
                                    }
                                    break;
                                    case "setTemperature":
                                    {
                                        if(words.length<4){System.out.println("brak argumentu"); break;}
                                        int level=Integer.parseInt(words[3]);
                                        var result = heatingprx.setTemperature(level);
                                        System.out.println("rezultat: " + result);
                                    }
                                    break;
                                    default:
                                        System.out.println("nieznana funkcja "+words[2]);
                                        break;
                                }
                                break;
                            case "motionSensor":
                                MotionSensorPrx motionSensorprx = MotionSensorPrx.checkedCast(deviceProxy);
                                if (motionSensorprx == null) throw new Error("Invalid proxy");
                                switch(words[2]) {
                                    case "arm": {
                                        var result = motionSensorprx.arm();
                                        System.out.println("rezultat: " + result);
                                    }
                                    break;
                                    case "disarm": {
                                        var result = motionSensorprx.disarm();
                                        System.out.println("rezultat: " + result);
                                    }
                                    break;
                                    case "getEvents": {
                                        var result = motionSensorprx.getEvents();
                                        System.out.println("Events:");
                                        for (var e : result) {
                                            System.out.println(e);
                                        }
                                    }
                                    break;
                                    default:
                                        System.out.println("nieznana funkcja " + words[2]);
                                        break;
                                }
                                break;
                        }

                    }
                    catch (java.io.IOException ex)
                    {
                        System.err.println(ex);
                    }
                    catch(InvalidArgumentValue ex){
                        System.out.println(ex.reason);
                    }

                    catch (com.zeroc.Ice.TwowayOnlyException ex)
                    {
                        System.err.println(ex);
                    }
                }


            } catch (LocalException e) {
                e.printStackTrace();
                status = 1;
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
            if (communicator != null) { //clean
                try {
                    communicator.destroy();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    status = 1;
                }
            }
            return new SessionResult(true, serverPort, status);
        }
    }


    public static void main(String[] args)
    {
        int serverPort=10000;
        for(;;) {
            Session session = new Session();
            SessionResult sr = session.execute(args, serverPort);
            if (sr.exit == true)System.exit(sr.status);
            else{
                serverPort=sr.port;
            }
        }
    }

}
