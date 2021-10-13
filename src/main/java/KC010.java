import java.util.Scanner;

public class KC010 {
    public static void main(String[] args) {
        String inputText;
        int strCounter = 0;
        int numCounter = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            inputText = scanner.nextLine();
            if (Character.isDigit(inputText.charAt(0))) numCounter++;
            else strCounter++;
           for (int i = 0; i< inputText.length(); i++){
               if (inputText.charAt(i) == ' '){
                   if (Character.isDigit(inputText.charAt(i+1))) numCounter++;
                   else strCounter++;
               }
           }
            System.out.println(numCounter + " " + strCounter);
           numCounter = 0;
           strCounter = 0;
        }
    }
}
