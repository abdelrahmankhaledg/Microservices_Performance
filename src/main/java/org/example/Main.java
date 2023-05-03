package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(5003).addService(new TopTenServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }
}