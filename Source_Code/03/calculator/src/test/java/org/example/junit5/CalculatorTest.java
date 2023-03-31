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
        // Assert
        assertEquals(2, result);
    }
}