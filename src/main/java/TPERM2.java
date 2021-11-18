
import java.util.Scanner;

public class TPERM2 {
    public static void main(String[] args) {
        int tests, nums;
        int factorial = 1;
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};

        // a b c d
        // a b d c
        // a d b c
        // a d c b
        // a c b d
        // a c d b
        // b a c d
        // b a d c
        // b d a c
        // b d c a
        // b
        // c a b d
        // c a d b
        // c d a b
        // c d b a
        // d a b c
        // d a c b
        // d c a b
        // d c b a


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
