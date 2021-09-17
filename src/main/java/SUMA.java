import java.util.Scanner;

public class SUMA {
    public static void main(String[] args) {
        int number;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            number = scanner.nextInt();
            sum += number;
            System.out.println(sum);
        }
    }
}
