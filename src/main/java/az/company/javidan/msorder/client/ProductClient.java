package az.company.javidan.msorder.client;

import az.company.javidan.msorder.client.decoder.CustomErrorDecoder;
import az.company.javidan.msorder.model.client.reuqest.ReduceQuantityRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "ms-product",
              url = "http://localhost:8080",
configuration = CustomErrorDecoder.class)

public interface ProductClient {

    @PostMapping("/reduce-quantity")
     void reduceQuantity(@RequestBody ReduceQuantityRequest reduceQuantityRequest);
}
