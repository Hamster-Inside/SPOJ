import java.util.Scanner;

public class CALC2 {
    public static void main(String[] args) {
        int a;
        int b;
        int[] registry = new int[10];
        String operation;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            operation = scanner.next();
            a = scanner.nextInt();
            b = scanner.nextInt();

            if (operation.equals("z")){
                registry[a] = b;
                continue;
            }


            if (operation.equals("+")) {
                System.out.println(registry[a]+registry[b]);
            } else if (operation.equals("-")) {
                System.out.println(registry[a]-registry[b]);
            }
            else if (operation.equals("*")){
                System.out.println(registry[a]*registry[b]);
            }
            else if (operation.equals("/")){
                System.out.println(registry[a]/registry[b]);
            }
            else if (operation.equals("%")){
                System.out.println(registry[a]%registry[b]);
            }

        }
    }
}
