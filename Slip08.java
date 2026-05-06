import java.util.*;

class Item {

    int weight;
    int value;
    double ratio;

    Item(int w, int v) {

        weight = w;
        value = v;
        ratio = (double) v / w;
    }
}

public class GreedyKnapsack {

    public static double knapsack(Item[] items, int capacity) {

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int remaining = capacity;

        for (Item item : items) {

            if (item.weight <= remaining) {

                totalValue += item.value;
                remaining -= item.weight;

            } else {

                totalValue += item.ratio * remaining;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and value of each item:");

        for (int i = 0; i < n; i++) {

            int w = sc.nextInt();
            int v = sc.nextInt();

            items[i] = new Item(w, v);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        long start = System.nanoTime();

        double maxValue = knapsack(items, capacity);

        long end = System.nanoTime();

        System.out.println("Maximum Value in Knapsack = " + maxValue);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class TSPNearestNeighbor {

    public static void tsp(int[][] graph, int start) {

        int V = graph.length;

        boolean[] visited = new boolean[V];
        int[] path = new int[V + 1];

        int cost = 0;

        visited[start] = true;
        path[0] = start;

        int current = start;

        for (int i = 1; i < V; i++) {

            int next = -1;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < V; j++) {

                if (!visited[j] &&
                    graph[current][j] != 0 &&
                    graph[current][j] < min) {

                    min = graph[current][j];
                    next = j;
                }
            }

            visited[next] = true;
            path[i] = next;

            cost += min;
            current = next;
        }

        cost += graph[current][start];
        path[V] = start;

        System.out.println("Path: " + Arrays.toString(path));
        System.out.println("Cost: " + cost);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting city: ");
        int start = sc.nextInt();

        long startTime = System.nanoTime();

        tsp(graph, start);

        long endTime = System.nanoTime();

        System.out.println("Time Taken (ns): " + (endTime - startTime));

        sc.close();
    }
}