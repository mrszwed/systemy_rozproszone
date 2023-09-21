package icedemo;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

import java.util.concurrent.Semaphore;

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
        int status=0;
        Communicator communicator = null;
        try {
            communicator = Util.initialize(new String[0]);
            String serverString=String.format("tcp -h %s -p %d -z : udp -h %s -p %d -z", host, port, host, port);
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter", serverString);
            STestImp sTestServant = new STestImp();
            adapter.add(sTestServant, new Identity("stest", "stest"));
            adapter.activate();
            System.out.println("adapter activated");
            if(sem!=null)sem.release();
            communicator.waitForShutdown();
        }
        catch (Exception e) {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            }
            catch (Exception e) {
                System.err.println(e);
                status = 1;
            }
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
