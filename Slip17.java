import java.util.*;

public class NQueens {

    int N;

    boolean isSafe(int[][] board, int row, int col) {

        for (int i = 0; i < col; i++) {

            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < N && j >= 0; i++, j--) {

            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    boolean solveNQUtil(int[][] board, int col) {

        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                board[i][col] = 1;

                if (solveNQUtil(board, col + 1)) {
                    return true;
                }

                board[i][col] = 0;
            }
        }

        return false;
    }

    void printSolution(int[][] board) {

        for (int[] row : board) {

            for (int val : row) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }

    void solveNQ() {

        int[][] board = new int[N][N];

        if (!solveNQUtil(board, 0)) {

            System.out.println("Solution does not exist");
            return;
        }

        System.out.println("Solution:");

        printSolution(board);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        NQueens q = new NQueens();

        q.N = n;

        long start = System.nanoTime();

        q.solveNQ();

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class Knapsack01 {

    public static int knapsack(int[] wt, int[] val, int W, int n) {

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {

            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {

                    dp[i][w] = 0;

                } else if (wt[i - 1] <= w) {

                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]
                    );

                } else {

                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];

        System.out.println("Enter weights:");

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.println("Enter values:");

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.print("Enter capacity: ");
        int W = sc.nextInt();

        long start = System.nanoTime();

        int result = knapsack(wt, val, W, n);

        long end = System.nanoTime();

        System.out.println("Maximum Profit = " + result);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}