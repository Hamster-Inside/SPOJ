import java.util.Scanner;

public class PP0602A {
    public static void main(String[] args) {
        int tests;
        int numbers;
        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            numbers = scanner.nextInt();
            int[] sortedTable = new int[numbers];
            int startingPoint = numbers/2;
            int startingPoint2 = 0;
            for (int j = 1; j < numbers+1; j++) {
                if (j%2 == 0) {
                    sortedTable[startingPoint2++] = scanner.nextInt();
                }
                else sortedTable[startingPoint++] = scanner.nextInt();
            }
            for (int j = 0; j<numbers; j++){
                System.out.print(sortedTable[j] + " ");
            }
            System.out.println();
        }
    }
}
