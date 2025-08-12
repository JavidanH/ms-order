package az.company.javidan.msorder.mapper;

import az.company.javidan.msorder.dao.entity.OrderEntity;
import az.company.javidan.msorder.model.enums.OrderStatus;
import az.company.javidan.msorder.model.request.CreateOrderRequest;
import az.company.javidan.msorder.model.response.OrderResponse;

import java.time.LocalDateTime;

public enum OrderMapper {
    ORDER_MAPPER;

    public OrderEntity buildOrderEntity (CreateOrderRequest createOrderRequest){
        return OrderEntity.builder()
                .productId(createOrderRequest.getProductId())
                .quantity(createOrderRequest.getQuantity())
                .amount(createOrderRequest.getAmount())
                .status(OrderStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();
    }


    public OrderResponse buildOrderResponse(OrderEntity orderEntity){
        return OrderResponse.builder()
                .id(orderEntity.getId())
                .productId(orderEntity.getProductId())
                .quantity(orderEntity.getQuantity())
                .amount(orderEntity.getAmount())
                .status(orderEntity.getStatus())
                .createdAt(orderEntity.getCreatedAt())
                .build();
    }
}
