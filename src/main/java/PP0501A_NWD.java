import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PP0501A_NWD {
    public static void main(String[] args) {
        int a;
        int b;
        int numLoop;

        Scanner scanner = new Scanner(System.in);
        numLoop = scanner.nextInt();
        for (int i = 0; i < numLoop; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            if (a < b) System.out.println(nwd(a, b));
            if (a > b) System.out.println(nwd(b, a));
            if (a == b) System.out.println(a);
        }
    }

    static int nwd(int a, int b) {
        int result = 1;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int g = 0;
        int constA = a;
        int constB = b;
        int aCounter = 0;
        int bCounter = 0;
        int[] tableA = new int[20];
        int[] tableB = new int[20];
        int[] tableMultiplier = new int[20];
        for (int i = 2; i < constA; i++) {
            if (a % i == 0) {
                tableA[c] = i;
                a /= i;
                c++;
                i=1;
            }
            if (a == 1) break;
        }
        for (int i = 2; i < constB; i++) {
            if (b % i == 0) {
                tableB[d] = i;
                b /= i;
                d++;
                i = 1;
            }
            if (b == 1) break;
        }
        while (tableA[e] != 0) {
            aCounter++;
            e++;
        }
        while (tableB[f] != 0) {
            bCounter++;
            f++;
        }
        if (aCounter <= bCounter) {
            for (int i = 0; i < aCounter; i++) {
                for (int j = 0; j < bCounter; j++) {
                    if (tableA[i] == tableB[j]){
                        tableMultiplier[g] = tableA[i];
                        tableB[j] = 0;
                        g++;
                        break;
                    }
                }
            }
        }
        if (bCounter < aCounter){
            for (int i = 0; i < bCounter; i++) {
                for (int j = 0; j < aCounter; j++) {
                    if (tableA[j] == tableB[i]){
                        tableMultiplier[g] = tableB[i];
                        tableA[j] = 0;
                        g++;
                        break;
                    }
                }
            }
        }
        g = 0;
        while (tableMultiplier[g] != 0){
            result *= tableMultiplier[g];
            g++;
        }


        return result;
    }

}
