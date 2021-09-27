import java.util.Scanner;

public class PP0604A {
    public static void main(String[] args) {
        int tests;
      int n;
      int sum = 0;
      int simpleAverage = 0;
      double average;




        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            n = scanner.nextInt();
            int[] numbers = new int[n];
            for (int j = 0; j<n; j++){
                numbers[j] = scanner.nextInt();
                sum+=numbers[j];
            }
            simpleAverage = sum/n;
            average = sum/n;

        }
    }
}
