package ru.service.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.service.adapter.service.CalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {

    @Autowired
    CalculatorService calculatorService;

    @Test
    public void addTest(){
        Assert.assertTrue(calculatorService.add(2,5) == 7);
    }

    @Test
    public void divideTest(){
        Assert.assertTrue(calculatorService.divide(4,2) == 2);
    }

    @Test
    public void multiplyTest(){
        Assert.assertTrue(calculatorService.multiply(4,2) == 8);
    }

    @Test
    public void subtractTest(){
        Assert.assertTrue(calculatorService.subtract(8,2) == 6);
    }

}
