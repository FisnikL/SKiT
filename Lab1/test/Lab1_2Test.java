import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class Lab1_2Test {

    Lab1_2 lab12;

    @BeforeEach
    void setUp() {
        lab12 = new Lab1_2();
    }

    @Test
    public void testNumberZero(){
        assertFalse(lab12.IsPowerOfTwo(0));
    }

    @Test
    public void testNumberOne(){
        assertTrue(lab12.IsPowerOfTwo(1));
    }

    @Test
    public void testTrueValue(){
        assertTrue(lab12.IsPowerOfTwo(2048));
    }

    @Test
    public void testFalseValue(){
        assertFalse(lab12.IsPowerOfTwo(5));
    }

    @Test
    public void testEvenNegativeNumber(){
        assertFalse(lab12.IsPowerOfTwo(-10));
    }

    @Test
    public void testOddNegativeNumber(){
        assertFalse(lab12.IsPowerOfTwo(-5));
    }

    @Test
    public void testPowerOfTwoNegativeNumber(){

    }

    @Test
    public void testPowerOfTwoNegativeLargeNumber(){
        // 1,073,741,824
        assertFalse(lab12.IsPowerOfTwo(-1073741824));
    }

    @Test
    public void testNullValue(){
        assertThrows(NullPointerException.class, () -> lab12.IsPowerOfTwo(null));
    }

    @ParameterizedTest
    @MethodSource("powerOfTwoNumbers")
    public void testWithParametersAndMethodSource(int inputNumber, boolean expectedResult){
        assertEquals(expectedResult, lab12.IsPowerOfTwo(inputNumber));
    }

    // PARAMETERS
    public static Collection<Object[]> powerOfTwoNumbers() {
        return Arrays.asList(new Object[][]{
                {32, true},
                {67, false},
                {313, false},
                {2048, true},
                {1073741824, true}
        });
    }
}
