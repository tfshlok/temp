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

        long start = System.nanoTime();

        bfs(0, adj, V);

        long end = System.nanoTime();

        System.out.println("\nTime Taken (ns): " + (end - start));

        System.out.println("Time Complexity: O(V + E)");

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class SelectionSort {

    public static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long start = System.nanoTime();

        selectionSort(arr);

        long end = System.nanoTime();

        System.out.println("Sorted Array:");

        printArray(arr);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}