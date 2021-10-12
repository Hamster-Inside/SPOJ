import java.util.Scanner;

public class KC004 {
    public static void main(String[] args) {
        int toFindNumber;
        int howManyNumbers;
        int number;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            toFindNumber = scanner.nextInt();
            howManyNumbers = scanner.nextInt();
            for (int i = 0; i<howManyNumbers; i++){
                number = scanner.nextInt();
                if (number == toFindNumber) counter++;
            }
            System.out.println(counter);
            counter = 0;
        }
    }
}
