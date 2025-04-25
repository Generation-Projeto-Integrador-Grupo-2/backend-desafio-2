package com.rebu98.rebu98.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadrao> handleValidationException(MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        String mensagem = "Erro de validação: " + fieldErrors.toString();
        ErroPadrao erro = new ErroPadrao(HttpStatus.BAD_REQUEST.value(), "Bad Request", mensagem,
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErroPadrao> handleResponseStatusException(ResponseStatusException ex,
            HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(ex.getStatusCode().value(), ex.getReason(),
                ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(ex.getStatusCode()).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroPadrao> handleGenericException(Exception ex,
            HttpServletRequest request) {
        ErroPadrao erro = new ErroPadrao(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro Interno",
                ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}
