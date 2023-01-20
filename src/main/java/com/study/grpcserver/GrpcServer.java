package com.study.grpcserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {
  private int port;
  private Server server;

  public GrpcServer(int port) {
    this.port = port;
    server = ServerBuilder.forPort(port)
        .addService(new MetricService())
        .build();
  }

  public void start() throws IOException {
    server.start();
  }

}
