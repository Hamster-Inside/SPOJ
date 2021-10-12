import java.util.Scanner;

public class POTSAM {
    public static void main(String[] args) {
        int n1;
        int k1;
        int n2;
        int k2;
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        k1 = scanner.nextInt();
        n2 = scanner.nextInt();
        k2 = scanner.nextInt();
        System.out.println((n1*k1)+(n2*k2));
    }
}
