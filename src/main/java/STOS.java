import java.util.Scanner;

public class STOS {
    public static void main(String[] args) {
        int[] stos = new int[10];
        int position = -1;
        int number;
        String operation;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            operation = scanner.next();
            if (operation.equals("-")) {

                if (position < 0) {
                    System.out.println(":(");
                    continue;
                } else {
                    System.out.println(stos[position]);
                    position--;
                    continue;
                }
            }
            if (operation.equals("+")) {
                number = scanner.nextInt();
                if (position >= 9) {
                    System.out.println(":(");

                } else {
                    position++;
                    stos[position] = number;
                    System.out.println(":)");
                }
            }
       }
    }
}
