import java.util.Scanner;

public class BAJTELEK {
    public static void main(String[] args) {
        // wzór Picka -> P = W + 1/2 B -1
        // gdzie P - pole; W - liczba pkt kratowych wewnątrz wielokąta; B - liczba pkt na brzegu wielokąta
        int numberOfDrawings, lowestX, highestX, lowestY, highestY;
        int numOfBlackPoints, numOfGrayPoints, numOfPointsInsideBlack, numOfPointsInsideGray;

        String inputPoints;

        Scanner scanner = new Scanner(System.in);

        numberOfDrawings = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfDrawings; i++) {
            inputPoints = scanner.nextLine();
            int[] blackPointsTable = pointsTable(inputPoints);
            inputPoints = scanner.nextLine();
            int[] grayPointsTable = pointsTable(inputPoints);
            numOfBlackPoints = blackPointsTable.length / 2;
            numOfGrayPoints = grayPointsTable.length / 2;
            lowestX = findLowestX(blackPointsTable);
            highestX = findHighestX(blackPointsTable);
            lowestY = findLowestY(blackPointsTable);
            highestY = findHighestY(blackPointsTable);
            numOfPointsInsideBlack = pointsInside(blackPointsTable, lowestX, highestX, lowestY, highestY);
            lowestX = findLowestX(grayPointsTable);
            highestX = findHighestX(grayPointsTable);
            lowestY = findLowestY(grayPointsTable);
            highestY = findHighestY(grayPointsTable);
            numOfPointsInsideGray = pointsInside(grayPointsTable, lowestX, highestX, lowestY, highestY);

        }

    }

    static int pointsInside(int[] pointsTable, int lowestX, int highestX, int lowestY, int highestY) {
        int counter = 0;


        for (int i = lowestY; i < highestY; i++) {
            for (int j = lowestX; j<highestX; j++){

            }
        }
        return 0;
    }

    static int findLowestX(int[] tableOfNums) {
        int lowestNum = tableOfNums[0];
        for (int i = 0; i < tableOfNums.length; i += 2) {
            if (tableOfNums[i] < lowestNum) lowestNum = tableOfNums[i];
        }
        return lowestNum;
    }

    static int findHighestX(int[] tableOfNums) {
        int highestNum = tableOfNums[0];
        for (int i = 0; i < tableOfNums.length; i += 2) {
            if (tableOfNums[i] > highestNum) highestNum = tableOfNums[i];
        }
        return highestNum;
    }

    static int findLowestY(int[] tableOfNums) {
        int lowestNum = tableOfNums[1];
        for (int i = 1; i < tableOfNums.length; i += 2) {
            if (tableOfNums[i] < lowestNum) lowestNum = tableOfNums[i];
        }
        return lowestNum;
    }

    static int findHighestY(int[] tableOfNums) {
        int highestNum = tableOfNums[1];
        for (int i = 1; i < tableOfNums.length; i += 2) {
            if (tableOfNums[i] > highestNum) highestNum = tableOfNums[i];
        }
        return highestNum;
    }

    static int[] pointsTable(String inputNums) {
        String incomingNumber = "";
        int xyPoints;
        int positionInTable = 0;
        int counter = 0;
        boolean switchXY = true;
        for (int i = 0; i < inputNums.length(); i++) {
            if (inputNums.charAt(i) == ' ') counter++;
        }
        xyPoints = counter + 1;
        int[] points = new int[xyPoints];
        for (int j = 0; j < inputNums.length(); j++) {
            if (inputNums.charAt(j) != ' ') {
                incomingNumber += inputNums.charAt(j);
            } else {
                points[positionInTable] = Integer.parseInt(incomingNumber);
                incomingNumber = "";
                positionInTable++;
            }
            if (j == inputNums.length() - 1) {
                points[positionInTable] = Integer.parseInt(incomingNumber);
                incomingNumber = "";
            }
        }
        return points;
    }
}
