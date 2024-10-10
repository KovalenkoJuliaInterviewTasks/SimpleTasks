import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

class MainTest {
    private static final int N_NUMBERS = 1_000_000;
    String word = "electricity";

    @Test
    void testAnagramTrue() {
        assertTrue(Main.isAnagram(word, "electric"));
        assertTrue(Main.isAnagram(word, "city"));
        assertTrue(Main.isAnagram(word, "tric"));
        assertTrue(Main.isAnagram(word, "try"));
        assertTrue(Main.isAnagram(word, "let"));
        assertTrue(Main.isAnagram(word, "tet"));
    }

    @Test
    void testAnagramFalse() {
        assertFalse(Main.isAnagram(word, " "));
        assertFalse(Main.isAnagram(word, ""));
        assertFalse(Main.isAnagram(word, null));
        assertFalse(Main.isAnagram(word, "tetet"));
        assertFalse(Main.isAnagram(word, "ci ty"));
        assertFalse(Main.isAnagram(word, "a"));
    }

    @Test
    public void squareTest() {
        Assertions.assertEquals(100, Main.square(10));
        Assertions.assertEquals(100, Main.square(-10));
    }

    @Test
    public void isSubstringTest() {
        String str = "blobloblobloblokbloblo.";
        assertTrue(Main.isSubstring(str, "blok"));
        assertTrue(Main.isSubstring(str, "kblob"));
        assertTrue(Main.isSubstring(str, "oblo."));
        assertFalse(Main.isSubstring(str, "blod"));
        assertFalse(Main.isSubstring(str, "bok"));
        assertFalse(Main.isSubstring(str, "loko"));
    }

    @Test
    void isSumTwo() {
        short[] array = {30000, 1, 5, 2, 10000, 0, 500, 0};
        short[] array1 = {30000, 1, 5, 2, 10000, 0, 500, 0, Short.MAX_VALUE};
        assertTrue(Main.isSumTwo(array, (short) 30000));
        assertTrue(Main.isSumTwo(array, (short) 7));
        assertFalse(Main.isSumTwo(array, (short) 30003));
        assertFalse(Main.isSumTwo(array, (short) 8));
        assertTrue(Main.isSumTwo(array1, Short.MIN_VALUE));
    }

    @Test
    void sort() {
        short[] array = getRandomArray();
        Main.sort(array);
        assertEquals(N_NUMBERS, array.length);
        for (int i = 1; i < array.length; i++) {
            assertTrue(array[i - 1] <= array[i]);
        }

    }

    private short[] getRandomArray() {
        short[] res = new short[N_NUMBERS];
        for (int i = 0; i < N_NUMBERS; i++) {
            res[i] = (short) (Math.random() * Short.MAX_VALUE);
        }
        return res;
    }

    @Test
    void getMaxWithNegativePresentation() {
        short[] array = {1, 1, 1, -1, 20, 100, 200, 100, -100, -100, -20, -40, 80};
        short[] array1 = {-40, 1, -40, -6, 2, 3, 40};
        short[] array2 = {40, 1, 2, 3, 40, -30};
        assertEquals(100, Main.getMaxWithNegativePresentation(array));
        assertEquals(40, Main.getMaxWithNegativePresentation(array1));
        assertEquals(-1, Main.getMaxWithNegativePresentation(array2));

    }
}