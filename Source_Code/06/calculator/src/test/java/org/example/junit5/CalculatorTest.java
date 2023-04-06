package org.example.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test methods of Calculator class")
class CalculatorTest {
    @DisplayName("Test 10/5 = 2")
    @Test
    void testIntegerDivision_WhenTenIsDividedByFive_ShouldReturnTwo() {
        // Arrange
        Calculator calculator = new Calculator();
        // Act
        int result = calculator.integerDivision(10, 5);
        // Assert
        assertEquals(2, result, "4/2 didn't produce 2 as expected");
    }

    /**
     * One way to disable a unit test is to comment it
     * Not recommended, since test is not executed and shown
     * in the test results (console)
     */
    @DisplayName("Test 15-5 = 10 (first way)")
    // @Test
    void testIntegerSubtraction_WhenFiveIsSubtractedFromFifteen_ShouldReturnTen() {
        // Arrange
        Calculator calculator = new Calculator();
        // Act
        int result = calculator.integerSubtraction(15, 5);
        // Assert
        assertEquals(10,result, "15 - 5 didn't produce 10 as expected");
    }

    /**
     * Second way to disable a unit test is to use the @Disabled annotation
     * Far better when compared with the option that only comments the test,
     * since that although the test is not executed it is shown
     * in the test results (console)
     */
    @Disabled("TODO: Need to improve the implementation of this unit test")
    @DisplayName("Test 15-5 = 10 (second way)")
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

    @DisplayName("Test 15-5 = 10 (third way")
    @Test
    void integerSubtractionThirdWayWithLambdaExpression() {
        // Arrange
        Calculator calculator = new Calculator();
        int minuend = 15;
        int subtrahend = 5;
        int expectedResult = 10;
        // Act
        int result = calculator.integerSubtraction(minuend, subtrahend);
        // Assert
        assertEquals(expectedResult,result,
                () -> minuend + "-" + subtrahend + " didn't produce " + expectedResult);
    }
}