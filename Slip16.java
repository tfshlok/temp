import java.util.*;

public class KnapsackDP {

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

// ------------------------------------------------------------

import java.util.*;

public class HamiltonianCycle {

    int V;
    int[] path;

    boolean isSafe(int v, int[][] graph, int pos) {

        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        for (int i = 0; i < pos; i++) {

            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    boolean hamCycleUtil(int[][] graph, int pos) {

        if (pos == V) {

            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) {

            if (isSafe(v, graph, pos)) {

                path[pos] = v;

                if (hamCycleUtil(graph, pos + 1)) {
                    return true;
                }

                path[pos] = -1;
            }
        }

        return false;
    }

    boolean hamCycle(int[][] graph) {

        path = new int[V];

        Arrays.fill(path, -1);

        path[0] = 0;

        if (!hamCycleUtil(graph, 1)) {

            System.out.println("No Hamiltonian Cycle Exists");

            return false;
        }

        printSolution();

        return true;
    }

    void printSolution() {

        System.out.println("Hamiltonian Cycle:");

        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }

        System.out.println(path[0]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        HamiltonianCycle h = new HamiltonianCycle();

        h.V = V;

        long start = System.nanoTime();

        h.hamCycle(graph);

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}