package az.company.javidan.msorder.service.concrete;

import az.company.javidan.msorder.client.ProductClient;
import az.company.javidan.msorder.exception.NotFoundException;
import az.company.javidan.msorder.model.client.reuqest.ReduceQuantityRequest;
import az.company.javidan.msorder.model.enums.ErrorMessage;
import az.company.javidan.msorder.model.enums.OrderStatus;
import az.company.javidan.msorder.model.request.CreateOrderRequest;
import az.company.javidan.msorder.model.response.OrderResponse;
import az.company.javidan.msorder.repository.OrderRepository;
import az.company.javidan.msorder.service.abstraction.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static az.company.javidan.msorder.mapper.OrderMapper.ORDER_MAPPER;


@Service
@RequiredArgsConstructor
public class OrderServiceHandler implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    @Override
    @Transactional
    public void createOrder(CreateOrderRequest createOrderRequest) {
        var orderEntity = ORDER_MAPPER.buildOrderEntity(createOrderRequest);

        var productResponse = productClient.getProductById(createOrderRequest.getProductId());

        orderEntity.setAmount(productResponse
                .getPrice()
                   .multiply(
                      BigDecimal.valueOf(createOrderRequest.getQuantity())));

        var reduceQuantityRequest = new ReduceQuantityRequest(
                createOrderRequest.getProductId(),
                createOrderRequest.getQuantity()
        );

        orderRepository.save(orderEntity);
        try {
            productClient.reduceQuantity(reduceQuantityRequest);
            orderEntity.setStatus(OrderStatus.APPROVED);

        } catch (Exception  e){
            orderEntity.setStatus(OrderStatus.REJECTED);
        }

    }

    @Override
    public OrderResponse getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(ORDER_MAPPER :: buildOrderResponse)
                .orElseThrow(() -> new NotFoundException(String.format
                        (ErrorMessage.ORDER_NOT_FOUND
                                .getMessage(),id
                        )));
    }
}
