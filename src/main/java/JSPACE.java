import java.util.Scanner;

public class JSPACE {
    public static void main(String[] args) {
        String inputText;
        String outputText = "";
        boolean upperThis = false;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            inputText = scanner.nextLine();
            for (int i = 0; i < inputText.length(); i++) {
                if (inputText.charAt(i) == ' ') {
                    upperThis = true;
                    continue;
                }
                if (upperThis){
                    outputText += Character.toUpperCase(inputText.charAt(i));

                    upperThis = false;
                    continue;
                }
                outputText += inputText.charAt(i);
            }
            System.out.println(outputText);
            outputText = "";
        }
    }
}
