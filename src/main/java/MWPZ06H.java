import java.util.Scanner;

public class MWPZ06H {
    public static void main(String[] args) {
        int d; // liczba zestawow danych 1-500
        int n; // liczba calkowita 1-200 - liczba uczestnikow konkursu

        int minAt = 0;
        int min = 1001;
        int max = 1;
        int counterMax = 0;
        Scanner scanner = new Scanner(System.in);
        d = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < d; i++) {
            n = scanner.nextInt();
            int[] points = new int[n]; // liczba punktow zdobyta przez uczestnikow 1-1000
            for (int j = 0; j < n; j++) {

                points[j] = scanner.nextInt();
                if (points[j] > max) {
                    max = points[j];

                }
                if (points[j] <= min){
                    min = points[j];
                    minAt = j;
                }
            }
            for (int j = 0; j<n; j++){
                if (points[j] == max) counterMax++;
            }
            for (int j = 0; j<counterMax; j++){
                System.out.print(max + " ");
            }
            System.out.print(min + " ");
            for (int j = 0; j<n; j++){
                if (points[j] == max || j == minAt) continue;
                System.out.print(points[j] + " ");
            }
            System.out.println();
            min = 1001;
            max = 1;
            minAt = 0;

            counterMax = 0;
        }
    }
}
