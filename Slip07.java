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

// ------------------------------------------------------------

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

        int count = 0;

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

            count++;
        }

        if (count != V) {

            System.out.println("Graph has a cycle!");

        } else {

            System.out.println("Topological Order: " + order);
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

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}