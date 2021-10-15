import java.util.Scanner;

public class PROGC05 {
    public static void main(String[] args) {
        String inputText;
        char toDeleteCharacter;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            toDeleteCharacter = scanner.next().charAt(0);
            inputText = scanner.nextLine();
            for (int i = 0; i< inputText.length(); i++){
                if (inputText.charAt(i) == toDeleteCharacter || inputText.charAt(i) == ' ') continue;
                System.out.print(inputText.charAt(i));
            }
            System.out.println();
        }
    }
}
