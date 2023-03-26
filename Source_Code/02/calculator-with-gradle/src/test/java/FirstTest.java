import org.junit.jupiter.api.Test;

public class FirstTest {
    // If you want to test in command-line, go to the project root folder
    // (the one with gradlew and build.gradle file) and run the command
    // ./gradlew clean test
    @Test
    public void testJUnit5Support(){
        System.out.println("Hello, cruel JUnit 5 (Jupiter) world !");
    }
}
