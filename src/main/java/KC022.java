import java.util.Scanner;

public class KC022 {
    public static void main(String[] args) {
        int toFindPos;
        String numbersOfChaos;
        int numOfNumbers = 1;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            toFindPos = scanner.nextInt();
            numbersOfChaos = scanner.nextLine();
            for (int i = 0; i< numbersOfChaos.length(); i++){
                if (numbersOfChaos.charAt(i) == ' ') numOfNumbers++;
            }
            int[] numTable = new int[numOfNumbers];

        }
    }
}
