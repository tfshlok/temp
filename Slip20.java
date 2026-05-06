import java.util.*;

public class TopologicalSortDemo {

    public static void topologicalSort(int V, List<List<Integer>> adj) {

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {

            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!q.isEmpty()) {

            int u = q.poll();

            order.add(u);

            for (int v : adj.get(u)) {

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        System.out.println("Topological Order:");

        for (int node : order) {
            System.out.print(node + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
        }

        long start = System.nanoTime();

        topologicalSort(V, adj);

        long end = System.nanoTime();

        System.out.println("\nTime Taken (ns): " + (end - start));

        System.out.println("Time Complexity: O(V + E)");

        sc.close();
    }
}

// ------------------------------------------------------------

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

        System.out.println("Board Configuration:");

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