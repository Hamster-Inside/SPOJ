import java.util.Scanner;

public class BINOMS {
    public static void main(String[] args) {

        /*

        (n/k) = n! / (n-k)!k!
                (7/3)
                1 * 2 * 3 * 4 * 5 * 6 * 7
                (1 * 2 * 3 * 4) * 1 * 2 * 3


         */
        int t;
        int n;
        int k;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            int silniaN = 1;
            int silniaNK = 1;
            int silniaK = 1;
            n = scanner.nextInt();
            k = scanner.nextInt();

            if (k == 0 || k == n) {
                System.out.println("1");
                continue;
            }
            if (k == 1) {
                System.out.println(n);
                continue;
            }
            int cutPosition;
            if ((n - k) >= k) cutPosition = n - k;
            else cutPosition = k;
            for (int j = 1; j < n; j++) { // TODO jeśli jedno jest większe to nie trzeba go liczyć w forze
                silniaN *= (j+cutPosition);
                if (j <= (n - k)) {
                    silniaNK *= j;
                }
                if (j <= k) {
                    silniaK *= j;
                }
            }
            int result = silniaN / (silniaNK * silniaK);
            System.out.println(result);
        }
    }
}
