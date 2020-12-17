import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int diag = 0; diag < n; diag++) {
            for (int el = 0; el < n - diag; el++) {
                mat[el][el + diag] = diag;
                mat[el + diag][el] = diag;
            }
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