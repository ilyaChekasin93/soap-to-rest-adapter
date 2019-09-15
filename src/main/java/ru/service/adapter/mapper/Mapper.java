package ru.service.adapter.mapper;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import ru.service.adapter.model.error.ValidationError;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public List<ValidationError> objectErrorsToValidationErrors(List<ObjectError> errors){
        return errors.stream()
                .map(er -> {
                    return er instanceof FieldError ?
                            new ValidationError(((FieldError) er).getField() + " " + er.getDefaultMessage()) :
                            new ValidationError(er.getDefaultMessage());
                }).collect(Collectors.toList());
    }

}
