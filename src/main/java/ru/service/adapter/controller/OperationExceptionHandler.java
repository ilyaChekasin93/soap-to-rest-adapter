package ru.service.adapter.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.service.adapter.model.error.OperationErrorResponse;
import ru.service.adapter.exception.RequestValueException;


@ControllerAdvice
@RestController
public class OperationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequestValueException.class)
    public final OperationErrorResponse handleOperationRequestValueException(RequestValueException e) {
        return new OperationErrorResponse(e.getErrors());
    }
}