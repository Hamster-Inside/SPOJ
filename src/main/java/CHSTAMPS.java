import java.util.Scanner;

public class CHSTAMPS {
    public static void main(String[] args) {
        String n; // 1 - 10 ^ 15
        String output = "";
        int k; // 1 - 15
        int fiveCounter = 0;
        boolean haveToAddNow = false;
        boolean havetoAddOne = false;

        // wypisać liczbę większą od 'n' zawierającą co najmniej 'k' piątek
        // 1000 2 --> 1055
        // 1000 3 --> 1555
        // 10000 3 --> 10555
        // 23211 2 --> 23255
        // 595 2 --> 655
        // 150325 2 --> 150335

        // warunek 1 -> jeśli liczba ma mniej lub tyle cyfr co (k) to stworzyć liczbę składającą się z samych 5 w wymaganej liczbie "k"
        // warunek 2 -> jeśli liczba ma więcej cyfr niż wymaga tego k
        Scanner scanner = new Scanner(System.in);
        n = scanner.next();
        k = scanner.nextInt();
        char[] charTable = new char[n.length()];
        for (int i = 0; i < n.length(); i++) {
            charTable[i] = n.charAt(i);
            if (n.charAt(i) == '5') fiveCounter++;
        }
        // WARUNEK 1
        if (n.length() <= k) {
            for (int i = 0; i < k; i++) {
                output += "5";
            }
            System.out.println(output);
        } else {
            do {
                for (int i = charTable.length - 1; i >= 0; i--) {
                    // dla liczb typu 32324553599999
                    if (charTable[i] == '5') { //TODO - NIE DZIAŁA DLA 55
                        if (fiveCounter > k) {
                            charTable[i] = '6';
                            fiveCounter--;
                            break;
                        }
                        if (!haveToAddNow) continue;
                        else {
                            charTable[i] = '6';
                            fiveCounter--;
                            break;
                        }
                    } else if (charTable[i] == '9' && i > 0) {
                        charTable[i] = '0';
                        haveToAddNow = true;
                        continue;
                    } else if (charTable[i] == '9' && i == 0 && fiveCounter < k) {
                        charTable[i] = '0';
                        havetoAddOne = true;
                        break;
                    }
                    else{
                        charTable[i]+=1;
                        if (charTable[i] == '5') fiveCounter++;
                        break;
                    }

                }
                haveToAddNow = false;
            } while (fiveCounter < k);
                        if (havetoAddOne) output+="1";
                        for (char wow: charTable){
                            output+=wow;
                        }
            System.out.println(output);
        }
    }
}

