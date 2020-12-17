import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] mat = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ".";
            }
        }
        for (int i = 0; i < n; i++) {
            mat[i][i] = "*";
            mat[n - 1 - i][i] = "*";
            mat[i][n / 2] = "*";
            mat[n / 2][i] = "*";
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}