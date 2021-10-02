import java.util.Scanner;

public class JHTMLLET {
    public static void main(String[] args) {
        String inputString = "";
        String outputString = "";
        boolean makeItBig = false;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            inputString = scanner.nextLine();
            for (int i = 0; i<inputString.length(); i++){
                if (inputString.charAt(i) == '<'){
                    makeItBig = true;
                    outputString+=inputString.charAt(i);
                    continue;
                }
                if (inputString.charAt(i) == '>'){
                    makeItBig = false;
                    outputString+=inputString.charAt(i);
                    continue;
                }
                if(makeItBig){
                    outputString+=Character.toUpperCase(inputString.charAt(i));
                }
                else outputString+=inputString.charAt(i);
            }
            System.out.println(outputString);
            outputString = "";
        }
    }
}
