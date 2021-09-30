import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class JROWLIN {
    public static void main(String[] args) {

        // ax+b=c, dane jest a,b,c
        // brak rozwiazania = "BR"
        // nieskonczenie wiele rozwiazan = "NWR"
        Locale.setDefault(Locale.US);
        double a;
        double b;
        double c;
        double result;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        if (a == 0){
            if ((b-c) == 0 || (c-b) == 0) System.out.println("NWR");
            else System.out.println("BR");

        }
        else{
            result = ((c-b)/a);
            System.out.printf("%.2f\n", result);
        }

    }
}
