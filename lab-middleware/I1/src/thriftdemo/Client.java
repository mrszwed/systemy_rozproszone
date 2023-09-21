package thriftdemo;


import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import ser.thrift.FiveDoubles;
import ser.thrift.Mixed;
import ser.thrift.Person;
import ser.thrift.STest;
import util.Sample;
import util.SampleLog;
import util.WordGenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Client {
    String host;
    int port;
    STest.Client stest = null;

    List<Integer> seqlen= Arrays.asList(10, 50, 200, 1000, 2000, 10000, 20000);

    Random rand=new Random();

    Client(String host, int port){
        this.host =host;
        this.port=port;
    }

    Person generatePerson(){
        Person p=new Person(WordGenerator.nextWord(), WordGenerator.nextWord(), rand.nextInt()%2023);
        return p;
    }

    List<Person> generatePersons(int k){
        Person[] tab=new Person[k];
        for(int i=0; i<k; i++){
            tab[i]=generatePerson();
        }
        return Arrays.asList(tab);
    }

    FiveDoubles generateFiveDoubles(){
        FiveDoubles fd=new FiveDoubles(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
        return fd;
    }

    List<FiveDoubles> generateFiveDoubless(int k){
        FiveDoubles[] tab=new FiveDoubles[k];
        for(int i=0; i<k; i++){
            tab[i]=generateFiveDoubles();
        }
        return Arrays.asList(tab);
    }

    Mixed generateMixed(){
        Mixed m=new Mixed((byte)rand.nextInt(), (short)rand.nextInt(), rand.nextInt(), rand.nextInt(), rand.nextDouble(), WordGenerator.nextWord());
        return m;
    }

    List<Mixed> generateMixeds(int k){
        Mixed[] tab=new Mixed[k];
        for(int i=0; i<k; i++){
            tab[i]=generateMixed();
        }
        return Arrays.asList(tab);
    }

    void testDummy(int k) throws TException {
        for(int i=0; i<k; i++){
            long start=System.nanoTime();
            stest.setDummy();
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("Dummy", diff);
        }
    }

    void testSinglePerson(int k) throws TException {
        for(int i=0; i<k; i++){
            Person p=generatePerson();
            long start=System.nanoTime();
            stest.setPerson(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SinglePerson", diff);
        }
    }

    void testPersons(int repetitions) throws TException {
        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                List<Person> ps=generatePersons(k);
                long start=System.nanoTime();
                stest.setPersonSequence(ps);
                long end=System.nanoTime();
                double diff=(end-start)/10e9;
                SampleLog.addData("PersonSequence"+k, diff);
            }
        }
    }

    void testSingleFiveDoubles(int k) throws TException {
        for(int i=0; i<k; i++){
            FiveDoubles p=generateFiveDoubles();
            long start=System.nanoTime();
            stest.setFiveDoubles(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SingleFiveDoubles", diff);
        }
    }

    void testFiveDoubless(int repetitions) throws TException {
        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                List<FiveDoubles> ps=generateFiveDoubless(k);
                long start=System.nanoTime();
                stest.setFiveDoublesSequence(ps);
                long end=System.nanoTime();
                double diff=(end-start)/10e9;
                SampleLog.addData("FiveDoublesSequence"+k, diff);
            }
        }
    }

    void testMixed(int k) throws TException {
        for(int i=0; i<k; i++){
            Mixed p=generateMixed();
            long start=System.nanoTime();
            stest.setMixed(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SingleMixed", diff);
        }
    }

    void testMixeds(int repetitions) throws TException {
        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                List<Mixed> ps=generateMixeds(k);
                long start=System.nanoTime();
                stest.setMixedSequence(ps);
                long end=System.nanoTime();
                double diff=(end-start)/10e9;
                SampleLog.addData("MixedSequence"+k, diff);
            }
        }
    }


    void runTests() throws TException {
        testDummy(100);
        testSinglePerson(100);
        testPersons(100);
        testSingleFiveDoubles(100);
        testFiveDoubless(100);
        testMixed(100);
        testMixeds(100);
        Sample s;
        for(var n: SampleLog.getSampleNames()){
            s=SampleLog.get(n);
            try {
                s.writeToFile("wyniki-thrift/"+s.name+".csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void execute(){
        TProtocol protocol = null;
        TTransport transport = null;

        try {
            transport = new TSocket(host, port);
            protocol = new TCompactProtocol(transport);
            stest = new STest.Client(protocol);
            if(transport != null) transport.open();
            runTests();
            transport.close();
        }
        catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        int port=10000;
//        String host="192.168.1.105";
        String host="127.0.0.2";
        if(args.length>=1){
            host=args[0];
        }
        if(args.length>=2){
            port=Integer.parseInt(args[1]);
        }
        Client app = new Client(host, port);
        app.execute();
    }
}
