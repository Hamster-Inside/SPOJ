import java.util.Scanner;

public class PP0602D {
    public static void main(String[] args) {
        int n;
        int k;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();

        int[] numbers = new int[n];
        for (int i = 0; i<n; i++){
            numbers[i] = scanner.nextInt();
        }
        for (int i = k; i<n; i++){
            System.out.print(numbers[i] + " ");
        }
        for (int i = 0; i<k; i++){
            System.out.print(numbers[i] + " ");
        }
    }
}
