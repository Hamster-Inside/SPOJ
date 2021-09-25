import java.util.Scanner;

public class PP0601A2 {
    public static void main(String[] args) {
        int beforeNumber = 42;
        int actualNumber = 0;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            actualNumber = scanner.nextInt();
            if (actualNumber == 42 && beforeNumber != actualNumber) counter++;
            beforeNumber = actualNumber;
            System.out.println(actualNumber);
            if (counter == 3) break;


        }
    }
}
