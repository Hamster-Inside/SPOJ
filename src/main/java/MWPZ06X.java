import java.util.Scanner;

public class MWPZ06X {
    public static void main(String[] args) {
        int liczbaZestawowDanych; // 1-500
        int kroki;
        Scanner scanner = new Scanner(System.in);
        liczbaZestawowDanych = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < liczbaZestawowDanych; i++) {
            kroki = scanner.nextInt();
            System.out.println(kroki*kroki);
        }
    }
}
