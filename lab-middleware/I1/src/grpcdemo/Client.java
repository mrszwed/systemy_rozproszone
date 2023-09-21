package grpcdemo;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ser.grpc.*;
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
    STestGrpc.STestBlockingStub stestBlockingStub;

    List<Integer> seqlen= Arrays.asList(10, 50, 200, 1000, 2000, 10000, 20000);

    Random rand=new Random();

    Client(String host, int port){
        this.host =host;
        this.port=port;
    }

    Person generatePerson(){
        Person p = Person.newBuilder().setName(WordGenerator.nextWord()).
                setSurname(WordGenerator.nextWord()).setBirthYear(rand.nextInt()%2023).build();
        return p;
    }

    PersonSeq generatePersons(int k){
        var builder=PersonSeq.newBuilder();
        for(int i=0; i<k; i++){
            builder.addPersons(generatePerson());
        }
        return builder.build();
    }

    FiveDoubles generateFiveDoubles(){
        FiveDoubles fd=FiveDoubles.newBuilder().setD0(rand.nextDouble()).
                setD1(rand.nextDouble()).
                setD2(rand.nextDouble()).
                setD3(rand.nextDouble()).
                setD4(rand.nextDouble()).build();
        return fd;
    }

    FiveDoublesSeq generateFiveDoubless(int k){
        var builder=FiveDoublesSeq.newBuilder();
        for(int i=0; i<k; i++){
            builder.addFiveDoubless(generateFiveDoubles());
        }
        return builder.build();
    }

    Mixed generateMixed(){
        Mixed m= Mixed.newBuilder().setB((byte)rand.nextInt()).
                setS((short)rand.nextInt()).
                setI(rand.nextInt()).
                setF(rand.nextFloat()).
                setD(rand.nextDouble()).
                setSs(WordGenerator.nextWord()).build();
        return m;
    }

    MixedSeq generateMixeds(int k){
        var builder=MixedSeq.newBuilder();
        for(int i=0; i<k; i++){
            builder.addMixeds(generateMixed());
        }
        return builder.build();
    }

    void testDummy(int k){
        for(int i=0; i<k; i++){
            long start=System.nanoTime();
            stestBlockingStub.setDummy(Empty.newBuilder().build());
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("Dummy", diff);
        }
    }

    void testSinglePerson(int k){
        for(int i=0; i<k; i++){
            Person p=generatePerson();
            long start=System.nanoTime();
            stestBlockingStub.setPerson(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SinglePerson", diff);
        }
    }

    void testPersons(int repetitions){
        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                PersonSeq ps=generatePersons(k);
                long start=System.nanoTime();
                stestBlockingStub.setPersonSequence(ps);
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
            stestBlockingStub.setFiveDoubles(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SingleFiveDoubles", diff);
        }
    }

    void testFiveDoubless(int repetitions){
        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                FiveDoublesSeq ps=generateFiveDoubless(k);
                long start=System.nanoTime();
                stestBlockingStub.setFiveDoublesSequence(ps);
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
            stestBlockingStub.setMixed(p);
            long end=System.nanoTime();
            double diff=(end-start)/10e9;
            SampleLog.addData("SingleMixed", diff);
        }
    }

    void testMixeds(int repetitions){
        for(int k:seqlen){
            for(int i=0; i<repetitions; i++){
                MixedSeq ps=generateMixeds(k);
                long start=System.nanoTime();
                stestBlockingStub.setMixedSequence(ps);
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
                s.writeToFile("wyniki-grpc/"+s.name+".csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void execute(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).
                usePlaintext().
                build();
        stestBlockingStub = STestGrpc.newBlockingStub(channel);
        runTests();
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
