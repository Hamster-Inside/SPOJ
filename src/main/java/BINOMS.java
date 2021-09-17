import java.util.Scanner;

public class BINOMS {
    public static void main(String[] args) {

        /*

        (n/k) = n! / (n-k)!k!
                (7/3)
                1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14
                (1 * 2 * 3 * 4 * 5 * 6 * 7) * 1 * 2 * 3 * 4 * 5 * 6 * 7
         */
        int t;
        int n;
        int k;

        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            boolean cutK;
            int silniaN = 1;
            int silniaNK = 1;
            int silniaK = 1;
            int interCounter = 1;
            int masterNumber = 1;
            int interMasterCounter = 1;
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
            if (k > n) {
                System.out.println("0");
                continue;
            }
            int cutPosition;
            if ((n - k) >= k) {
                cutPosition = n - k;
                interCounter = k;
            } else {
                cutPosition = k;
                interCounter = n-k;
            }
            for (int j = cutPosition + 1; j <= n; j++) { // TODO jeśli jedno jest większe to nie trzeba go liczyć w forze
                silniaN *= j;
                if (interMasterCounter <= interCounter){
                    masterNumber*=interMasterCounter;
                    interMasterCounter++;
                }
                if (silniaN%masterNumber == 0){
                    silniaN/=masterNumber;
                    masterNumber = 1;


                }
            }

            int result = silniaN / masterNumber;
            System.out.println(result);
        }
    }
}
