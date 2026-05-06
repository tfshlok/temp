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

        if (root.left == null &&
            root.right == null &&
            Character.isLetter(root.c)) {

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

        PriorityQueue<HuffmanNode> q =
                new PriorityQueue<>(n, new MyComparator());

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

            System.out.println("No solution exists");
        }

        long end = System.nanoTime();

        System.out.println("Time Taken (ns): " + (end - start));
    }
}