import java.util.Locale;
import java.util.Scanner;

public class ROWNANIE
{
    public static void main(String[] args) {

    /*     Ax^2 + Bx + C = 0
            wejście: 0.3 0.3 0.4
            wyjście 0
            wejście 0.5 1 0.5
            wyjście 1

            Delta = b^2 - 4ac
            Jeżeli Delta > 0 to funkcja ma 2 miejsca zerowe
            Jeżeli Delta = 0 to funkcja ma 1 miejsce zerowe
            Jeżeli Delta < 0 to funkcja ma 0 miejsc zerowych

*/
        double a;
        double b;
        double c;
        double delta;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        while (scanner.hasNext()){
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            delta = Math.pow(b,2) - 4*a*c;
            if (delta > 0) System.out.println("2");
            if (delta == 0) System.out.println("1");
            if (delta < 0) System.out.println("0");
        }
    }
}
