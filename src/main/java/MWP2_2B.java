import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class MWP2_2B {
    public static void main(String[] args) {
        int u,s,d;
        Scanner scanner = new Scanner(System.in);
        while(true){
            u  = scanner.nextInt();
            s = scanner.nextInt();
            d = scanner.nextInt();
            if (u == 0 && s == 0 && d == 0) break;
            System.out.println(power_modulo_fast(u,s,d));
        }
    }
    public static int power_modulo_fast(int a, int b, int m) {
        int i;
        int result = 1;
        long x = a%m;

        for (i=1; i<=b; i<<=1) {
            x %= m;
            if ((b&i) != 0) {
                result *= x;
                result %= m;
            }
            x *= x;
        }

        return result;
    }
}
