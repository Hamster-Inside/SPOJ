import java.util.Scanner;

public class SUDOKUC {
    public static void main(String[] args) {

       /* 5
        2 5 1 7 6 9 3 4 8
        9 8 6 3 4 5 2 7 1
        3 7 4 8 2 1 6 9 5
        4 2 9 6 3 8 5 1 7
        8 6 3 5 1 7 9 2 4
        5 1 7 4 9 2 8 3 6
        7 9 5 1 8 3 4 6 2
        1 4 2 9 5 6 7 8 3
        6 3 8 2 7 4 1 5 9

        100 5 1 7 6 9 3 4 8
        9 8 6 3 4 5 2 7 1
        3 7 4 8 2 1 6 9 5
        4 2 9 6 3 8 5 1 7
        8 6 3 5 1 7 9 2 4
        5 1 7 4 9 2 8 3 6
        7 9 5 1 8 3 4 6 2
        1 4 2 9 5 6 7 8 3
        6 3 8 2 7 4 1 5 9

        4 2 9 6 3 8 5 1 7
        8 6 3 5 1 7 9 2 4
        5 1 7 4 9 2 8 3 6
        7 9 5 1 8 3 4 6 2
        1 4 2 9 5 6 7 8 3
        6 3 8 2 7 4 1 5 9
        2 5 1 7 6 9 3 4 8
        9 8 6 3 4 5 2 7 1
        3 7 4 8 2 1 6 9 5

        2 5 1 7 6 9 3 4 8
        9 8 6 3 4 5 2 7 1
        3 7 4 8 2 1 6 9 5
        4 2 9 6 3 8 5 1 7
        8 6 3 5 1 7 9 2 4
        5 1 7 4 9 2 8 3 6
        7 9 5 1 8 3 4 6 2
        1 4 2 9 5 6 7 8 3
        6 3 8 2 7 4 1 9 5

        2 5 1 7 6 9 3 4 8
        9 8 6 3 4 5 2 7 1
        3 7 4 8 2 1 6 9 5
        4 2 9 6 3 8 5 1 7
        8 6 3 5 1 7 9 2 4
        5 1 7 4 9 2 8 3 6
        7 9 5 1 8 3 4 6 2
        1 4 2 9 8 6 7 5 3
        6 3 8 2 7 4 1 5 9

        */
        int tests;
        int[][] nums = new int[9][9];
        int[] checkTable = new int [9];
        boolean failed = false;
        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    nums[j][k] = scanner.nextInt();
                    if (nums[j][k] > 9 || nums[j][k] < 1) {
                        failed = true;
                        break;
                    }

                }
                if (failed) {

                    System.out.println("NIE");
                    break;
                }
            }
            if (!failed) {
                for (int j = 0; j < 9; j++) {
                    for (int k = 0; k < 9; k++) {
                        for (int l = k+1; l<9; l++){
                            if (nums[j][k] == nums[j][l]){
                                failed = true;
                                break;
                            }
                        }
                        if (failed) break;
                    }
                    if (failed){
                        System.out.println("NIE");
                        break;
                    }
                }
                for (int j = 0;j<9; j+=3){
                for (int k = 0; k<9; k+=3){
                    for (int l = j; l<j+3; l++){
                        for (int m= k; m<k+3; m++){

                        }
                    }
                }
                }
            }
            if (!failed) System.out.println("TAK");
            failed = false;

        }
    }
    boolean checkRow(int[][] table, int rowNumber){
        boolean failed = false;
        for (int i = 0; i<8; i++){
            for (int j = i+1; j<9; j++){
                if (table[rowNumber][i] == table[rowNumber][j]) {
                    failed = true;
                    break;
                }
            }
            if (failed) break;
        }
        return failed;
    }
    boolean checkCol(int[][] table, int colNumber){
        boolean failed = false;
        for (int i = 0; i<8; i++){
            for (int j = i+1; j<9; j++){
                if (table[i][colNumber] == table[j][colNumber]) {
                    failed = true;
                    break;
                }
            }
            if (failed) break;
        }
        return failed;
    }
    boolean checkBox(int[] table){
        boolean failed = false;
        for (int i = 0; i<8; i++){
            for (int j = i+1; j<9; j++){
                if (table[i] == table[j]){
                    failed = true;
                    break;
                }
            }
            if (failed) break;
        }
        return failed;
    }
    // box num 1-9
    int[] fillBox (int[][] table, int boxNum){
        int i = 0;
        int j = 0;
        int posX = boxNum-1;
        int posY = 0;
        while (posX > 3){
            posY+=1;
            posX-=3;
        }
        i+=posX*3;
        j+=posY*3;
    }
}
