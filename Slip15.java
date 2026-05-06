import java.util.*;

class Node {

    int level;
    int profit;
    int weight;
    double bound;
}

public class KnapsackBranchBound {

    static int W;
    static int[] wt;
    static int[] val;
    static int n;

    static double bound(Node u) {

        if (u.weight >= W) {
            return 0;
        }

        double profitBound = u.profit;

        int j = u.level + 1;
        int totalWeight = u.weight;

        while (j < n && totalWeight + wt[j] <= W) {

            totalWeight += wt[j];
            profitBound += val[j];

            j++;
        }

        if (j < n) {

            profitBound +=
                    (W - totalWeight) *
                    ((double) val[j] / wt[j]);
        }

        return profitBound;
    }

    public static int knapsack() {

        Queue<Node> Q = new LinkedList<>();

        Node u = new Node();
        Node v = new Node();

        u.level = -1;
        u.profit = 0;
        u.weight = 0;

        Q.add(u);

        int maxProfit = 0;

        while (!Q.isEmpty()) {

            u = Q.poll();

            if (u.level == -1) {

                v.level = 0;

            } else if (u.level == n - 1) {

                continue;

            } else {

                v.level = u.level + 1;
            }

            v.weight = u.weight + wt[v.level];
            v.profit = u.profit + val[v.level];

            if (v.weight <= W && v.profit > maxProfit) {
                maxProfit = v.profit;
            }

            v.bound = bound(v);

            if (v.bound > maxProfit) {
                Q.add(v);
            }

            v = new Node();

            v.level = u.level + 1;
            v.weight = u.weight;
            v.profit = u.profit;

            v.bound = bound(v);

            if (v.bound > maxProfit) {
                Q.add(v);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        n = sc.nextInt();

        wt = new int[n];
        val = new int[n];

        System.out.println("Enter weights:");

        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.println("Enter values:");

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.print("Enter capacity: ");
        W = sc.nextInt();

        long start = System.nanoTime();

        int result = knapsack();

        long end = System.nanoTime();

        System.out.println("Max Profit = " + result);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class GraphColoring {

    static int V;
    static int[] color;

    public static boolean isSafe(int v, int[][] graph, int c) {

        for (int i = 0; i < V; i++) {

            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }

        return true;
    }

    public static boolean graphColoringUtil(int[][] graph, int m, int v) {

        if (v == V) {
            return true;
        }

        for (int c = 1; c <= m; c++) {

            if (isSafe(v, graph, c)) {

                color[v] = c;

                if (graphColoringUtil(graph, m, v + 1)) {
                    return true;
                }

                color[v] = 0;
            }
        }

        return false;
    }

    public static void graphColoring(int[][] graph, int m) {

        color = new int[V];

        if (!graphColoringUtil(graph, m, 0)) {

            System.out.println("Solution does not exist");
            return;
        }

        System.out.println("Assigned Colors:");

        for (int i = 0; i < V; i++) {
            System.out.print(color[i] + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter number of colors: ");
        int m = sc.nextInt();

        long start = System.nanoTime();

        graphColoring(graph, m);

        long end = System.nanoTime();

        System.out.println("\nTime Taken (ns): " + (end - start));

        sc.close();
    }
}