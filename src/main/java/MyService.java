import com.mattie.grpc.GreeterGrpc;
import com.mattie.grpc.HelloWorldProtos;
import io.grpc.stub.StreamObserver;

public class MyService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloWorldProtos.HelloRequest request, StreamObserver<HelloWorldProtos.HelloReply> responseObserver) {
        HelloWorldProtos.HelloReply helloReply = HelloWorldProtos.HelloReply.newBuilder().setMessage("hello client.").build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }
}