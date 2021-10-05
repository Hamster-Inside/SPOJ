import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MWPZ06H {
    public static void main(String[] args) {
        int d; // liczba zestawow danych 1-500
        int n; // liczba calkowita 1-200 - liczba uczestnikow konkursu
        int highestNumber = 0;
        int counter = 0;
        // posortować najpierw max potem od najmniejszej. Np IN: 3 5 1 5 3 2 5 -> OUT: 5 5 5 1 2 3 3

        Scanner scanner = new Scanner(System.in);
        d = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < d; i++) {
            n = scanner.nextInt();
            ArrayList<Integer> points = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                points.add(scanner.nextInt());
            }

            Collections.sort(points);
            highestNumber = points.get(n - 1);

            for (int k : points) {
                if (k == highestNumber) counter++;

            }
            for (int j = 0; j<counter; j++){
                System.out.print(highestNumber + " ");
            }
            for (int k : points) {

                if (k == highestNumber) break;
                System.out.print(k + " ");

            }
            counter = 0;
            highestNumber = 0;
        }

    }
}
