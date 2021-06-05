import java.util.Scanner;

class Tester_Kodu2 {
    public static void main(String[] args) {
        String totalCharsString = "";
        String totalCharsString2 = "";
        char firstChar = 'A';
        char secondChar = 'A';
        if (firstChar == secondChar) {
            totalCharsString += firstChar;
            totalCharsString += secondChar;
            totalCharsString2+= firstChar + secondChar;
            System.out.println("totalCharsString = " + totalCharsString);
            System.out.println("totalCharsString2 = " + totalCharsString2);
        }
    }
}

