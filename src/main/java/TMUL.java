import java.math.BigInteger;
import java.util.Scanner;

public class TMUL {
    public static void main(String[] args) {
        int n;
        BigInteger hugeInt1, hugeInt2;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i< n; i++){
            hugeInt1 = scanner.nextBigInteger();
            hugeInt2 = scanner.nextBigInteger();
            System.out.println(hugeInt1.multiply(hugeInt2));
        }

    }
}
