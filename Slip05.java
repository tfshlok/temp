import java.util.*;

class Edge implements Comparable<Edge> {

    int src;
    int dest;
    int weight;

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {

    int parent;
    int rank;
}

public class KruskalMST {

    int V;
    int E;
    Edge[] edges;

    KruskalMST(int v, int e) {

        V = v;
        E = e;

        edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }
    }

    int find(Subset[] subsets, int i) {

        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {

        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {

            subsets[xroot].parent = yroot;

        } else if (subsets[xroot].rank > subsets[yroot].rank) {

            subsets[yroot].parent = xroot;

        } else {

            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskalMST() {

        Edge[] result = new Edge[V];

        int e = 0;
        int i = 0;

        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];

        for (i = 0; i < V; i++) {

            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;

        while (e < V - 1) {

            Edge nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {

                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Edges in MST:");

        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");

        int V = sc.nextInt();
        int E = sc.nextInt();

        KruskalMST graph = new KruskalMST(V, E);

        System.out.println("Enter edges (src dest weight):");

        for (int i = 0; i < E; i++) {

            graph.edges[i].src = sc.nextInt();
            graph.edges[i].dest = sc.nextInt();
            graph.edges[i].weight = sc.nextInt();
        }

        long start = System.nanoTime();

        graph.kruskalMST();

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

class HuffmanNode {

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {

    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

public class HuffmanCoding {

    public static void printCode(HuffmanNode root, String s) {

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {

            System.out.println(root.c + " : " + s);
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] charArray = new char[n];
        int[] charFreq = new int[n];

        System.out.println("Enter characters and frequencies:");

        for (int i = 0; i < n; i++) {

            charArray[i] = sc.next().charAt(0);
            charFreq[i] = sc.nextInt();
        }

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {

            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charFreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        long start = System.nanoTime();

        while (q.size() > 1) {

            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;
            f.c = '-';

            f.left = x;
            f.right = y;

            q.add(f);
        }

        HuffmanNode root = q.peek();

        System.out.println("Huffman Codes:");

        printCode(root, "");

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));

        System.out.println("Best Case Complexity: O(n log n)");
        System.out.println("Worst Case Complexity: O(n log n)");

        sc.close();
    }
}