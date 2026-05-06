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

// ------------------------------------------------------------

public class FourQueens {

    static final int N = 4;

    public static boolean isSafe(int[][] board, int row, int col) {

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

    public static boolean solveQueens(int[][] board, int col) {

        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                board[i][col] = 1;

                if (solveQueens(board, col + 1)) {
                    return true;
                }

                board[i][col] = 0;
            }
        }

        return false;
    }

    public static void printBoard(int[][] board) {

        System.out.println("Board Configuration:");

        for (int[] row : board) {

            for (int val : row) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] board = new int[N][N];

        long start = System.nanoTime();

        if (solveQueens(board, 0)) {

            printBoard(board);

        } else {

            System.out.println("No Solution Exists");
        }

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));
    }
}