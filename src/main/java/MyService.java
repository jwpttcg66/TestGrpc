import com.googlecode.protobuf.format.JsonFormat;
import com.mattie.grpc.GreeterGrpc;
import com.mattie.grpc.HelloWorldProtos;
import io.grpc.stub.StreamObserver;

public class MyService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloWorldProtos.HelloRequest request, StreamObserver<HelloWorldProtos.HelloReply> responseObserver) {
        HelloWorldProtos.HelloReply helloReply = HelloWorldProtos.HelloReply.newBuilder().setMessage("hello client.").build();
//        try {
//            String helloReplyFormat = JsonFormat.printer().print(helloReply);
//            System.out.println("hello client : " + helloReplyFormat);
//        }catch (Exception e) {
//            System.out.println(e);
//        }
        JsonFormat format = new JsonFormat();
        String json = format.printToString(helloReply);
        System.out.println("hello client : " + json);


        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }
}