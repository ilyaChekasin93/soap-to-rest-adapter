package ru.service.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.service.adapter.exception.RequestValueException;
import ru.service.adapter.mapper.Mapper;
import ru.service.adapter.model.OperationRequest;
import ru.service.adapter.model.OperationResponse;
import ru.service.adapter.service.CalculatorService;

import javax.validation.Valid;


@RestController
@RequestMapping("/calculator")
public class OperationController {

    @Autowired
    @Qualifier("operationRequestValidator")
    private Validator requestValidator;

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private Mapper mapper;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(requestValidator);
    }

    @PostMapping(path = "/add", produces = "application/json")
    public OperationResponse addNumbers(@RequestBody @Valid OperationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new RequestValueException(
                    mapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );

        return new OperationResponse(
                calculatorService.add(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

    @PostMapping(path = "/divide", produces = "application/json")
    public OperationResponse divideNumbers(@RequestBody @Valid OperationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new RequestValueException(
                    mapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );

        return new OperationResponse(
                calculatorService.divide(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

    @PostMapping(path = "/multiply", produces = "application/json")
    public OperationResponse multiplyNumbers(@RequestBody @Valid OperationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new RequestValueException(
                    mapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );

        return new OperationResponse(
                calculatorService.multiply(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

    @PostMapping(path = "/subtract", produces = "application/json")
    public OperationResponse subtractNumbers(@RequestBody @Valid OperationRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new RequestValueException(
                    mapper.objectErrorsToValidationErrors(
                            bindingResult.getAllErrors()
                    )
            );

        return new OperationResponse(
                calculatorService.subtract(
                        Integer.valueOf(request.getFirstNumber()),
                        Integer.valueOf(request.getSecondNumber())
                )
        );
    }

}
