package org.example.junit5;

import org.junit.jupiter.api.*;

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

    /**
     * One way to disable a unit test is to comment it
     * Not recommended, since test is not executed and shown
     * in the test results (console)
     */
    @DisplayName("Test 15-5 = 10 (first way)")
    // @Test
    void testIntegerSubtraction_WhenFiveIsSubtractedFromFifteen_ShouldReturnTen() {
        // Arrange - See beforeEachTestCaseMethod annotated with @BeforeEach
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
    @Disabled("TODO: Need to improve the implementation of this unit test\n")
    @DisplayName("Test 15-5 = 10 (second way)")
    @Test
    void integerSubtractionSecondWayWithVariables() {
        // Arrange - See beforeEachTestCaseMethod annotated with @BeforeEach
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
        System.out.println("Running Test 15-5 = 10");
        // Arrange - See beforeEachTestCaseMethod annotated with @BeforeEach
        int minuend = 15;
        int subtrahend = 5;
        int expectedResult = 10;
        // Act
        int result = calculator.integerSubtraction(minuend, subtrahend);
        // Assert
        assertEquals(expectedResult,result,
                () -> minuend + "-" + subtrahend + " didn't produce " + expectedResult);
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
}