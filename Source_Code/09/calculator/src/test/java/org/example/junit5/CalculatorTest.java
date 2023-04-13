package org.example.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test methods of Calculator class")
class CalculatorTest {
    private Calculator calculator;

    // method used with @BeforeAll must be static!
    @BeforeAll
    static void setup(){
        System.out.println("Executing @BeforeAll method.\n");
    }

    // method used with @AfterAll must be static!
    @AfterAll
    static void cleanup(){
        System.out.println("\nExecuting @AfterAll method.");
    }

    @BeforeEach
    void beforeEachTestCaseMethod(){
        calculator = new Calculator();
        System.out.println("Executing @BeforeEach method.");
    }

    @AfterEach
    void afterEachTestCaseMethod(){
        System.out.println("Executing @AfterEach method.\n");
    }

    @DisplayName("Test 10/5 = 2")
    @Test
    void testIntegerDivision_WhenTenIsDividedByFive_ShouldReturnTwo() {
        System.out.println("Running Test 10/5 = 2");
        // Arrange - See beforeEachTestCaseMethod annotated with @BeforeEach

        // Act
        int result = calculator.integerDivision(10, 5);
        // Assert
        assertEquals(2, result, "4/2 didn't produce 2 as expected");
    }

    @DisplayName("Division by zero")
    @Test
    void testIntegerDivision_WhenFiveIsDividedByZero_ShouldThrowArithmeticException(){
        System.out.println("Running Test Division by zero");
        // Arrange - See beforeEachTestCaseMethod annotated with @BeforeEach
        int dividend = 5;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        // Act & Assert
        ArithmeticException exceptionThrown = assertThrows(ArithmeticException.class,() -> {
            // Act
            calculator.integerDivision(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic exception");

        // Assert
        assertEquals(expectedExceptionMessage,exceptionThrown.getMessage(),
                "Unexpected exception message");
    }

    /*
     If the name of the test case is equal the name of the static method that provide
     The arguments (source of input parameters), we can remove the name provided as parameter
     to @MethodSource("integerSubtractionInputParameters")

     Usually we don’t use System.out.println statements in Test cases.
     In this and previous examples I used only for educational reasons
    */
    @DisplayName("Test integer subtraction {minuend, subtrahend, expectedResult")
    @ParameterizedTest
    @MethodSource()
    void testIntegerSubtractionWithLambdaExpressionAndSeveralParameters(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Running Test " + minuend + "-" + subtrahend + " = " + expectedResult);
        // Arrange - See beforeEachTestCaseMethod annotated with @BeforeEach

        // Act
        int result = calculator.integerSubtraction(minuend, subtrahend);
        // Assert
        assertEquals(expectedResult,result,
                () -> minuend + "-" + subtrahend + " didn't produce " + expectedResult);
    }

    private static Stream<Arguments> testIntegerSubtractionWithLambdaExpressionAndSeveralParameters() {
        return Stream.of(
                Arguments.of(15, 5,10),
                Arguments.of(12, 24, -12),
                Arguments.of(10, 10, 0)
        );
    }
}