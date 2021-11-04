import java.util.Scanner;

public class BAJTELEK {
    public static void main(String[] args) {

        int numberOfDrawings, lowestX, highestX, lowestY, highestY;
        int numOfBlackPoints, numOfGrayPoints, numOfPointsInsideBlack, numOfPointsInsideGray, areaOfBlack, areaOfGray;

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
            areaOfBlack = countArea(numOfPointsInsideBlack, numOfBlackPoints);
            areaOfGray = countArea(numOfPointsInsideGray, numOfGrayPoints);
            for (int k: blackPointsTable){
                System.out.print(k + " ");
            }
            System.out.println();
            for (int k: grayPointsTable){
                System.out.print(k + " ");
            }
            System.out.println();
            System.out.println(areaOfGray-areaOfBlack);
        }

    }

    static int countArea(int pointsInside, int numOfPointsAround) {
        // wzór Picka -> P = W + 1/2 B -1
        // gdzie P-pole; W-liczba pkt kratowych wewnątrz wielokąta; B-liczba pkt na brzegu wielokąta
        int area;
        area = pointsInside + (numOfPointsAround / 2) - 1;
        return area;
    }

    static int pointsInside(int[] pointsTable, int lowestX, int highestX, int lowestY, int highestY) {
        int counter = 0;
        int posStart = 0;
        int posEnd = 0;
        boolean checkIfIsStartLine, goingRight, goingLeft, isHorizontal, isVertical;
        int xPoints = pointsTable.length/4; // Maksymalnie będzie połowa punktów dla start i dla end. Później sprawdzenie czy linia jest startem, czy endem
        int yPoints = highestY-lowestY-1;
        double[][] startPointsTable = new double [yPoints][xPoints]; // Jeśli punkty są od 0-5 na osi Y to potrzebne nam jest badanie tylko 1-4
        double[][] endPointsTable = new double [yPoints][xPoints];
        int[] pointsAtY = new int[yPoints];

        for (int i = 0; i< (pointsTable.length/2)-1; i+=2){

        }


        for (int i = lowestY; i < highestY; i++) {
            for (int j = lowestX; j < highestX; j++) {

            }
        }
        return counter;
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
