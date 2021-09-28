import java.util.Scanner;

public class PP0604A {
    public static void main(String[] args) {
        int tests;
        int n;
        int sum = 0;
        double val = 0;
        double lowestVal = 100;
        int result = 0;

        double average;



        // 1 2 3 4 --> 2
        // 4 3 2 1 --> 3
        // 1 9 40 55


        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            lowestVal = 100;
           sum = 0;
            n = scanner.nextInt();
            int[] numbers = new int[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = scanner.nextInt();
                sum += numbers[j];
            }
            average = (double)sum / (double)n;
           for (int j =0; j< n; j++){
               val = Math.abs(numbers[j]-average);
               if (val == lowestVal) continue;
               if (val < lowestVal){
                   lowestVal = val;
                   result = numbers[j];
               }
           }
            System.out.println(result);
        }
    }
}
