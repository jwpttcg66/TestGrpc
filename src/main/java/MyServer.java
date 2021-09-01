import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class MyServer {

    public static void main(String[] args) {
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(8899);
        serverBuilder.addService(new MyService());
        serverBuilder.addService(ProtoReflectionService.newInstance());
        Server server = serverBuilder.build();
        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}