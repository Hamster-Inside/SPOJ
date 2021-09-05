import java.util.Scanner;

public class PTCLTZ {
    static int counter = 0;

    public static void main(String[] args) {
        int numberOfTests;
        int numberBeingTested;

        Scanner scanner = new Scanner(System.in);
        numberOfTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfTests; i++) {
            numberBeingTested = scanner.nextInt();
            scanner.nextLine();
            collatzProblem(numberBeingTested);
            System.out.println(counter);
            counter = 0;
        }
    }

    public static int collatzProblem(int numberBeingTested) {
        if (numberBeingTested == 1) {
            return counter;
        }
        if (numberBeingTested % 2 == 0) {
            numberBeingTested /= 2;
        } else {
            numberBeingTested = numberBeingTested*3 + 1;
        }
        counter++;

        collatzProblem(numberBeingTested);

        return 0;
    }
}
