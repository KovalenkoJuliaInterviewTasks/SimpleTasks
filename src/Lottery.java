/**
 * This class represents Lottery 7 of 49 The purpose of this task is to
 * implement rateCombination() with complexity O[N], where N=7
 */
public class Lottery {
    boolean[] lookupTable = new boolean[49];

    /**
     * Constructor
     *
     * @param winningCombination - array of 7 unique numbers in range [1 to 49] (no need to check)
     */
    public Lottery(int[] winningCombination) {
        for (int number : winningCombination) {
            lookupTable[number - 1] = true;
        }
    }

    /**
     * Rates player's combination of balls, comparing it with winner combination
     *
     * @param playerCombination - array of 7 unique numbers in range [1 to 49] (no need to check)
     * @return number of winning balls in player's combination
     */
    public int rateCombination(int[] playerCombination) {
        int res = 0;
        for (int number : playerCombination) {
            if (lookupTable[number - 1]) {
                res++;
            }
        }
        return res;
    }

    /**
     * Simple sanity test
     */
    public static void main(String[] args) {
        Lottery loto = new Lottery(new int[]{5, 2, 17, 48, 43, 7, 9});
        if (loto.rateCombination(new int[]{3, 5, 12, 17, 44, 10, 7}) != 3) {
            System.out.println("Test 1 failed");
            return;
        }
        if (loto.rateCombination(new int[]{3, 5, 12, 17, 49, 9, 7}) != 4) {
            System.out.println("Test 2 failed");
            return;
        }
        System.out.println("Success");
    }
}
