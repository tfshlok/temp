import java.util.*;

public class MatrixChainMultiplication {

    public static int matrixChainOrder(int[] p, int n) {

        int[][] m = new int[n][n];

        for (int L = 2; L < n; L++) {

            for (int i = 1; i < n - L + 1; i++) {

                int j = i + L - 1;

                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {

                    int q =
                            m[i][k] +
                            m[k + 1][j] +
                            p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];

        System.out.println("Enter dimensions array:");

        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        long start = System.nanoTime();

        int minCost = matrixChainOrder(p, n + 1);

        long end = System.nanoTime();

        System.out.println("Minimum Multiplications = " + minCost);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class OptimalBST {

    public static int optimalBST(int[] keys, int[] freq, int n) {

        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        for (int L = 2; L <= n; L++) {

            for (int i = 0; i <= n - L; i++) {

                int j = i + L - 1;

                cost[i][j] = Integer.MAX_VALUE;

                int sum = 0;

                for (int s = i; s <= j; s++) {
                    sum += freq[s];
                }

                for (int r = i; r <= j; r++) {

                    int c =
                            ((r > i) ? cost[i][r - 1] : 0) +
                            ((r < j) ? cost[r + 1][j] : 0) +
                            sum;

                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }

        return cost[0][n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of keys: ");
        int n = sc.nextInt();

        int[] keys = new int[n];
        int[] freq = new int[n];

        System.out.println("Enter keys:");

        for (int i = 0; i < n; i++) {
            keys[i] = sc.nextInt();
        }

        System.out.println("Enter frequencies:");

        for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }

        long start = System.nanoTime();

        int cost = optimalBST(keys, freq, n);

        long end = System.nanoTime();

        System.out.println("Optimal BST Cost = " + cost);

        System.out.println("Time Taken (ns): " + (end - start));

        System.out.println("Best Case Complexity: O(n^2)");
        System.out.println("Worst Case Complexity: O(n^3)");

        sc.close();
    }
}