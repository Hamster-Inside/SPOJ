import java.util.Scanner;

public class KC015 {
    public static void main(String[] args) {
        String numString1;
        String numString2;
        String newNum1;
        String newNum2;
        int num1;
        int num2;
        String compareSign;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            numString1 = scanner.next();
            compareSign = scanner.next();
            numString2 = scanner.next();
            if (numString1.length() >= numString2){
            if (compareSign.equals("==")){
                if (num1 == num2) System.out.println("1");
                else System.out.println("0");
            }
            else if (compareSign.equals("!=")){
                if (num1 != num2) System.out.println("1");
                else System.out.println("0");
            }
            else if (compareSign.equals(">=")){
                if (num1 >= num2) System.out.println("1");
                else System.out.println("0");
            }
            else if (compareSign.equals("<=")){
                if (num1 <= num2) System.out.println("1");
                else System.out.println("0");
            }
        }
    }
}
