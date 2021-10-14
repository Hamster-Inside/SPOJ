import java.util.Scanner;

public class SIL {
    public static void main(String[] args) {
        long x1, y1, x2, y2, x3, y3, x4, y4;
        long xCounter = 0;
        long yCounter = 0;
        long p1, p2, p3;

        Scanner scanner = new Scanner(System.in);
        x1 = scanner.nextLong();
        y1 = scanner.nextLong();
        x2 = scanner.nextLong();
        y2 = scanner.nextLong();
        x3 = scanner.nextLong();
        y3 = scanner.nextLong();
        x4 = scanner.nextLong();
        y4 = scanner.nextLong();
        p1 = (x2 - x1) * (y2 - y1);
        p2 = (x4 - x3) * (y4 - y3);
        if (x3 >= x2 || y3 >= y2 || x4 <= x1 || y4 <= y1) System.out.println(p1 + p2);
        else if (x1 == x3 && x2 == x4 && y1 == y3 && y2 == y4) System.out.println(p1);
        else {
            // count how many covered in x
            for (long i = x1; i < x2; i++){
                if (i > x3 && i <=x4) xCounter++;
            }
            // count how many covered in y
            for (long i = y1; i< y2; i++){
                if (i > y3 && i <=y4) yCounter++;
            }


            p3 = xCounter*yCounter;
            System.out.println((p1+p2) - p3);
        }


    }
}
