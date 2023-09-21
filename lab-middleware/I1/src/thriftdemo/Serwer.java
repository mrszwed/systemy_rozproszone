package thriftdemo;



import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import ser.thrift.STest;

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
        try{
            STest.Processor<STestHandler> processor = new STest.Processor<STestHandler>(new STestHandler());
            TServerTransport serverTransport = new TServerSocket(port);
            TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).protocolFactory(protocolFactory).processor(processor));
            System.out.println("starting server");
            if(sem!=null)sem.release();
            server.serve();
        }
        catch (TTransportException e) {
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
