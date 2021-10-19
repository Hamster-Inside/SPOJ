import java.util.Scanner;

public class CHSTAMPS {
    public static void main(String[] args) {
        String n; // 1 - 10 ^ 15
        int k; // 1 - 15
        int fiveCounter = 0;

        // wypisać liczbę większą od 'n' zawierającą co najmniej 'k' piątek
        // 1000 2 --> 1055
        // 1000 3 --> 1555
        // 10000 3 --> 10555
        // 23211 2 --> 23255
        // 595 2 --> 655
        // 150325 2 --> 150335
        Scanner scanner = new Scanner(System.in);
        n = scanner.next();
        k = scanner.nextInt();
        char[] charTable = new char[n.length()];
        for (int i = 0; i<n.length(); i++){
            charTable[i] = n.charAt(i);
            if (n.charAt(i) == '5') fiveCounter++;
        }
        if (fiveCounter > k) {
            for (int i = n.length()-1; i>0; i--){
               if (n.charAt(i) == '9'){
                   continue;
               }
               else if (n.charAt(i) < 9 && i !=n.length()-1){
                for (int j = n.length();j>i;j--){
                    charTable[j] = '0';

                }

               }
            }
        }

    }
}
