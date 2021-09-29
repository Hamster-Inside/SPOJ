import java.util.Scanner;

public class NIEKOLEJ {
    public static void main(String[] args) {
        int n;
        // incoming data: 2 ->  out: NIE (nie mogą być dwie liczby obok siebie)
        // incoming data: 4 -> out: 1 4 2 0 3
        // incoming data: 11 -> out: 1 11 2 10 3 9 4 8 5 7 0 6
        // incoming data: 10 -> out: 1 10 2 9 3 8 4 7 5 0 6
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= n; i++) {
            if (n == 0) {
                System.out.print(n);
                break;
            }
            if (n == 2 || n == 1){
                System.out.print("NIE");
                break;
            }
            if (i == n / 2 && n % 2 == 0) {
                System.out.print(i + " 0 " +  (i+1));

                break;
            }
            if (i == n / 2 && n % 2 != 0) {
                System.out.print(i + " " + (i+2) + " 0 " + (i+1));
                                break;
            }
            System.out.print(i + " " + (n+1-i) + " ");


        }
    }
}
