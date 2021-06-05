import java.util.Scanner;

class BFN1_Zabawne_Dodawanie {
    public static void main(String[] args) {
        int numLoop;
        int number;
        int numberToBeReversed;
        int howManyAddUsed = 0;
        int reversedNumber = 0;
        int digit;

        Scanner scanner = new Scanner(System.in);
        numLoop = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numLoop; i++) {
            number = scanner.nextInt();
            scanner.nextLine();
            numberToBeReversed = number;
            if (number >= 10) {
                while (number != reversedNumber) {
                    while (numberToBeReversed != 0) {
                        digit = numberToBeReversed % 10;
                        numberToBeReversed = (numberToBeReversed - digit) / 10;
                        reversedNumber = reversedNumber * 10 + digit;
                    }
                    if (number != reversedNumber) {
                        howManyAddUsed++;
                        number += reversedNumber;
                        reversedNumber = 0;
                        numberToBeReversed = number;
                    }
                }
            }

            System.out.println(number + " " + howManyAddUsed);
            howManyAddUsed = 0;
            reversedNumber = 0;

        }
    }
}
