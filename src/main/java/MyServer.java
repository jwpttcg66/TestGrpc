import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class MyServer {

    private static final String GRPC_PORT = System.getenv("DAPR_GRPC_PORT");
    public static void main(String[] args) {
        System.out.println("启动");
        int port = Integer.parseInt(GRPC_PORT);
//        int port = 8899;
        System.out.println("端口" + port);
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
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