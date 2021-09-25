import java.util.Scanner;

public class PP0601B {
    public static void main(String[] args) {
        int tests;
        int x;
        int y;
        int n;
        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            for (int j = x; j < n; j+=x){
              if (j%y != 0){
                  System.out.print(j + " ");
              }
            }
            System.out.println();
        }
    }
}
