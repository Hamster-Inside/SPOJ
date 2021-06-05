import java.util.Scanner;

class Flamase_Flamaster_v2 {
    public static void main(String[] args) {
        String inputText;
        String outputText = "";
        int counter = 1;
        int numLoop;
        char actualChar;
        char previousChar = 0;


        Scanner scanner = new Scanner(System.in);
        numLoop = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numLoop; i++) {

            inputText = scanner.nextLine();

            for (int j = 0; j < inputText.length(); j++) {
                actualChar = inputText.charAt(j);

                if (j == 0) {
                    outputText += actualChar;
                }
                if (j > 0) {
                    previousChar = inputText.charAt(j - 1);
                }
                if (actualChar == previousChar) {
                    counter++;
                    if (j == inputText.length() - 1) {
                        if (counter == 2) outputText += actualChar;
                        if (counter > 2) outputText += counter;
                        counter = 1;
                    }
                }
                if (j > 0 && actualChar != previousChar) {
                    if (counter == 1) {
                        outputText += actualChar;
                    }
                    if (counter == 2) {
                        outputText += previousChar;
                        outputText += actualChar;
                    }
                    if (counter > 2) {
                        outputText += counter;
                        outputText += actualChar;
                    }
                    counter = 1;
                }

            }
            System.out.println(outputText);
            outputText = "";
            previousChar = 0;
        }
    }
}