import java.util.Scanner;

public class MWPZ06A {
    public static void main(String[] args) {
        int liczbaZestawowDanych; // 1-500
        double x, y, z, wM, wD;
            // input 21 6 5    ;    11 1 13       ;      223 2 113
            // output    9              1                     0

        Scanner scanner = new Scanner(System.in);
        liczbaZestawowDanych = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < liczbaZestawowDanych; i++) {
            x=scanner.nextDouble()*12;
            y=scanner.nextDouble()*12;
            z=scanner.nextDouble();
            wM = Math.round((z*(y-x)-y)/(1-z));
            wD = wM-x;

            System.out.println(Math.abs((int)wD));
        }
    }
}
