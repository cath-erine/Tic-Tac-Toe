import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(sc.nextInt() == 1 ? "YES" : "NO");
        } else {
            boolean[][] flagsRow = new boolean[n * n][n * n];
            boolean[][] flagsCol = new boolean[n * n][n * n];
            boolean[][] flagsSq = new boolean[n * n][n * n];
            boolean flagOut = false;
            for (int i = 0; i < n * n; i++) {
                for (int j = 0; j < n * n; j++) {
                    int el = sc.nextInt();

                    //check Square
                    if (i / n == j / n) {
                        if (!flagsSq[el - 1][i / n]) {
                            flagsSq[el - 1][i / n] = true;
                        } else {
                            flagOut = true;
                            break;
                        }
                    }

                    //check row
                    if (!flagsRow[el - 1][i]) {
                        flagsRow[el - 1][i] = true;
                    } else {
                        flagOut = true;
                        break;
                    }

                    //check column
                    if (!flagsCol[el - 1][j]) {
                        flagsCol[el - 1][j] = true;
                    } else {
                        flagOut = true;
                        break;
                    }
                }
                if (flagOut) {
                    break;
                }
            }
            System.out.println(flagOut ? "NO" : "YES");

        }
    }
}