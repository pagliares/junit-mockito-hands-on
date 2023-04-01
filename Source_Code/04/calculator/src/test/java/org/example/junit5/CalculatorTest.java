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
}