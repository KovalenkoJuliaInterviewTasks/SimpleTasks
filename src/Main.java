import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public static int maxSubsequenceLength(int[] arr) {
//    The method accepts array of integers and returns the length of longest sub-sequence, consisting of repeating number.
//    For example, if input is 1,3,3,2,8,8,8,5,6,6 the result is 3 - the length of longest subsequence 8,8,8
//    The non-repeating number would  be considered as "subsequence of length 1".
//    The result for empty array would be 0.
//    Write it in one pass through array.
        return 0;
    }

    private static String openingBrackets = "([{";
    private static String closingBrackets = ")]}";

    public static boolean hasValidBrackets(String text) {
//        Check that 3 types of brackets: (), [], {} are used properly in text represented by String.
//        The brackets could be nested. Without using collection
//        Correct nesting example:	aaaaaa (sdfsdfdsf[dfd(f)f] zcvzxcv {{[ghjk]}} asd )
//        Incorrect examples:
//        a. invalid brackets order   )dfgswfgsf(
//        b. invlaid nesting order:   [werwert(wertwrtw] wertrt)
        StringBuilder bracketsStack = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (openingBrackets.indexOf(text.charAt(i)) >= 0)
                bracketsStack.append(text.charAt(i));
            else if (closingBrackets.indexOf(text.charAt(i)) >= 0) {
                if (bracketsStack.isEmpty() || !removeIfCouple(bracketsStack, text.charAt(i)))
                    return false;
            }
        }
        return bracketsStack.isEmpty();
    }

    private static boolean removeIfCouple(StringBuilder bracketsStack, char closingBracket) {
        char coupledOpeningBracket = openingBrackets.charAt(closingBrackets.indexOf(closingBracket));
        char lastStackBracket = bracketsStack.charAt(bracketsStack.length() - 1);
        if (lastStackBracket == coupledOpeningBracket) {
            bracketsStack.deleteCharAt(bracketsStack.length() - 1);
            return true;
        }
        return false;
    }

    public static boolean isAnagram(String word, String anagram) {
        if (word == null || word.isBlank() || anagram == null || anagram.isBlank())
            return false;
        if (anagram.length() > word.length())
            return false;

        char[] letters = word.toCharArray();

        Map<Character, Integer> res = new HashMap<>();

        for (Character c : letters) {
            res.merge(c, 1, (o, v) -> o + v);
        }

        char[] lettersAnagram = anagram.toCharArray();
        for (Character c : lettersAnagram) {
            int count = res.merge(c, -1, Integer::sum);
            if (count == -1)
                return false;
        }
        return true;
    }

    public static int square(int x) {
        //TODO
        //returns x ^ 2
        //With following limitations
        //No cycles
        //No any additional methods
        //No static fields
        // Only + ; - arithmetic operations
        int res = 0;
        if (x != 0) {
            res = x < 0 ? square(-x) : x + x - 1 + square(x - 1);
        }
        return res;
    }

    public static boolean isSubstring(String string, String substr) {
        //TODO
        // returns true if a given 'substr' is indeed the //substring of a given `string`
	/*
	  Challenges:
	 1. To apply only following methods of the class String: charAt(int ind);
	String substring(int ind);
	 int length();
	2. No cycles;
	*/
        if (string.length() < substr.length()) {
            return false;
        }
        return isEqual(string, substr) ? true : isSubstring(string.substring(1), substr);
    }

    private static boolean isEqual(String str, String substr) {
        if (substr.isEmpty()) {
            return true;
        }
        if (str.charAt(0) == substr.charAt(0)) {
            return isEqual(str.substring(1), substr.substring(1));
        }
        return false;
    }

    public static boolean isSumTwo(short[] array, short sum) {
        //array of positive numbers or 0
        boolean[] helper = new boolean[sum > 0 ? sum + 1 : Short.MAX_VALUE + 1];
        boolean res = false;
        int index = 0;
        while (index < array.length && !res) {
            short num = (short) (sum - array[index]);
            if (num >= 0) {
                if (helper[num]) {
                    res = true;
                } else {
                    helper[array[index]] = true;
                }
            }
            index++;
        }
        return res;
    }

    public static void sort(short[] array) {
        //array - array of the positive or 0 number
        //sorting with complexity O[N]
        int[] helper = new int[Short.MAX_VALUE];
        // helper[index] => count of occurrences for key index in array
        for (int i : array) {
            helper[i]++;
        }
        int ind = 0;
        for (int i = 0; i < helper.length; i++) {
            for (int j = 0; j < helper[i]; j++) {
                array[ind++] = (short) i;
            }
        }
    }

    public static short getMaxWithNegativePresentation(short[] array) {
        //returns maximal positive number having a negative value with the same abs value, if no such numbers returns -1
        short res = -1;
        byte[] helper = new byte[Short.MAX_VALUE];
        for (int i : array) {
            short candidate = (short) Math.abs(i);
            if (i < 0)
                res = getRes(res, helper, candidate, 1);
            else
                res = getRes(res, helper, candidate, -1);
        }
        return res;
    }

    private static short getRes(short res, byte[] helper, short candidate, int sign) {
        if (helper[candidate] == 1 * sign && candidate > res)
            res = candidate;
        else if (helper[candidate] == 0)
            helper[candidate] = (byte) (-1 * sign);
        return res;
    }
}

