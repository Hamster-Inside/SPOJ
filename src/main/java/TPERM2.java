
import java.util.Scanner;

public class TPERM2 {
    static char[] perm = new char[11];
    static int[] letters = new int[11];
    public static void main(String[] args) {
        int tests, num;
        Scanner scanner = new Scanner(System.in);
        tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i<tests;i++) {
            num = scanner.nextInt();
            scanner.nextLine();
            generate(0,num);
        }
    }
    static void generate(int pos, int n){
        if (pos == n){
            for (int i =0; i<n; i++){
                System.out.print(perm[i]);
            }
            System.out.println();
        }
        for (int i =0; i<n;i++){
            if (letters[i] == 0){
                perm[pos] = (char)(i+'a');
                letters[i] = 1;
                generate(pos+1,n);
                letters[i] = 0;
            }
        }
    }
}
