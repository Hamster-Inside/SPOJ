import java.util.Scanner;

public class VSR {
    public static void main(String[] args) {
        int tests;
        double v1;
        double v2;
        int result = 0;


        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++){
            v1 = scanner.nextDouble();
            v2 = scanner.nextDouble();
            System.out.println(((int)((2*v1*v2)/(v1+v2))));


        }
    }
}
