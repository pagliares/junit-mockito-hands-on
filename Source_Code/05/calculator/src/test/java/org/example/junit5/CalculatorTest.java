package org.example.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Heuristic to name test methods:
 * test<System Under Test>_<Condition or State Change>_<Expected_Result>
 **/

@DisplayName("Test methods of Calculator class")
class CalculatorTest {
    @DisplayName("Test 10/5 = 2")
    @Test
    void testIntegerDivision_WhenTenIsDividedByFive_ShouldReturnTwo() {
        // Arrange (a.k.a Given)
        Calculator calculator = new Calculator();
        // Act (a.k.a When)
        int result = calculator.integerDivision(10, 5);
        // Assert (first way) (a.k.a Then)
        assertEquals(2, result, "4/2 didn't produce 2 as expected");
        // Assert (second way)
        // if (result != 2)
        //   fail("4/2 didn't produce 2 as expected");
    }

    @DisplayName("Test 15-5 = 10 (first way)")
    @Test
    void testIntegerSubtraction_WhenFiveIsSubtractedFromFifteen_ShouldReturnTen() {
        // Arrange (a.k.a Given)
        Calculator calculator = new Calculator();
        // Act (a.k.a When)
        int result = calculator.integerSubtraction(15, 5);
        // Assert (a.k.a Then)
        assertEquals(10,result, "15 - 5 didn't produce 10 as expected");
    }

    @DisplayName("Test 15-5 = 10 (second way)")
    @Test
    void integerSubtractionSecondWayWithVariables() {
        // Arrange (a.k.a Given)
        Calculator calculator = new Calculator();
        int minuend = 15;
        int subtrahend = 5;
        int expectedResult = 10;
        // Act (a.k.a When)
        int result = calculator.integerSubtraction(minuend, subtrahend);
        // Assert (a.k.a Then)
        assertEquals(expectedResult,result,
                minuend + "-" + subtrahend + " didn't produce " + expectedResult);
    }

    /**
     * This third way has better performance when compared with
     * the two previous ways, since the lambda expression
     * (third parameter) of the assertEquals is executed
     * ONLY when the test fails.
     **/
    @DisplayName("Test 15-5 = 10 (third way")
    @Test
    void integerSubtractionThirdWayWithLambdaExpression() {
        // Arrange (a.k.a Given)
        Calculator calculator = new Calculator();
        int minuend = 15;
        int subtrahend = 5;
        int expectedResult = 10;
        // Act (a.k.a When)
        int result = calculator.integerSubtraction(minuend, subtrahend);
        // Assert (lambda expression in the third parameter) (a.k.a Then)
        assertEquals(expectedResult,result,
                () -> minuend + "-" + subtrahend + " didn't produce " + expectedResult);
    }
}