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

// ------------------------------------------------------------

import java.util.*;

public class NodeTypes {

    public static void findNodes(int[][] graph, int start) {

        int V = graph.length;

        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;

        q.add(start);

        System.out.print("Live Nodes: ");

        while (!q.isEmpty()) {

            int u = q.poll();

            System.out.print(u + " ");

            for (int v = 0; v < V; v++) {

                if (graph[u][v] == 1 && !visited[v]) {

                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        System.out.println();

        System.out.print("Dead Nodes: ");

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        System.out.print("E Nodes: ");

        for (int i = 0; i < V; i++) {

            int edges = 0;

            for (int j = 0; j < V; j++) {

                if (graph[i][j] == 1) {
                    edges++;
                }
            }

            if (edges == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
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

        System.out.print("Enter starting node: ");
        int start = sc.nextInt();

        long begin = System.nanoTime();

        findNodes(graph, start);

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - begin));

        sc.close();
    }
}