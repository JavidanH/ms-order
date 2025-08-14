package az.company.javidan.msorder.model.client.reuqest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReduceQuantityRequest {
    private Long productId;
    private Integer quantity;
}
