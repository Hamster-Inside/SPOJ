import java.util.Scanner;

public class DCZPROST {
    public static void main(String[] args) {
        long x1, y1, x2, y2, startingPointX, startingPointY;
        long result = 0;


        Scanner scanner = new Scanner(System.in);
        x1 = scanner.nextInt();
        y1 = scanner.nextInt();
        x2 = scanner.nextInt();
        y2 = scanner.nextInt();
        if (x1 > 0 || y1 > 0 || x2 > 0 || y2 > 0) {
            //check X columns 1-2, 3-4, 5-6 etc
            if (x1 % 2 != 0) startingPointX = x1;
            else startingPointX = x1 + 1;

            for (long i = startingPointX; i < x2; i += 2) {
                if (i >= y1) { // jeżeli obecny punkt "i" jest w strefie kwadratu
                    if (y2 > i) { // jeżeli mamy w strefie kwadratu wszystkie punkty pionu
                        result += (i + 1 - y1); // dodajemy wszystkie punkty w pionie licząc od przycięcia y1
                    } else {
                        result += (y2 - y1);

                    }
                }
            }
            if (y1 % 2 != 0) startingPointY = y1;
            else startingPointY = y1 + 1;

            for (long i = startingPointY; i < y2; i += 2) {
                if (i >= x1) { // jeżeli obecny punkt "i" jest w strefie kwadratu
                    if (x2 > i) { // jeżeli mamy w strefie kwadratu wszystkie punkty poziomu
                        result += (i - x1); // dodajemy wszystkie punkty w poziomie licząc od przycięcia x1
                    } else {
                        result += (x2 - x1);

                    }
                }
            }

        }
        System.out.println(result);

    }

}
