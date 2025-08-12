package az.company.javidan.msorder.repository;

import az.company.javidan.msorder.dao.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
