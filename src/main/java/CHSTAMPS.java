import java.util.Scanner;

public class CHSTAMPS {
    public static void main(String[] args) {
        int n; // 1 - 10 ^ 15
        int k; // 1 - 15

        // wypisać liczbę większą od 'n' zawierającą co najmniej 'k' piątek
        // 1000 2 --> 1055
        // 1000 3 --> 1555
        // 10000 3 --> 10555
        // 23211 2 --> 23255
        // 595 2 --> 655
        // 150325 2 --> 150335
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        while (n%5 != 0){
            n++;
        }

    }
}
