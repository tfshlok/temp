import java.util.*;

public class DFSDemo {

    public static void dfs(int v, boolean[] visited, List<List<Integer>> adj) {

        visited[v] = true;

        System.out.print(v + " ");

        for (int u : adj.get(v)) {

            if (!visited[u]) {
                dfs(u, visited, adj);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");

        int V = sc.nextInt();
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

        boolean[] visited = new boolean[V];

        long start = System.nanoTime();

        dfs(0, visited, adj);

        long end = System.nanoTime();

        System.out.println("\nTime Taken (ns): " + (end - start));

        System.out.println("Time Complexity: O(V + E)");

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class DijkstraDemo {

    public static void dijkstra(int[][] graph, int src) {

        int V = graph.length;

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited);

            visited[u] = true;

            for (int v = 0; v < V; v++) {

                if (!visited[v] &&
                    graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex \t Distance from Source");

        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    public static int minDistance(int[] dist, boolean[] visited) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {

            if (!visited[v] && dist[v] <= min) {

                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
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

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        long start = System.nanoTime();

        dijkstra(graph, src);

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}