import java.util.Scanner;

class RNO_DOD_Proste_Dodawanie {
    public static void main(String[] args) {
        int numLoop;
        int numNumbers;
        int number;
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        numLoop = scanner.nextInt();
        scanner.nextLine();
        for (int i =0; i<numLoop; i++){
            numNumbers = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j<numNumbers; j++){
                number = scanner.nextInt();
                result += number;
            }
            System.out.println(result);
            result = 0;
        }
    }
}
