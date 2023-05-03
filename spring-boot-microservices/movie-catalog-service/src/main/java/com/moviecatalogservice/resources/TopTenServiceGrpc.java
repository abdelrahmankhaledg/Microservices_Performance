package com.moviecatalogservice.resources;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: lab2_data_prototest.proto")
public final class TopTenServiceGrpc {

  private TopTenServiceGrpc() {}

  public static final String SERVICE_NAME = "TopTenService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<EmptyRequest,
          TopTenMoviesResponse> METHOD_GET_TOP_TEN_MOVIES =
      io.grpc.MethodDescriptor.<EmptyRequest, TopTenMoviesResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "TopTenService", "getTopTenMovies"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              EmptyRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              TopTenMoviesResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TopTenServiceStub newStub(io.grpc.Channel channel) {
    return new TopTenServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TopTenServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TopTenServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TopTenServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TopTenServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TopTenServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTopTenMovies(EmptyRequest request,
                                io.grpc.stub.StreamObserver<TopTenMoviesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TOP_TEN_MOVIES, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_TOP_TEN_MOVIES,
            asyncUnaryCall(
              new MethodHandlers<
                      EmptyRequest,
                      TopTenMoviesResponse>(
                  this, METHODID_GET_TOP_TEN_MOVIES)))
          .build();
    }
  }

  /**
   */
  public static final class TopTenServiceStub extends io.grpc.stub.AbstractStub<TopTenServiceStub> {
    private TopTenServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TopTenServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TopTenServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TopTenServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTopTenMovies(EmptyRequest request,
                                io.grpc.stub.StreamObserver<TopTenMoviesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TOP_TEN_MOVIES, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TopTenServiceBlockingStub extends io.grpc.stub.AbstractStub<TopTenServiceBlockingStub> {
    private TopTenServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TopTenServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TopTenServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TopTenServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public TopTenMoviesResponse getTopTenMovies(EmptyRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TOP_TEN_MOVIES, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TopTenServiceFutureStub extends io.grpc.stub.AbstractStub<TopTenServiceFutureStub> {
    private TopTenServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TopTenServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TopTenServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TopTenServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TopTenMoviesResponse> getTopTenMovies(
        EmptyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TOP_TEN_MOVIES, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TOP_TEN_MOVIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TopTenServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TopTenServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOP_TEN_MOVIES:
          serviceImpl.getTopTenMovies((EmptyRequest) request,
              (io.grpc.stub.StreamObserver<TopTenMoviesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class TopTenServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Lab2DataPrototest.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TopTenServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TopTenServiceDescriptorSupplier())
              .addMethod(METHOD_GET_TOP_TEN_MOVIES)
              .build();
        }
      }
    }
    return result;
  }
}
