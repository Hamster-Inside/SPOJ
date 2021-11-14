import java.util.Scanner;

public class BAJTELEK_v2 {
    public static void main(String[] args) {
        int numberOfDrawings;
        String inputPoints, emptyLine;

        Scanner scanner = new Scanner(System.in);

        numberOfDrawings = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfDrawings; i++) {
            while (true) {
                emptyLine = scanner.nextLine();
                if (!emptyLine.equals("")) break;
            }
            inputPoints = emptyLine;
            int[] blackPointsTable = pointsTable(inputPoints);
            inputPoints = scanner.nextLine();
            int[] grayPointsTable = pointsTable(inputPoints);
            for (int k: blackPointsTable){
                System.out.print(k + " ");
            }


        }
    }

    static int[] pointsTable(String inputNums) {
        String[] numbers = inputNums.split(" ");
        int[] points = new int[numbers.length];
        int i = 0;
        for (String n : numbers) {
            points[i++] = Integer.parseInt(n);
        }
        return points;
    }
}
