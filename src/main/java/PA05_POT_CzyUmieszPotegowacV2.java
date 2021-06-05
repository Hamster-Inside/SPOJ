import java.util.Scanner;

class PA05_POT_CzyUmieszPotegowacV2 {
    public static void main(String[] args) {
        int a;
        int b;
        int numCheck;
        int lastOfa;
        int lastOfab = 0;
        int[] twoHasLasts = {2, 4, 8, 6};
        int[] threeHasLasts = {3, 9, 7, 1};
        int[] fourHasLasts = {4, 6, 4, 6};
        int[] sevenHasLasts = {7, 9, 3, 1};
        int[] eightHasLasts = {8, 4, 2, 6};
        int[] nineHasLasts = {9, 1, 9, 1};
        Scanner scanner = new Scanner(System.in);
        numCheck = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numCheck; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            if (a >= 10) {
                lastOfa = a % 10;
            } else {
                lastOfa = a;
            }
            if (lastOfa == 1 || lastOfa == 5 || lastOfa == 6 || lastOfa == 0) {
                lastOfab = lastOfa;
                System.out.println(lastOfab);
                continue;
            } else {
                if (b%4 != 0){
                if (lastOfa == 2) lastOfab = twoHasLasts[(b % 4) - 1];
                if (lastOfa == 3) lastOfab = threeHasLasts[(b % 4) - 1];
                if (lastOfa == 4) lastOfab = fourHasLasts[(b % 4) - 1];
                if (lastOfa == 7) lastOfab = sevenHasLasts[(b % 4) - 1];
                if (lastOfa == 8) lastOfab = eightHasLasts[(b % 4) - 1];
                if (lastOfa == 9) lastOfab = nineHasLasts[(b % 4) - 1];
                System.out.println(lastOfab);
                continue;
            }
            else {

                        if (lastOfa == 2) lastOfab = twoHasLasts[3];
                        if (lastOfa == 3) lastOfab = threeHasLasts[3];
                        if (lastOfa == 4) lastOfab = fourHasLasts[3];
                        if (lastOfa == 7) lastOfab = sevenHasLasts[3];
                        if (lastOfa == 8) lastOfab = eightHasLasts[3];
                        if (lastOfa == 9) lastOfab = nineHasLasts[3];
                        System.out.println(lastOfab);
                        continue;
                }
            }
        }
    }
}
