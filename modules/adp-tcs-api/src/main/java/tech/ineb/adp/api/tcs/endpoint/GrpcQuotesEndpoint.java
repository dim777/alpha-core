package tech.ineb.adp.api.tcs.endpoint;

import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ineb.protogen.QuotesRequest;
import tech.ineb.protogen.QuotesResponse;
import tech.ineb.protogen.QuotesServiceGrpc;

@Service @Slf4j
public class GrpcQuotesEndpoint extends QuotesServiceGrpc.QuotesServiceImplBase {


  @Override public void getQuotesFile(QuotesRequest request, StreamObserver<QuotesResponse> responseObserver) {
    String requestId = request.getRequestId().getValue();

    //do some job


    StringValue responseId = StringValue.newBuilder()
        .setValue(requestId)
        .build();

    QuotesResponse response = QuotesResponse.newBuilder()
        .setResponseId(responseId)
        .setUrl("")
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
