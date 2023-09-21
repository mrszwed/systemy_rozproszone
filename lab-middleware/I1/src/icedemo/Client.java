package icedemo;

import Serialization.FiveDoubles;
import Serialization.Mixed;
import Serialization.Person;
import Serialization.STestPrx;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;
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
    STestPrx stestprx;

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

    Person[] generatePersons(int k){
        Person[] tab=new Person[k];
        for(int i=0; i<k; i++){
            tab[i]=generatePerson();
        }
        return tab;
    }

    FiveDoubles generateFiveDoubles(){
        FiveDoubles fd=new FiveDoubles(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
        return fd;
    }

    FiveDoubles[] generateFiveDoubless(int k){
        FiveDoubles[] tab=new FiveDoubles[k];
        for(int i=0; i<k; i++){
            tab[i]=generateFiveDoubles();
        }
        return tab;
    }

    Mixed generateMixed(){
        Mixed m=new Mixed((byte)rand.nextInt(), (short)rand.nextInt(), rand.nextInt(), rand.nextFloat(), rand.nextDouble(), WordGenerator.nextWord());
        return m;
    }

    Mixed[] generateMixeds(int k){
        Mixed[] tab=new Mixed[k];
        for(int i=0; i<k; i++){
            tab[i]=generateMixed();
        }
        return tab;
    }

    void testDummy(int k){
        for(int i=0; i<k; i++){
            long start=System.nanoTime();
            stestprx.setDummy();
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("Dummy", diff);
        }
    }

    void testSinglePerson(int k){
        for(int i=0; i<k; i++){
            Person p=generatePerson();
            long start=System.nanoTime();
            stestprx.setPerson(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SinglePerson", diff);
        }
    }

    void testPersons(int repetitions){

        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                Person[] ps=generatePersons(k);
                long start=System.nanoTime();
                stestprx.setPersonSequence(ps);
                long end=System.nanoTime();
                double diff=(end-start)/10e9;
                SampleLog.addData("PersonSequence"+k, diff);
            }
        }
    }

    void testSingleFiveDoubles(int k){
        for(int i=0; i<k; i++){
            FiveDoubles p=generateFiveDoubles();
            long start=System.nanoTime();
            stestprx.setFiveDoubles(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SingleFiveDoubles", diff);
        }
    }

    void testFiveDoubless(int repetitions){
        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                FiveDoubles[] ps=generateFiveDoubless(k);
                long start=System.nanoTime();
                stestprx.setFiveDoublesSequence(ps);
                long end=System.nanoTime();
                double diff=(end-start)/10e9;
                SampleLog.addData("FiveDoublesSequence"+k, diff);
            }
        }
    }

    void testMixed(int k){
        for(int i=0; i<k; i++){
            Mixed p=generateMixed();
            long start=System.nanoTime();
            stestprx.setMixed(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SingleMixed", diff);
        }
    }

    void testMixeds(int repetitions){
        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                Mixed[] ps=generateMixeds(k);
                long start=System.nanoTime();
                stestprx.setMixedSequence(ps);
                long end=System.nanoTime();
                double diff=(end-start)/10e9;
                SampleLog.addData("MixedSequence"+k, diff);
            }
        }
    }


    void runTests(){
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
                s.writeToFile("wyniki-ice/"+s.name+".csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void execute(){
        int status = 0;
        Communicator communicator = null;
        try {
            communicator = Util.initialize(new String[0]);
            String connectionString=String.format("stest/stest:tcp -h %s -p %d -z : udp -h %s -p %d -z", host, port, host, port);
            ObjectPrx stest = communicator.stringToProxy(connectionString);
            stestprx = STestPrx.checkedCast(stest);
            if (stestprx == null) throw new Error("Invalid proxy");
            runTests();
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
        if (communicator != null) { //clean
            try {
                communicator.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
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
