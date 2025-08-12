package az.company.javidan.msorder.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {
}
