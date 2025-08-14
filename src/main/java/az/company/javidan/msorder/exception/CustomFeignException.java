package az.company.javidan.msorder.exception;

public class CustomFeignException extends RuntimeException{
    public CustomFeignException(String message) {
        super(message);
    }
}
