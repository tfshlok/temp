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

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class SubsetSumBacktracking {

    static void subsetSum(
            int[] arr,
            int n,
            int sum,
            List<Integer> subset,
            int index) {

        if (sum == 0) {

            System.out.println("Subset: " + subset);
            return;
        }

        if (index == n || sum < 0) {
            return;
        }

        subset.add(arr[index]);

        subsetSum(arr, n, sum - arr[index], subset, index + 1);

        subset.remove(subset.size() - 1);

        subsetSum(arr, n, sum, subset, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int sum = sc.nextInt();

        long start = System.nanoTime();

        subsetSum(arr, n, sum, new ArrayList<>(), 0);

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}