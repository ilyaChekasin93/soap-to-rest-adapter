package ru.service.adapter.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.service.adapter.model.OperationRequest;


@Component
public class OperationRequestValidator implements Validator {


    private static final String VALUE_SHOULD_HAVE_TYPE_INT = "значение должно иметь тип int";
    private static final String VALUE_MUST_NOT_BE_NULL = "значение не может отсутствовать";
    private static final String VALUE_CANNOT_BE_EMPTY = "значение не может быть пустым";

    private static final String VALUE_NEGATIVE = "value.negative";


    @Override
    public boolean supports(Class<?> aClass) {
        return OperationRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        OperationRequest request = (OperationRequest) obj;
        fieldValidate("firstNumber", request.getFirstNumber(), errors);
        fieldValidate("secondNumber", request.getSecondNumber(), errors);
    }

    private void fieldValidate(String fieldName, String fieldValue, Errors errors){
        if (fieldValue == null) {
            errors.rejectValue(fieldName, VALUE_NEGATIVE, VALUE_MUST_NOT_BE_NULL);
        } else if (fieldValue.equals("")) {
            errors.rejectValue(fieldName, VALUE_NEGATIVE, VALUE_CANNOT_BE_EMPTY);
        } else if (!isInteger(fieldValue)) {
            errors.rejectValue(fieldName, VALUE_NEGATIVE, VALUE_SHOULD_HAVE_TYPE_INT);
        }
    }

    private static boolean isInteger(String str)
    {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
}