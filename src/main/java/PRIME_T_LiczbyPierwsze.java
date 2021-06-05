import java.util.ArrayList;
import java.util.Scanner;

    class PRIME_T_LiczbyPierwsze {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int count = 0;
            int k;

            ArrayList<Integer> nums = new ArrayList<>();
            int numberOfnumbers = scan.nextInt();

            for (int i = 0; i < numberOfnumbers; i++) {
                k = scan.nextInt();
                if (k == 1){
                    System.out.println("NIE");
                    continue;
                }
                for (int j = 1; j < k + 1; j++) {
                    int c = k % j;
                    if (c == 0) {
                        count++;
                    }
                    if (count > 2) {
                        System.out.println("NIE");
                        break;
                    }
                }
                if (count <= 2) {
                    System.out.println("TAK");
                }
                count = 0;
            }
        }
    }

