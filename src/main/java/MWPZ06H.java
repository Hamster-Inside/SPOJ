import java.util.Scanner;


public class MWPZ06H {
    public static void main(String[] args) {
        int d; // liczba zestawow danych 1-500
        int n; // liczba calkowita 1-200 - liczba uczestnikow konkursu

        // posortować najpierw max potem od najmniejszej. Np IN: 3 5 1 5 3 2 5 -> OUT: 5 5 5 1 2 3 3


        int min = 1001;
        int max = 1;
        Scanner scanner = new Scanner(System.in);
        d = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < d; i++) {
            n = scanner.nextInt();
            int[] points = new int[n]; // liczba punktow zdobyta przez uczestnikow 1-1000
            if (n == 1){
                System.out.println(scanner.nextInt());
                continue;
            }
            for (int j = 0; j < n; j++) {

                points[j] = scanner.nextInt();
                if (points[j] > max) {
                    max = points[j];
                }
                if (points[j] < min) {
                    min = points[j];
                }
            }

            for (int j = 0; j < n; j++) {

                if (points[j] == max) System.out.print(max + " ");
            }




            System.out.println();
            min = 1001;
            max = 1;

        }
    }
}
