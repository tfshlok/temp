import java.util.*;

public class InsertionSortDemo {

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
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

        long start = System.nanoTime();

        insertionSort(arr);

        long end = System.nanoTime();

        System.out.println("Sorted Array:");

        printArray(arr);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

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

        System.out.print("Enter vertices and edges: ");

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

        System.out.println("DFS Time Complexity: O(V + E)");

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class BFSDemo {

    public static void bfs(int start, List<List<Integer>> adj, int V) {

        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {

            int u = q.poll();

            System.out.print(u + " ");

            for (int v : adj.get(u)) {

                if (!visited[v]) {

                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices and edges: ");

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

        long start = System.nanoTime();

        bfs(0, adj, V);

        long end = System.nanoTime();

        System.out.println("\nTime Taken (ns): " + (end - start));

        System.out.println("BFS Time Complexity: O(V + E)");

        sc.close();
    }
}