import java.util.*;

public class MergeSort {

    public static void merge(int[] arr, int si, int mid, int ei) {

        int[] merged = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {

            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int[] arr, int si, int ei) {

        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        divide(arr, si, mid);
        divide(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
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

        divide(arr, 0, n - 1);

        long end = System.nanoTime();

        System.out.println("Sorted Array:");
        printArray(arr);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

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