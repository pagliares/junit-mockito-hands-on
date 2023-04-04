package org.example.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void integerDivision() {
        // Arrange
        Calculator calculator = new Calculator();
        // Act
        int result = calculator.integerDivision(10, 5);
        // Assert (first way)
        assertEquals(2, result, "4/2 didn't produce 2 as expected");
        // Assert (second way)
        // if (result != 2)
        //   fail("4/2 didn't produce 2 as expected");
    }

    @Test
    void integerSubtraction() {
        // Arrange
        Calculator calculator = new Calculator();
        // Act
        int result = calculator.integerSubtraction(15, 5);
        // Assert
        assertEquals(10,result, "15 - 5 didn't produce 10 as expected");
    }

    @Test
    void integerSubtractionSecondWayWithVariables() {
        // Arrange
        Calculator calculator = new Calculator();
        int minuend = 15;
        int subtrahend = 5;
        int expectedResult = 10;
        // Act
        int result = calculator.integerSubtraction(minuend, subtrahend);
        // Assert
        assertEquals(expectedResult,result,
                minuend + "-" + subtrahend + " didn't produce " + expectedResult);
    }

    /**
     * This third way has better performance when compared with
     * the two previous ways, since the lambda expression
     * (third parameter) of the assertEquals is executed
     * ONLY when the test fails.
     **/
    @Test
    void integerSubtractionThirdWayWithLambdaExpression() {
        // Arrange
        Calculator calculator = new Calculator();
        int minuend = 15;
        int subtrahend = 5;
        int expectedResult = 10;
        // Act
        int result = calculator.integerSubtraction(minuend, subtrahend);
        // Assert (lambda expression in the third parameter)
        assertEquals(expectedResult,result,
                () -> minuend + "-" + subtrahend + " didn't produce " + expectedResult);
    }
}