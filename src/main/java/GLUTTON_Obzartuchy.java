import java.util.Scanner;

class GLUTTON_Obzartuchy {
    public static void main(String[] args) {
        int numTests;
        int invitedFatties; // 1-10.000
        int cookiesInOneBox; // 1-1.000.000.000
        int oneDayTimeSeconds = 86400;
        int timeToEatOneCookie;
        int totalCookiesAte;
        int boxesOfCookiesToBuy = 0;

        Scanner scanner = new Scanner(System.in);
        numTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numTests; i++) {
            totalCookiesAte = 0;
            invitedFatties = scanner.nextInt();
            cookiesInOneBox = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < invitedFatties; j++) {
                timeToEatOneCookie = scanner.nextInt();
                scanner.nextLine();
                int tempCookies = oneDayTimeSeconds / timeToEatOneCookie;
                totalCookiesAte += tempCookies;
            }
            if ((totalCookiesAte % cookiesInOneBox) == 0) {
                boxesOfCookiesToBuy = totalCookiesAte / cookiesInOneBox;

            } else {
                boxesOfCookiesToBuy = (totalCookiesAte / cookiesInOneBox) + 1;
            }
            System.out.println(boxesOfCookiesToBuy);
        }
    }
}
