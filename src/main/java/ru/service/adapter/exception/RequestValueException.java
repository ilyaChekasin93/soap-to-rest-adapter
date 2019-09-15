package ru.service.adapter.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.service.adapter.model.error.ValidationError;

import java.util.List;

@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestValueException extends RuntimeException {

    private List<ValidationError> errors;

    public RequestValueException(List<ValidationError> errors) {
        this.errors = errors;
    }
}
