package mm.be.mathematic_function;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicFunctionsTest {

    private BasicFunctions basicFunctions;


    @BeforeEach
    void setUp() {
        basicFunctions = new BasicFunctions();
    }


    @Test
    void addTwoNumbers() {
        assertEquals(954, basicFunctions.addTwoNumbers(256,698));


    }

    @Test
    void substractTwoNumbers() {
        assertEquals(-442,basicFunctions.substractTwoNumbers(256,698));
    }

    @Test
    void multiplyTwoNumbers() {
        assertEquals(178688,basicFunctions.multiplyTwoNumbers(256,698));
    }

    @Test
    void divideTwoNumbers() {
        assertTrue(String.valueOf(basicFunctions.divideTwoNumbers(256,698)).contains("0.3667621"));
    }
}