import java.util.Scanner;

public class PP0602B {
    public static void main(String[] args) {
        int tests;
        int l;
        int k;

        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            l = scanner.nextInt();
            k = scanner.nextInt();
            int[][] beforeMatrix = new int[l][k];
            int[][] newMatrix = new int[l][k];
            for (int j =0; j<l; j++){
                for (int n=0; n<k; n++){
                    beforeMatrix[j][n] = scanner.nextInt();
                    newMatrix[j][n] = beforeMatrix[j][n];
                }
            }
            for (int j = 0; j<k-1; j++){ // ok
                newMatrix[0][j] = beforeMatrix[0][j+1]; // ok
                newMatrix[l-1][j+1] = beforeMatrix[l-1][j]; // ok

            }
            for (int j =0; j<l-1;j++){ // ok
                newMatrix[j+1][0] = beforeMatrix[j][0]; // ok
                newMatrix[j][k-1] = beforeMatrix[j+1][k-1]; // ok

            }
            for (int j = 0; j<l; j++){
                for (int n = 0; n<k; n++){
                    System.out.print(newMatrix[j][n] + " ");
                }
                System.out.println();
            }
        }
    }
}
