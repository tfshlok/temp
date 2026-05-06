import java.util.*;

public class Prims {

    public static int minKey(int[] key, boolean[] mstSet, int V) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {

            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public static void printMST(int[] parent, int[][] graph, int V) {

        System.out.println("Edge \tWeight");

        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void primMST(int[][] graph, int V) {

        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet, V);

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {

                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph, V);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix (0 if no edge):");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        long start = System.nanoTime();

        primMST(graph, V);

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class LCSLength {

    public static int lcs(String X, String Y) {

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0) {

                    dp[i][j] = 0;

                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        long start = System.nanoTime();

        int length = lcs(X, Y);

        long end = System.nanoTime();

        System.out.println("Length of LCS = " + length);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}