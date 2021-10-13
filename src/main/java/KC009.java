import java.util.Scanner;

public class KC009 {
    public static void main(String[] args) {
        String inputText;
        String outputText = "";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            inputText = scanner.nextLine();
            for (int i = inputText.length()-1; i>=0; i--){
                System.out.print(inputText.charAt(i));
            }
            System.out.println();
        }
    }
}
