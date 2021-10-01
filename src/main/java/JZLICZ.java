import java.util.Scanner;

public class JZLICZ {
    public static void main(String[] args) {
        int texts;
        String allText = "";
        int[] posCounter = new int[20];
        char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                                        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Scanner scanner = new Scanner(System.in);
        texts = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i<texts; i++){
            allText+=scanner.nextLine();
        }
        for (int i = 0; i<allText.length(); i++){
            for (int j = 0; j<alphabet.length; j++){
                if (allText.charAt(i) == alphabet[j]){
                    posCounter[j]++;
                }
            }
        }

    }
}
