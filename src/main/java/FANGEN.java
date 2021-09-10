import java.util.Scanner;

public class FANGEN {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0) break;
            String[][] fanTable = new String[2 * n][2 * n];

            /*
                            * . . * * *
                            * * . * * .
                            * * * * . .
                            . . * * * *
                            . * * . * *
                            * * * . . *

             */

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    fanTable[i][j] = "*";
                    fanTable[2 * n - 1 - i][2 * n - 1 - j] = "*";
                    fanTable[j][2 * n - 1 - i] = "*";
                    fanTable[2 * n - 1 - j][i] = "*";
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    fanTable[i][j] = ".";
                    fanTable[j][2 * n - 1 - i] = ".";
                    fanTable[2 * n - 1 - i][2 * n - 1 - j] = ".";
                    fanTable[2 * n - 1 - j][i] = ".";
                }
            }
            for (int i = 0; i < 2 * n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    System.out.print(fanTable[j][i]);
                }
                System.out.println();
            }
        }


    }
}
