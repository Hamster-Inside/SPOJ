import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class MWP2_2C {
    public static void main(String[] args) {
        int x1, y1, r1, x2, y2, r2, tests;
        double result, l, a, b, d1, d2;
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            r1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            r2 = scanner.nextInt();
            a = x1 - x2;
            b = y1 - y2;
            l = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
            result = r1 + r2 - l;
            d1 = r1 * 2;
            d2 = r2 * 2;
            if (isInsideAnotherCircle(l,r1,r2)){
                if (r1 > r2) System.out.println(df.format(d2));
                else System.out.println(df.format(d1));
            }
            else if (l > (r1 + r2)) System.out.println("0.00");
            else System.out.println(df.format(result));
        }
    }

    static boolean isInsideAnotherCircle(double l, int r1, int r2) {
        if (r1 >= r2) return l + r2 <= r1;
        else return l + r1 <= r2;
    }
}
