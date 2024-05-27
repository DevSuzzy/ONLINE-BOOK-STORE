package com.susancode.onlinebookstore.exception;

import com.susancode.onlinebookstore.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;
/**
 * This is a Global controller advice for handling exceptions and providing consistent error responses.
 * it defines exception handlers for various types of exceptions,
 * including not found, bad request, unauthorized, and general exceptions.
 * it also implements method argument validation handler for handling validation errors in request payloads.
 */


@RestControllerAdvice
@Slf4j
public class GenericControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = { NotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex , new ApiResponse(false,  ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { BadRequestException.class, InterruptedException.class })
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex , new ApiResponse(false,  ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { UnAuthorized.class })
    protected ResponseEntity<Object> handleUnAuthorized(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex , new ApiResponse(false,  ex.getMessage()), new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex , new ApiResponse(false,  ex.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();

        Optional<FieldError> error = bindingResult.getFieldErrors().stream().findFirst();
        String message = "bad request";
        if (error.isPresent()) {
            message = error.get().getDefaultMessage();
        }

        return new ResponseEntity<>(new ApiResponse<>(false, message), HttpStatus.BAD_REQUEST);
    }
}
