package com.study.grpcserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcServerApplication {

  public static void main(String[] args) throws IOException {
    SpringApplication.run(GrpcServerApplication.class, args);

//    Thread serverThread = new Thread(() -> {
//      int port = 8081;
//      Server server = ServerBuilder
//          .forPort(port)
//          .addService(new MetricService())
//          .build();
//
//      try {
//        server.start();
//      } catch (IOException e) {
//        e.printStackTrace();
//        return;
//      }
//
//      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//        System.err.println("Server: Shutting down gRPC server");
//        server.shutdown();
//        System.err.println("Server: Server shut down");
//      }));
//
//      try {
//        server.awaitTermination();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    });
//    serverThread.start();
//  }

  }

}
