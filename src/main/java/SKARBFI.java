import java.util.Scanner;

public class SKARBFI {
    public static void main(String[] args) {
        int liczbaZestawowDanych;
        int liczbaWskazowek;
        int a;
        int b;
        int bPolnocPoludnie;
        int bWschodZachod;
        Scanner scanner = new Scanner(System.in);
        liczbaZestawowDanych = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < liczbaZestawowDanych; i++) {
            liczbaWskazowek = scanner.nextInt();
            scanner.nextLine();
            bPolnocPoludnie = 0;
            bWschodZachod = 0;
            for (int j = 0; j < liczbaWskazowek; j++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                if (a == 0 && b > 0) {
                    bPolnocPoludnie += b;
                }
                if (a == 1 && b > 0) {
                    bPolnocPoludnie -= b;
                }
                if (a == 2 && b > 0) {
                    bWschodZachod -= b;
                }
                if (a == 3 && b > 0) {
                    bWschodZachod += b;
                }
            }

            if (bPolnocPoludnie == 0 && bWschodZachod == 0) {
                System.out.println("studnia");
            } else if (bPolnocPoludnie == 0) {
                if (bWschodZachod > 0) {
                    a = 3;
                } else {
                    a = 2;
                }
                System.out.println(a + " " + Math.abs(bWschodZachod));
            } else if (bWschodZachod == 0) {
                if (bPolnocPoludnie > 0) {
                    a = 0;
                } else {
                    a = 1;
                }
                System.out.println(a + " " + Math.abs(bPolnocPoludnie));
            } else {
                if (bPolnocPoludnie > 0) {
                    a = 0;
                } else {
                    a = 1;
                }
                System.out.println(a + " " + Math.abs(bPolnocPoludnie));

                if (bWschodZachod > 0) {
                    a = 3;
                } else {
                    a = 2;
                }
                System.out.println(a + " " + Math.abs(bWschodZachod));
            }
        }
    }
}
