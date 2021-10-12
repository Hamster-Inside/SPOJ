import java.util.Scanner;

public class KC003 {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            if (a <= 0 || b <=0 || c<=0){
                System.out.println("0");
                continue;
            }
            if (a >= b && a >= c) {
                if ((c+b) <= a) System.out.println("0");
                else System.out.println("1");
            }
            else if (b >= c && b >= a){
                if ((c+a) <= b) System.out.println("0");
                else System.out.println("1");
            }
            else if (c >= a && c >= b){
                if ((b+a) <= c) System.out.println("0");
                else System.out.println("1");
            }
        }
    }
}
