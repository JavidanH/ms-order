package az.company.javidan.msorder.service.abstraction;

import az.company.javidan.msorder.model.request.CreateOrderRequest;
import az.company.javidan.msorder.model.response.OrderResponse;

public interface OrderService {
    void createOrder(CreateOrderRequest createOrderRequest);

    OrderResponse getOrderById(Long id);

}
