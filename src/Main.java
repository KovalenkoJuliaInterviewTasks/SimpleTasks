public class Main {

    public static void main(String[] args) {

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

