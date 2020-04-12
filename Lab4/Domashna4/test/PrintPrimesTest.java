import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintPrimesTest {
    @Test
    public void test1(){
        int n = 1;
        String expected = "Prime: " + 2;
        assertEquals(expected, PrintPrimes.printPrimes(n));
    }

    @Test
    public void test2(){
        int n = 5;
        String expected;
        StringBuilder sb = new StringBuilder();
        sb.append("Prime: " + 2 + "\n");
        sb.append("Prime: " + 3 + "\n");
        sb.append("Prime: " + 5 + "\n");
        sb.append("Prime: " + 7 + "\n");
        sb.append("Prime: " + 11);
        expected = sb.toString();

        assertEquals(expected, PrintPrimes.printPrimes(n));
    }
}
