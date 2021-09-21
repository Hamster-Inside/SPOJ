import java.util.Scanner;

public class CALC {
    public static void main(String[] args) {
        int a;
        int b;
        String operation;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            operation = scanner.next();
            a = scanner.nextInt();
            b = scanner.nextInt();
            if (operation.equals("+")) {
                System.out.println(a+b);
            } else if (operation.equals("-")) {
                System.out.println(a-b);
            }
            else if (operation.equals("*")){
                System.out.println(a*b);
            }
            else if (operation.equals("/")){
                System.out.println(a/b);
            }
            else if (operation.equals("%")){
                System.out.println(a%b);
            }

        }
    }
}
