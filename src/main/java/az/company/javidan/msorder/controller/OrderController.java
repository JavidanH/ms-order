package az.company.javidan.msorder.controller;


import az.company.javidan.msorder.model.request.CreateOrderRequest;
import az.company.javidan.msorder.model.response.OrderResponse;
import az.company.javidan.msorder.service.abstraction.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody CreateOrderRequest createOrderRequest){
        orderService.createOrder(createOrderRequest);
    }


    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id){

        return orderService.getOrderById(id);
    }
}
