import java.util.Scanner;

public class SYS {

    public static void main(String[] args) {
        int tests;
        int number;
        String numberTo16 = "";
        String numberTo11 = "";

        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            number = scanner.nextInt();
            numberTo16 = hexGenerator(number);
            numberTo11 = elGenerator(number);
            System.out.println(numberTo16 + " " + numberTo11);
        }
    }

    static String hexGenerator(int number) {

        int rem;
        String hex="";
        char[] hexchars ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(number>0)
        {
            rem=number%16;
            hex=hexchars[rem]+hex;
            number=number/16;
        }
        return hex;
    }

    static String elGenerator(int number) {

        int rem;
        String el="";
        char[] elchars ={'0','1','2','3','4','5','6','7','8','9','A'};
        while(number>0)
        {
            rem=number%11;
            el=elchars[rem]+el;
            number=number/11;
        }
        return el;
    }
}
