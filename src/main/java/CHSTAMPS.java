import java.util.Scanner;

public class CHSTAMPS {
    public static void main(String[] args) {
        String n; // 1 - 10 ^ 15
        String output = "";
        int k; // 1 - 15


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
        n = scanner.next(); // skanujemy liczbe
        k = scanner.nextInt(); // skanujemy ile chcemy piatek
        n = addOneToRandomStringNumber(n); // dodaje nam jeden do ultra wielkiej liczby wykraczajacej poza long int itd.
        output = resolverOfCHSTAMPSProblem(n, k); // wszystkie obliczenia
        System.out.println(output);
    }

    static String addOneToRandomStringNumber(String input) {
        String output = "";
        char[] inputCharTable = new char[input.length()];
        boolean haveToAddOne = false;
        for (int i = 0; i < inputCharTable.length; i++) {
            inputCharTable[i] = input.charAt(i);
        }
        for (int i = inputCharTable.length - 1; i >= 0; i--) {
            if (inputCharTable[i] == '9') {
                inputCharTable[i] = '0';
                haveToAddOne = true;
            } else {
                inputCharTable[i] += 1;
                haveToAddOne = false;
                break;
            }
        }
        if (haveToAddOne) output += "1";
        for (char k : inputCharTable) {
            output += k;
        }
        return output;
    }


    static String resolverOfCHSTAMPSProblem(String inputString, int howManyFivesYouWant) {
        int fiveCounter = 0;
        boolean haveToAddNow = false;
        boolean haveToAddOne = false;
        String output = "";
        // WARUNEK 1
        if (inputString.length() < howManyFivesYouWant) {
            for (int i = 0; i < howManyFivesYouWant; i++) {
                output += "5";
            }
            return output;
        }
        char[] charTable = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            charTable[i] = inputString.charAt(i);
            if (inputString.charAt(i) == '5') fiveCounter++;
        }
        if (fiveCounter >= howManyFivesYouWant)
            return inputString; // jesli po zwiekszeniu o 1 (taki przychodzi input) mamy juz wystarczajaco piatek to zwraca input
        while (fiveCounter < howManyFivesYouWant) {
            // dodajemy 5 do jedności, potem dziesiątek itd. Gdy trafiamy na "9" to zmieniamy na 0 i zwiększamy lewą stronę o 1 jeśli jest mniejsza od 9
            for (int i = charTable.length - 1; i >= 0; i--) {
                if (i != 0) {
                    if (charTable[i] == '5') {
                        if (haveToAddNow) {
                            charTable[i] = '6';
                            fiveCounter--;
                            break;
                        }
                    } else if (charTable[i] == '9') {
                        charTable[i] = '0';
                        haveToAddNow = true;
                    } else {
                        if (haveToAddNow){
                            charTable[i] += 1;
                            if (charTable[i] == '5') fiveCounter++;
                        }
                        else {
                            charTable[i] = '5';
                            fiveCounter++;
                        }

                        haveToAddNow = false;
                        break;
                    }
                } else {
                    if (haveToAddNow && charTable[i] == '9') {
                        charTable[i] = '0';
                        haveToAddOne = true;
                    }
                    else {
                        charTable[i]+=1;
                    }
                }
            }
        }
        if (haveToAddOne) output += "1";
        for (char wow : charTable) {
            output += wow;
        }
        return output;
    }
}

