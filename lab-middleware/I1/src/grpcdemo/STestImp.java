package grpcdemo;

import ser.grpc.Empty;
import ser.grpc.STestGrpc;
import ser.grpc.STestProto;

public class STestImp extends STestGrpc.STestImplBase {

    public void setDummy(ser.grpc.Empty request, io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
        var result=Empty.newBuilder().build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    public void setPerson(ser.grpc.Person request, io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
        var result=Empty.newBuilder().build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    /**
     */
    public void setPersonSequence(ser.grpc.PersonSeq request, io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
        var result=Empty.newBuilder().build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    /**
     */
    public void setFiveDoubles(ser.grpc.FiveDoubles request, io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
        var result=Empty.newBuilder().build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    /**
     */
    public void setFiveDoublesSequence(ser.grpc.FiveDoublesSeq request, io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
        var result=Empty.newBuilder().build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    /**
     */
    public void setMixed(ser.grpc.Mixed request, io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
        var result=Empty.newBuilder().build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }

    /**
     */
    public void setMixedSequence(ser.grpc.MixedSeq request, io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
        var result=Empty.newBuilder().build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
