import java.util.Scanner;

public class TRN {
    public static void main(String[] args) {
        int m;
        int n;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}
