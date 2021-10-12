import java.util.Scanner;

public class JSZYCER {
    public static void main(String[] args) {
        String inputText ="";
        String outputText = "";
        // char convertedChar;
        //  char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            inputText = scanner.nextLine();
            for (int i = 0; i < inputText.length(); i++){
                if (inputText.charAt(i) == 'X') outputText+="A";
                else if (inputText.charAt(i) == 'Y') outputText+="B";
                else if (inputText.charAt(i) == 'Z') outputText+="C";
                else if (inputText.charAt(i) == ' ') outputText+=" ";
                else outputText+=Character.toString(inputText.charAt(i)+3);
            }

            System.out.println(outputText);
            outputText = "";
        }
    }
}
