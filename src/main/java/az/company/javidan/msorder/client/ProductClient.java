package az.company.javidan.msorder.client;

import az.company.javidan.msorder.client.decoder.CustomErrorDecoder;
import az.company.javidan.msorder.model.client.response.ProductResponse;
import az.company.javidan.msorder.model.client.reuqest.ReduceQuantityRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-product",
              url = "http://localhost:8080/v1/products",
configuration = CustomErrorDecoder.class)

public interface ProductClient {

    @PostMapping("/reduce-quantity")
     void reduceQuantity(@RequestBody ReduceQuantityRequest reduceQuantityRequest);

    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable Long id);
}
