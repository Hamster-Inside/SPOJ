import java.util.Scanner;

public class JPESEL {
    public static void main(String[] args) {
        int tests;
        String pesel;
        int sum = 0;
        int[] peselNums = new int[11];
        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            sum = 0;
            pesel = scanner.next();
            for (int j = 0; j < 11; j++) {
                peselNums[j] = pesel.charAt(j);
            }
            sum = (1 * (peselNums[0] + peselNums[4] + peselNums[8] + peselNums[10])) +
                    (3 * (peselNums[1] + peselNums[5] + peselNums[9])) +
                    (7 * (peselNums[2] + peselNums[6])) +
                    (9 * (peselNums[3] + peselNums[7]));
            if (sum > 0 && sum % 10 == 0) System.out.println("D");
            else System.out.println("N");
        }
    }
}
