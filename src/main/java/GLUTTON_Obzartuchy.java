import java.util.Scanner;

class GLUTTON_Obzartuchy {
    public static void main(String[] args) {
        int numTests;
        int invitedFatties;
        int cookiesInOneBox;
        int oneDayTimeSeconds = 86400;
        int boxesOfCookiesToBuy = 0;

        Scanner scanner = new Scanner(System.in);
        numTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i<numTests; i++){
            invitedFatties = scanner.nextInt();
            cookiesInOneBox = scanner.nextInt();
            scanner.nextLine();
            int[] invitedFattiesTable = new int[invitedFatties];
            int[] timeToEatOneCookie = new int [invitedFatties];
            for (int j = 0; j<invitedFatties; j++){
                timeToEatOneCookie[j] = scanner.nextInt();
                scanner.nextLine();
            }

        }



        System.out.println(boxesOfCookiesToBuy);
    }
}
