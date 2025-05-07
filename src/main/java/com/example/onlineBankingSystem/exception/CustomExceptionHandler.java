package com.example.onlineBankingSystem.exception;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = InsufficientBalanceException.class)
    public ResponseEntity<CustomErrorResponse> handleInsufficientBalanceException(InsufficientBalanceException ex, WebRequest request)
    {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<CustomErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleInsufficientBalanceException(AccountNotFoundException ex, WebRequest request)
    {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<CustomErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TransactionNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleInsufficientBalanceException(TransactionNotFoundException ex, WebRequest request)
    {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<CustomErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
