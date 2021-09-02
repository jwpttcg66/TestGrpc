import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import org.apache.commons.cli.*;

import java.io.IOException;

public class MyServer {

    //   启动参数-p8899
    public static void main(String[] args) throws ParseException {

//        System.out.println("启动");
//
//        Options options = new Options();
//        options.addRequiredOption("p", "port", true, "Port to listen or send event to.");
//
//        CommandLineParser parser = new DefaultParser();
//        CommandLine cmd = parser.parse(options, args);
//
//        // If port string is not valid, it will throw an exception.
//        int port = Integer.parseInt(cmd.getOptionValue("port"));

        int port = 8899;
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