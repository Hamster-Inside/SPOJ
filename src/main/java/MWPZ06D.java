import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class MWPZ06D {
    public static void main(String[] args) {
        int liczbaZestawowDanych; // 1-500
        int liczbaOsob, liczbaCukierkow; // 1-10^9

        Scanner scanner = new Scanner(System.in);
        liczbaZestawowDanych = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < liczbaZestawowDanych; i++) {
            liczbaOsob = scanner.nextInt();
            liczbaCukierkow = scanner.nextInt();
            if (liczbaCukierkow == 0) {
                System.out.println("NIE");
                continue;
            }
            if (liczbaOsob == 0) {
                System.out.println("TAK");
                continue;
            }
            if (liczbaOsob == 1 && liczbaCukierkow >= 1) {
                System.out.println("TAK");
                continue;
            }
            if (liczbaOsob == 2 && liczbaCukierkow > 0) {
                System.out.println("NIE");
                continue;
            }
            liczbaOsob--;
            int reszta =  liczbaCukierkow % liczbaOsob;
            if (reszta != 0) System.out.println("TAK");
            else System.out.println("NIE");
        }
    }
}
