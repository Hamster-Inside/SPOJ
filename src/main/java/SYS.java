import java.util.Scanner;

public class SYS {
    static int counter = 0;
    static String num16 = "";
    static String num11 = "";
    public static void main(String[] args) {
        int tests;
        int number;

        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            number = scanner.nextInt();
            num16 = "";
            hexGenerator(number);
            num11 = "";
            elGenerator(number);
            System.out.println(num16 + " " + num11);
        }
    }

    static String hexGenerator(int number) {
        if ((number/16) > 15){
            counter++;
            hexGenerator(number/16);
        }
        
        else if (number < 10){
            return Integer.toString(number);
        }
        else {
            if (number == 10) return "A";
            if (number == 11) return "A";
            if (number == 12) return "A";
            if (number == 10) return "A";
            if (number == 10) return "A";
            if (number == 10) return "A";
        }
        return "";
    }
    static String elGenerator(int number){

        return "";
    }
}
