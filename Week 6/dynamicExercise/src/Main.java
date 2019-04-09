public class Main {

    public static void main(String[] args) {
        // write your code here
        int islandSize = 9;
        int steps = 4;

        double probUp = 0.25;
        double probDown = 0.25;
        double probRight = 0.25;
        double probLeft = 0.25;

        int xStart = 4;
        int yStart = 4;

        double[][][] memo = new double[steps + 1][islandSize][islandSize];
        // initialize all non-empty 3d matrix with -1
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                for (int k = 0; k < memo[0].length; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        double pSurvival = memoIsland(probUp, probDown, probRight, probLeft, steps, xStart, yStart, memo);

        System.out.println("The probability surving " + steps + " steps on square of size " + islandSize +
                " starting at x = " + xStart + ", y = " + yStart + " given that pUp: " +
                probUp + ", pdown: " + probDown + ", pRight: " + probRight + ", pLeft: " + probLeft + ", is: " + pSurvival);

        double averageSurvival = Math.pow(pSurvival, 1.0 / steps);
        System.out.println("average survival per step: " + averageSurvival);
    }

    private static double memoIsland(double pUp, double pDown, double pRight, double pLeft, int steps, int xStart, int yStart, double[][][] memoize) {
        if (xStart < 0 || yStart < 0 || xStart > memoize[0].length - 1 || yStart > memoize[0].length - 1) {
            return 0;
        }
        if (memoize[steps][xStart][yStart] != -1) {
            return memoize[steps][xStart][yStart];
        }
        double result = -1;
        if (steps == 0) {
            result = 1;
        } else {
            result = (pRight * memoIsland(pUp, pDown, pRight, pLeft, steps - 1, xStart + 1, yStart, memoize) +
                    pLeft * memoIsland(pUp, pDown, pRight, pLeft, steps - 1, xStart - 1, yStart, memoize) +
                    pUp * memoIsland(pUp, pDown, pRight, pLeft, steps - 1, xStart, yStart + 1, memoize) +
                    pDown * memoIsland(pUp, pDown, pRight, pLeft, steps - 1, xStart, yStart - 1, memoize));
        }
        memoize[steps][xStart][yStart] = result;
        return result;

    }
}
//:: Dynamic Programming
//        Given an island in the form of square matrix and a point inside the matrix where a person is standing. The person is allowed to move one step in any direction (right, left, top, down) on the matrix. If he steps outside the matrix, he dies. Calculate the probability that he is alive after he walks n steps on the island?
//
//        For example,
//        Input: 3 x 3 matrix
//        Starting coordinates – (0, 0)
//        Number of steps = 3
//        Output: Alive Probability is 0.25
//
//        You may assume that the person takes each action with probability of 0.25, or with unequal probabilities.