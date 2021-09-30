import java.util.Scanner;

public class JWSPLIN {
    public static void main(String[] args) {
        int tests;
        double[] x = new double[3];
        double[] y = new double[3];
        double a1, a2, b1, b2;

        // y = ax+b

        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            for (int j = 0; j < 3; j++) {
                x[j] = scanner.nextDouble();
                y[j] = scanner.nextDouble();
            }
            if (x[0] == 0 && x[1] == 0 && x[2] == 0 && y[0] == 0 && y[1] == 0 && y[2] == 0){
                System.out.println("TAK");

            }
            else if (x[0] == x[1] && x[1] == x[2]) System.out.println("TAK");
            else if (y[0] == y[1] && y[1] == y[2]) System.out.println("TAK");
            else {
                a1 = ((y[0] - y[1]) / (x[0] - x[1]));
                b1 = y[0] - x[0] * a1;
                a2 = ((y[1] - y[2]) / (x[1] - x[2]));
                b2 = y[1] - x[1] * a1;
                if (a1 == a2 && b1 == b2) System.out.println("TAK");
                else System.out.println("NIE");
            }

        }
    }
}
