package com.study.grpcserver;

import com.nkia.ias.MetricRequest;
import com.nkia.ias.MetricResponse;
import com.nkia.ias.MetricServiceGrpc.MetricServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MetricService extends MetricServiceImplBase implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public StreamObserver<MetricRequest> metricStreamHandler(
      StreamObserver<MetricResponse> responseObserver) {
    return new StreamObserver<MetricRequest>() {
      int count = 0;

      @Override
      public void onNext(MetricRequest value) {
        count++;
        if(count == 10000) {
          System.out.println("Async last value: " + value.getMetricId() + " time: " + System.currentTimeMillis());
        }
      }

      @Override
      public void onError(Throwable t) {
        System.out.println("error");
      }

      @Override
      public void onCompleted() {
        System.out.println("Async onCompleted. time: " + System.currentTimeMillis());
        responseObserver.onNext(MetricResponse.newBuilder().setMessage("success").build());
        responseObserver.onCompleted();
//        System.out.println("Async size : " + count);
      }
    };
  }

  @Override
  public void metricHandler(MetricRequest request,
      StreamObserver<MetricResponse> responseObserver) {
    MetricResponse response = MetricResponse.newBuilder()
        .setMessage("success")
        .build();

//    System.out.println("[REQUEST] " + request.getMetricId() + request.getMetricName());
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    new Thread(() -> {
      GrpcServer server = new GrpcServer(8081);
      try {
        System.out.println("Grpc server Start");
        server.start();
      } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }).start();
  }
}
