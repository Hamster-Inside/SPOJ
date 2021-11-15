
import java.util.Scanner;

public class TPERM2 {
    public static void main(String[] args) {
        int tests, nums;
        int factorial = 1;
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};

        // a b c d e
        // a b c e d
        // a b e c d
        // a e b c d
        // b a c d e
        // b a c e d
        // b a e c d
        // b e a c d
        // c a b d e
        // c a b e d


        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            nums = scanner.nextInt();
            for (int j = 1; j <= nums; j++) {
                factorial *= j;
            }
            for (int j = 0; j < factorial; j++) {

            }

            factorial = 1;
        }
    }
}
