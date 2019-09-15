package ru.service.adapter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.service.adapter.client.*;
import ru.service.adapter.service.CalculatorService;
import ru.service.adapter.wsdl.*;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private CalculatorSOAPClient calculatorSOAPClient;

    @Autowired
    public CalculatorServiceImpl(CalculatorSOAPClient calculatorSOAPClient){
        this.calculatorSOAPClient = calculatorSOAPClient;
    }

    public int add(int firstNumber, int secondNumber) {
        Add add = new Add();
        add.setIntA(firstNumber);
        add.setIntB(secondNumber);
        return calculatorSOAPClient.add(add).getAddResult();
    }

    public int divide(int firstNumber, int secondNumber) {
        Divide divide = new Divide();
        divide.setIntA(firstNumber);
        divide.setIntB(secondNumber);
        return calculatorSOAPClient.divide(divide).getDivideResult();
    }

    public int multiply(int firstNumber, int secondNumber) {
        Multiply multiply = new Multiply();
        multiply.setIntA(firstNumber);
        multiply.setIntB(secondNumber);
        return calculatorSOAPClient.multiply(multiply).getMultiplyResult();
    }

    public int subtract(int firstNumber, int secondNumber) {
        Subtract subtract = new Subtract();
        subtract.setIntA(firstNumber);
        subtract.setIntB(secondNumber);
        return calculatorSOAPClient.subtract(subtract).getSubtractResult();
    }

}
