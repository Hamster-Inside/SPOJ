import java.util.Scanner;

public class POL {
    public static void main(String[] args) {
        int tests;
        String incomingWord;

        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++){
            incomingWord = scanner.nextLine();
            System.out.println(incomingWord.substring(0,incomingWord.length()/2));
        }
    }
}
