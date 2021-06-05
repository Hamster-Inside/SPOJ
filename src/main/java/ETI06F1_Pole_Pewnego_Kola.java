import java.util.Locale;
import java.util.Scanner;



class ETI06F1_Pole_Pewnego_Kola {
    public static void main(String[] args) {
        double r;
        double d;
        double PI = 3.141592654d;
        double area;

        Scanner scanner = new Scanner(System.in);
        r = scanner.nextDouble();
        d = scanner.nextDouble();
        area = PI* (2*r - (r-d/2))*(r-d/2);

        System.out.println(String.format(Locale.ROOT, "%.2f",area));
    }
}
