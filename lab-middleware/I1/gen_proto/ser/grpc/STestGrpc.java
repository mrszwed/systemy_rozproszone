package ser.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: serialization_proto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class STestGrpc {

  private STestGrpc() {}

  public static final String SERVICE_NAME = "stest.STest";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ser.grpc.Empty,
      ser.grpc.Empty> getSetDummyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setDummy",
      requestType = ser.grpc.Empty.class,
      responseType = ser.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ser.grpc.Empty,
      ser.grpc.Empty> getSetDummyMethod() {
    io.grpc.MethodDescriptor<ser.grpc.Empty, ser.grpc.Empty> getSetDummyMethod;
    if ((getSetDummyMethod = STestGrpc.getSetDummyMethod) == null) {
      synchronized (STestGrpc.class) {
        if ((getSetDummyMethod = STestGrpc.getSetDummyMethod) == null) {
          STestGrpc.getSetDummyMethod = getSetDummyMethod =
              io.grpc.MethodDescriptor.<ser.grpc.Empty, ser.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setDummy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new STestMethodDescriptorSupplier("setDummy"))
              .build();
        }
      }
    }
    return getSetDummyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ser.grpc.Person,
      ser.grpc.Empty> getSetPersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setPerson",
      requestType = ser.grpc.Person.class,
      responseType = ser.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ser.grpc.Person,
      ser.grpc.Empty> getSetPersonMethod() {
    io.grpc.MethodDescriptor<ser.grpc.Person, ser.grpc.Empty> getSetPersonMethod;
    if ((getSetPersonMethod = STestGrpc.getSetPersonMethod) == null) {
      synchronized (STestGrpc.class) {
        if ((getSetPersonMethod = STestGrpc.getSetPersonMethod) == null) {
          STestGrpc.getSetPersonMethod = getSetPersonMethod =
              io.grpc.MethodDescriptor.<ser.grpc.Person, ser.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setPerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new STestMethodDescriptorSupplier("setPerson"))
              .build();
        }
      }
    }
    return getSetPersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ser.grpc.PersonSeq,
      ser.grpc.Empty> getSetPersonSequenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setPersonSequence",
      requestType = ser.grpc.PersonSeq.class,
      responseType = ser.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ser.grpc.PersonSeq,
      ser.grpc.Empty> getSetPersonSequenceMethod() {
    io.grpc.MethodDescriptor<ser.grpc.PersonSeq, ser.grpc.Empty> getSetPersonSequenceMethod;
    if ((getSetPersonSequenceMethod = STestGrpc.getSetPersonSequenceMethod) == null) {
      synchronized (STestGrpc.class) {
        if ((getSetPersonSequenceMethod = STestGrpc.getSetPersonSequenceMethod) == null) {
          STestGrpc.getSetPersonSequenceMethod = getSetPersonSequenceMethod =
              io.grpc.MethodDescriptor.<ser.grpc.PersonSeq, ser.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setPersonSequence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.PersonSeq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new STestMethodDescriptorSupplier("setPersonSequence"))
              .build();
        }
      }
    }
    return getSetPersonSequenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ser.grpc.FiveDoubles,
      ser.grpc.Empty> getSetFiveDoublesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setFiveDoubles",
      requestType = ser.grpc.FiveDoubles.class,
      responseType = ser.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ser.grpc.FiveDoubles,
      ser.grpc.Empty> getSetFiveDoublesMethod() {
    io.grpc.MethodDescriptor<ser.grpc.FiveDoubles, ser.grpc.Empty> getSetFiveDoublesMethod;
    if ((getSetFiveDoublesMethod = STestGrpc.getSetFiveDoublesMethod) == null) {
      synchronized (STestGrpc.class) {
        if ((getSetFiveDoublesMethod = STestGrpc.getSetFiveDoublesMethod) == null) {
          STestGrpc.getSetFiveDoublesMethod = getSetFiveDoublesMethod =
              io.grpc.MethodDescriptor.<ser.grpc.FiveDoubles, ser.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setFiveDoubles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.FiveDoubles.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new STestMethodDescriptorSupplier("setFiveDoubles"))
              .build();
        }
      }
    }
    return getSetFiveDoublesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ser.grpc.FiveDoublesSeq,
      ser.grpc.Empty> getSetFiveDoublesSequenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setFiveDoublesSequence",
      requestType = ser.grpc.FiveDoublesSeq.class,
      responseType = ser.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ser.grpc.FiveDoublesSeq,
      ser.grpc.Empty> getSetFiveDoublesSequenceMethod() {
    io.grpc.MethodDescriptor<ser.grpc.FiveDoublesSeq, ser.grpc.Empty> getSetFiveDoublesSequenceMethod;
    if ((getSetFiveDoublesSequenceMethod = STestGrpc.getSetFiveDoublesSequenceMethod) == null) {
      synchronized (STestGrpc.class) {
        if ((getSetFiveDoublesSequenceMethod = STestGrpc.getSetFiveDoublesSequenceMethod) == null) {
          STestGrpc.getSetFiveDoublesSequenceMethod = getSetFiveDoublesSequenceMethod =
              io.grpc.MethodDescriptor.<ser.grpc.FiveDoublesSeq, ser.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setFiveDoublesSequence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.FiveDoublesSeq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new STestMethodDescriptorSupplier("setFiveDoublesSequence"))
              .build();
        }
      }
    }
    return getSetFiveDoublesSequenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ser.grpc.Mixed,
      ser.grpc.Empty> getSetMixedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setMixed",
      requestType = ser.grpc.Mixed.class,
      responseType = ser.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ser.grpc.Mixed,
      ser.grpc.Empty> getSetMixedMethod() {
    io.grpc.MethodDescriptor<ser.grpc.Mixed, ser.grpc.Empty> getSetMixedMethod;
    if ((getSetMixedMethod = STestGrpc.getSetMixedMethod) == null) {
      synchronized (STestGrpc.class) {
        if ((getSetMixedMethod = STestGrpc.getSetMixedMethod) == null) {
          STestGrpc.getSetMixedMethod = getSetMixedMethod =
              io.grpc.MethodDescriptor.<ser.grpc.Mixed, ser.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setMixed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Mixed.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new STestMethodDescriptorSupplier("setMixed"))
              .build();
        }
      }
    }
    return getSetMixedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ser.grpc.MixedSeq,
      ser.grpc.Empty> getSetMixedSequenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setMixedSequence",
      requestType = ser.grpc.MixedSeq.class,
      responseType = ser.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ser.grpc.MixedSeq,
      ser.grpc.Empty> getSetMixedSequenceMethod() {
    io.grpc.MethodDescriptor<ser.grpc.MixedSeq, ser.grpc.Empty> getSetMixedSequenceMethod;
    if ((getSetMixedSequenceMethod = STestGrpc.getSetMixedSequenceMethod) == null) {
      synchronized (STestGrpc.class) {
        if ((getSetMixedSequenceMethod = STestGrpc.getSetMixedSequenceMethod) == null) {
          STestGrpc.getSetMixedSequenceMethod = getSetMixedSequenceMethod =
              io.grpc.MethodDescriptor.<ser.grpc.MixedSeq, ser.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setMixedSequence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.MixedSeq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ser.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new STestMethodDescriptorSupplier("setMixedSequence"))
              .build();
        }
      }
    }
    return getSetMixedSequenceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static STestStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<STestStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<STestStub>() {
        @java.lang.Override
        public STestStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new STestStub(channel, callOptions);
        }
      };
    return STestStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static STestBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<STestBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<STestBlockingStub>() {
        @java.lang.Override
        public STestBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new STestBlockingStub(channel, callOptions);
        }
      };
    return STestBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static STestFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<STestFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<STestFutureStub>() {
        @java.lang.Override
        public STestFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new STestFutureStub(channel, callOptions);
        }
      };
    return STestFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void setDummy(ser.grpc.Empty request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetDummyMethod(), responseObserver);
    }

    /**
     */
    default void setPerson(ser.grpc.Person request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetPersonMethod(), responseObserver);
    }

    /**
     */
    default void setPersonSequence(ser.grpc.PersonSeq request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetPersonSequenceMethod(), responseObserver);
    }

    /**
     */
    default void setFiveDoubles(ser.grpc.FiveDoubles request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetFiveDoublesMethod(), responseObserver);
    }

    /**
     */
    default void setFiveDoublesSequence(ser.grpc.FiveDoublesSeq request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetFiveDoublesSequenceMethod(), responseObserver);
    }

    /**
     */
    default void setMixed(ser.grpc.Mixed request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetMixedMethod(), responseObserver);
    }

    /**
     */
    default void setMixedSequence(ser.grpc.MixedSeq request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetMixedSequenceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service STest.
   */
  public static abstract class STestImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return STestGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service STest.
   */
  public static final class STestStub
      extends io.grpc.stub.AbstractAsyncStub<STestStub> {
    private STestStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected STestStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new STestStub(channel, callOptions);
    }

    /**
     */
    public void setDummy(ser.grpc.Empty request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetDummyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setPerson(ser.grpc.Person request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetPersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setPersonSequence(ser.grpc.PersonSeq request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetPersonSequenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setFiveDoubles(ser.grpc.FiveDoubles request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetFiveDoublesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setFiveDoublesSequence(ser.grpc.FiveDoublesSeq request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetFiveDoublesSequenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMixed(ser.grpc.Mixed request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMixedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setMixedSequence(ser.grpc.MixedSeq request,
        io.grpc.stub.StreamObserver<ser.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMixedSequenceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service STest.
   */
  public static final class STestBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<STestBlockingStub> {
    private STestBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected STestBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new STestBlockingStub(channel, callOptions);
    }

    /**
     */
    public ser.grpc.Empty setDummy(ser.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetDummyMethod(), getCallOptions(), request);
    }

    /**
     */
    public ser.grpc.Empty setPerson(ser.grpc.Person request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetPersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public ser.grpc.Empty setPersonSequence(ser.grpc.PersonSeq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetPersonSequenceMethod(), getCallOptions(), request);
    }

    /**
     */
    public ser.grpc.Empty setFiveDoubles(ser.grpc.FiveDoubles request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetFiveDoublesMethod(), getCallOptions(), request);
    }

    /**
     */
    public ser.grpc.Empty setFiveDoublesSequence(ser.grpc.FiveDoublesSeq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetFiveDoublesSequenceMethod(), getCallOptions(), request);
    }

    /**
     */
    public ser.grpc.Empty setMixed(ser.grpc.Mixed request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMixedMethod(), getCallOptions(), request);
    }

    /**
     */
    public ser.grpc.Empty setMixedSequence(ser.grpc.MixedSeq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMixedSequenceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service STest.
   */
  public static final class STestFutureStub
      extends io.grpc.stub.AbstractFutureStub<STestFutureStub> {
    private STestFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected STestFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new STestFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ser.grpc.Empty> setDummy(
        ser.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetDummyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ser.grpc.Empty> setPerson(
        ser.grpc.Person request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetPersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ser.grpc.Empty> setPersonSequence(
        ser.grpc.PersonSeq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetPersonSequenceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ser.grpc.Empty> setFiveDoubles(
        ser.grpc.FiveDoubles request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetFiveDoublesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ser.grpc.Empty> setFiveDoublesSequence(
        ser.grpc.FiveDoublesSeq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetFiveDoublesSequenceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ser.grpc.Empty> setMixed(
        ser.grpc.Mixed request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMixedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ser.grpc.Empty> setMixedSequence(
        ser.grpc.MixedSeq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMixedSequenceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_DUMMY = 0;
  private static final int METHODID_SET_PERSON = 1;
  private static final int METHODID_SET_PERSON_SEQUENCE = 2;
  private static final int METHODID_SET_FIVE_DOUBLES = 3;
  private static final int METHODID_SET_FIVE_DOUBLES_SEQUENCE = 4;
  private static final int METHODID_SET_MIXED = 5;
  private static final int METHODID_SET_MIXED_SEQUENCE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_DUMMY:
          serviceImpl.setDummy((ser.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<ser.grpc.Empty>) responseObserver);
          break;
        case METHODID_SET_PERSON:
          serviceImpl.setPerson((ser.grpc.Person) request,
              (io.grpc.stub.StreamObserver<ser.grpc.Empty>) responseObserver);
          break;
        case METHODID_SET_PERSON_SEQUENCE:
          serviceImpl.setPersonSequence((ser.grpc.PersonSeq) request,
              (io.grpc.stub.StreamObserver<ser.grpc.Empty>) responseObserver);
          break;
        case METHODID_SET_FIVE_DOUBLES:
          serviceImpl.setFiveDoubles((ser.grpc.FiveDoubles) request,
              (io.grpc.stub.StreamObserver<ser.grpc.Empty>) responseObserver);
          break;
        case METHODID_SET_FIVE_DOUBLES_SEQUENCE:
          serviceImpl.setFiveDoublesSequence((ser.grpc.FiveDoublesSeq) request,
              (io.grpc.stub.StreamObserver<ser.grpc.Empty>) responseObserver);
          break;
        case METHODID_SET_MIXED:
          serviceImpl.setMixed((ser.grpc.Mixed) request,
              (io.grpc.stub.StreamObserver<ser.grpc.Empty>) responseObserver);
          break;
        case METHODID_SET_MIXED_SEQUENCE:
          serviceImpl.setMixedSequence((ser.grpc.MixedSeq) request,
              (io.grpc.stub.StreamObserver<ser.grpc.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSetDummyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ser.grpc.Empty,
              ser.grpc.Empty>(
                service, METHODID_SET_DUMMY)))
        .addMethod(
          getSetPersonMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ser.grpc.Person,
              ser.grpc.Empty>(
                service, METHODID_SET_PERSON)))
        .addMethod(
          getSetPersonSequenceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ser.grpc.PersonSeq,
              ser.grpc.Empty>(
                service, METHODID_SET_PERSON_SEQUENCE)))
        .addMethod(
          getSetFiveDoublesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ser.grpc.FiveDoubles,
              ser.grpc.Empty>(
                service, METHODID_SET_FIVE_DOUBLES)))
        .addMethod(
          getSetFiveDoublesSequenceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ser.grpc.FiveDoublesSeq,
              ser.grpc.Empty>(
                service, METHODID_SET_FIVE_DOUBLES_SEQUENCE)))
        .addMethod(
          getSetMixedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ser.grpc.Mixed,
              ser.grpc.Empty>(
                service, METHODID_SET_MIXED)))
        .addMethod(
          getSetMixedSequenceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ser.grpc.MixedSeq,
              ser.grpc.Empty>(
                service, METHODID_SET_MIXED_SEQUENCE)))
        .build();
  }

  private static abstract class STestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    STestBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ser.grpc.STestProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("STest");
    }
  }

  private static final class STestFileDescriptorSupplier
      extends STestBaseDescriptorSupplier {
    STestFileDescriptorSupplier() {}
  }

  private static final class STestMethodDescriptorSupplier
      extends STestBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    STestMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (STestGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new STestFileDescriptorSupplier())
              .addMethod(getSetDummyMethod())
              .addMethod(getSetPersonMethod())
              .addMethod(getSetPersonSequenceMethod())
              .addMethod(getSetFiveDoublesMethod())
              .addMethod(getSetFiveDoublesSequenceMethod())
              .addMethod(getSetMixedMethod())
              .addMethod(getSetMixedSequenceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
