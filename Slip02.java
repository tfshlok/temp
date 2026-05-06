import java.util.*;

public class HeapSort {

    public static void heapSort(int[] arr) {

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {

            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
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

        heapSort(arr);

        long end = System.nanoTime();

        System.out.println("Sorted Array:");
        printArray(arr);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}

// ------------------------------------------------------------

import java.util.*;

public class StrassenMatrixMultiplication {

    public static int[][] add(int[][] A, int[][] B) {

        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    public static int[][] subtract(int[][] A, int[][] B) {

        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

    public static int[][] strassen(int[][] A, int[][] B) {

        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {

            C[0][0] = A[0][0] * B[0][0];

        } else {

            int newSize = n / 2;

            int[][] a11 = new int[newSize][newSize];
            int[][] a12 = new int[newSize][newSize];
            int[][] a21 = new int[newSize][newSize];
            int[][] a22 = new int[newSize][newSize];

            int[][] b11 = new int[newSize][newSize];
            int[][] b12 = new int[newSize][newSize];
            int[][] b21 = new int[newSize][newSize];
            int[][] b22 = new int[newSize][newSize];

            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {

                    a11[i][j] = A[i][j];
                    a12[i][j] = A[i][j + newSize];
                    a21[i][j] = A[i + newSize][j];
                    a22[i][j] = A[i + newSize][j + newSize];

                    b11[i][j] = B[i][j];
                    b12[i][j] = B[i][j + newSize];
                    b21[i][j] = B[i + newSize][j];
                    b22[i][j] = B[i + newSize][j + newSize];
                }
            }

            int[][] M1 = strassen(add(a11, a22), add(b11, b22));
            int[][] M2 = strassen(add(a21, a22), b11);
            int[][] M3 = strassen(a11, subtract(b12, b22));
            int[][] M4 = strassen(a22, subtract(b21, b11));
            int[][] M5 = strassen(add(a11, a12), b22);
            int[][] M6 = strassen(subtract(a21, a11), add(b11, b12));
            int[][] M7 = strassen(subtract(a12, a22), add(b21, b22));

            int[][] c11 = add(subtract(add(M1, M4), M5), M7);
            int[][] c12 = add(M3, M5);
            int[][] c21 = add(M2, M4);
            int[][] c22 = add(subtract(add(M1, M3), M2), M6);

            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {

                    C[i][j] = c11[i][j];
                    C[i][j + newSize] = c12[i][j];
                    C[i + newSize][j] = c21[i][j];
                    C[i + newSize][j + newSize] = c22[i][j];
                }
            }
        }

        return C;
    }

    public static void printMatrix(int[][] M) {

        for (int[] row : M) {

            for (int val : row) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter matrix size (power of 2): ");
        int n = sc.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        System.out.println("Enter elements of Matrix A:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of Matrix B:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        long start = System.nanoTime();

        int[][] C = strassen(A, B);

        long end = System.nanoTime();

        System.out.println("Resultant Matrix:");

        printMatrix(C);

        System.out.println("Time Taken (ns): " + (end - start));

        sc.close();
    }
}