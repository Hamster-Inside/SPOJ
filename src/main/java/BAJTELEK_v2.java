import java.util.Scanner;

public class BAJTELEK_v2 {
    public static void main(String[] args) {
        int numberOfDrawings;
        long result;
        double resultAreaOfGray, resultAreaOfBlack, resultBlack, resultGray;
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
            long[] blackPointsTable = pointsTable(inputPoints);
            inputPoints = scanner.nextLine();
            long[] grayPointsTable = pointsTable(inputPoints);
            resultAreaOfBlack = countArea(blackPointsTable);
            resultAreaOfGray = countArea(grayPointsTable);
            resultBlack = resultAreaOfBlack*10;
            resultGray = (resultAreaOfGray-resultAreaOfBlack)*6;
            result = (long)(resultBlack+resultGray);
            System.out.println(result);

        }
    }

    static double countArea(long[] table){
        double result = 0;
        double sum = 0;
        for (int i = 0; i<table.length-3;i+=2){
            sum+=((table[i]+table[i+2])*(table[i+1]-table[i+3]));
        }

        result = 0.5*Math.abs(sum);
        return result;
    }

    static long[] pointsTable(String inputNums) {
        String[] numbers = inputNums.split(" ");
        long[] points = new long[numbers.length];
        int i = 0;
        for (String n : numbers) {
            points[i++] = Integer.parseInt(n);
        }
        return points;
    }
}
