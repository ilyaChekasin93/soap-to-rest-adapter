package ru.service.adapter.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.service.adapter.exception.SoapResultException;
import ru.service.adapter.model.error.Error;
import ru.service.adapter.model.error.OperationErrorResponse;
import ru.service.adapter.exception.RequestValueException;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
@RestController
public class OperationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequestValueException.class)
    public final OperationErrorResponse handleOperationRequestValueException(RequestValueException e) {
        return new OperationErrorResponse(e.getErrors());
    }

    @ExceptionHandler(SoapResultException.class)
    public final OperationErrorResponse handleSoapResponseValueException(SoapResultException e) {
        List<Error> errors = new ArrayList();
        errors.add(e.getError());
        return new OperationErrorResponse(errors);
    }

}