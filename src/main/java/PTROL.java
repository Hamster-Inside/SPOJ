import java.util.Scanner;

public class PTROL {
    public static void main(String[] args) {
        int numberOfTests;
        int  numberOfNumbers;
        int firstNumber;
        String restOfTheNumbers;
        Scanner scanner = new Scanner(System.in);
        numberOfTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i< numberOfTests; i++){
            numberOfNumbers = scanner.nextInt();
            firstNumber = scanner.nextInt();
            restOfTheNumbers = scanner.nextLine().trim();

            System.out.println(restOfTheNumbers + " " + firstNumber);

        }
    }
}
