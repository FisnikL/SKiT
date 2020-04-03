import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Domashna3Test {
    Domashna3 domashna3;
    List<Integer> list;
    Integer el;

    @BeforeEach
    void setUp(){
        domashna3 = new Domashna3();
    }

    @Test
    public void testInterfaceBasedTest1_1(){
        list = Arrays.asList(1, 2, 3);
        el = 2;
        assertEquals(domashna3.findFirstLargerElementThan(list, el), 3);
    }

    @Test
    public void testInterfaceBasedTest1_2(){
        list = Arrays.asList(1, 2, 3);
        el = 5;
        assertNull(domashna3.findFirstLargerElementThan(list, el));
    }

    @Test
    public void testInterfaceBasedTest2(){
        list = Arrays.asList(1, 2, 3);
        el = null;
        assertThrows(NullPointerException.class, () -> domashna3.findFirstLargerElementThan(list, el));
    }

    @Test
    public void testInterfaceBasedTest3(){
        list = null;
        el = 10;
        assertThrows(NullPointerException.class, () -> domashna3.findFirstLargerElementThan(list, el));
    }

    @Test
    public void testInterfaceBasedTest4(){
        list = Arrays.asList();
        el = 10;
        assertNull(domashna3.findFirstLargerElementThan(list, el));
    }

    @Test
    public void testFunctionalBasedTest5(){
        list = Arrays.asList(1, 3, 5 ,7 ,9, 11);
        el = 6;
        assertEquals(domashna3.findFirstLargerElementThan(list, el), 7);
    }

    @Test
    public void testFunctionalBasedTest6(){
        list = Arrays.asList(1, 3, 5 ,7 ,9, 11);
        el = 0;
        assertEquals(domashna3.findFirstLargerElementThan(list, el), 1);
    }

    @Test
    public void testFunctionalBasedTest7(){
        list = Arrays.asList(1, 3, 5 ,7 ,9, 11);
        el = 10;
        assertEquals(domashna3.findFirstLargerElementThan(list, el), 11);
    }
}
