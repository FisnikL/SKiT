import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class Domashna7Test {

    @ParameterizedTest
    @MethodSource("values")
    void testPatternIndex(String subject, String pattern, int expectedResult) {
        System.out.println("Parameterized parameters are: (" + subject + ", " + pattern + ")");
        assertEquals(expectedResult, Domashna7.patternIndex(subject, pattern));
    }
    
    public static Collection<Object[]> values(){
        return Arrays.asList(new Object[][]{
                {"a", "a", 0},
                {"a", "ab", -1},
                {"a", "c", -1},
                {"ab", "ac", -1},
                {"ab", "ab", 0},
        });
    }
}
