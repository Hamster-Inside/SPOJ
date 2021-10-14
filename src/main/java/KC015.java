import java.util.Scanner;

public class KC015 {
    public static void main(String[] args) {
        String numString1;
        String numString2;
        long num1 = 0;
        long num2 = 0;
        // 1 123123123131231232131231231312313123131313123123123123
        // 34343434343434343433434334343343434 343434343434343434343434343434343434343
        String compareSign;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            numString1 = scanner.next();
            compareSign = scanner.next();
            numString2 = scanner.next();
            if (numString1.length() > numString2.length()) num1 = 1;
            else if (numString1.length() == numString2.length()){
                for (int i=0; i< numString1.length(); i++){
                    if (numString1.charAt(i) != numString2.charAt(i)){
                        if (numString1.charAt(i) > numString2.charAt(i)) num1 = 1;
                        else num2 = 1;
                        break;
                    }
                }
            }
            else num2 = 1;

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
            num1 = 0;
            num2 = 0;
        }
    }
}
