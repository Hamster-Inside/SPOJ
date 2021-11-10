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
            lowestY = findLowestY(blackPointsTable);
            pushToTopRightPartOfCoordinateSystem(blackPointsTable, lowestX, lowestY);
            highestX = findHighestX(blackPointsTable);
            highestY = findHighestY(blackPointsTable);
            numOfPointsInsideBlack = pointsInside(blackPointsTable, 0, highestX, 0, highestY);


            lowestX = findLowestX(grayPointsTable);
            lowestY = findLowestY(grayPointsTable);
            pushToTopRightPartOfCoordinateSystem(grayPointsTable, lowestX, lowestY);
            highestX = findHighestX(grayPointsTable);
            highestY = findHighestY(grayPointsTable);
            numOfPointsInsideGray = pointsInside(grayPointsTable, 0, highestX, 0, highestY);


            areaOfBlack = countArea(numOfPointsInsideBlack, numOfBlackPoints);
            areaOfGray = countArea(numOfPointsInsideGray, numOfGrayPoints);

            System.out.println(areaOfGray - areaOfBlack);
        }

    }

    private static double findAofLine(int y0, int y1, int x0, int x1) {
        double a;
        a = (double) (y0 - y1) / (x0 - x1);
        return a;
    }

    private static double findBofLine(int y0, int x0, double a) {
        double b;
        b = (double) y0 - a * x0;
        return b;
    }

    private static double findXofLine(int y, double a, double b) {
        double x;
        x = (y - b) / a;
        return x;
    }

    // moving points only to work on 0 - max(X) and 0 - max(Y). Didn't want to use negative values in methods. Not necessary.
    private static void pushToTopRightPartOfCoordinateSystem(int[] pointsTable, int lowestX, int lowestY) {
        int toAddX = lowestX * (-1);
        int toAddY = lowestY * (-1);
        if (lowestX != 0) {
            for (int i = 0; i < pointsTable.length; i += 2) {
                pointsTable[i] += toAddX;
            }
        }
        if (lowestY != 0) {
            for (int i = 1; i < pointsTable.length; i += 2) {
                pointsTable[i] += toAddY;
            }
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
        int lineNo = 0;
        int pointNo = 0;
        int numberOfLines = pointsTable.length / 2;
        String[] lineDirection = new String[numberOfLines];
        int point1PosX, point1PosY;
        boolean checkIfIsStartLine;
        int xPoints = pointsTable.length / 4; // Maksymalnie będzie połowa punktów dla start i dla end. Później sprawdzenie czy linia jest startem, czy endem
        int yPoints = highestY - lowestY - 1;
        double[][] startPointsTable = new double[yPoints][xPoints]; // Jeśli punkty są od 0-5 na osi Y to potrzebne nam jest badanie tylko 1-4
        int[] numOfEndPointsAtY = new int[yPoints];
        int[] numOfStartPointsAtY = new int[yPoints];
        double[][] endPointsTable = new double[yPoints][xPoints];
        int[] pointsAtY = new int[xPoints];
        int[] ignoredPointsAtY = new int[highestX - lowestX];
        int[][] ignorePointsAtY = new int[highestY - lowestY][highestX - lowestX];
        int[][] lineNumberPointNumberX = new int[numberOfLines][2]; // [0][0] pierwsza linia pierwszy pkt [0][1] pierwsza linia drugi pkt (...) 10 11 20 21 itd.
        int[][] lineNumberPointNumberY = new int[numberOfLines][2];
        // assign lines + their directions
        for (int i = 0; i < pointsTable.length; i += 2) {
            lineNumberPointNumberX[lineNo][pointNo] = pointsTable[i];
            lineNumberPointNumberY[lineNo][pointNo] = pointsTable[i + 1];
            lineNo++;
            pointNo++;
            if (pointNo == 2) pointNo = 0;
            if (lineNo != numberOfLines - 1) lineDirection[lineNo] = findDirectionOfLine(i, i + 2, i + 1, i + 3);
            else lineDirection[lineNo] = findDirectionOfLine(i, 0, i + 1, 1);
        }


        // 2 1 3 2 4 9 2 1
        // x0>x1 oraz y0>y1 -> start, x0>x1 y0<y1 -> end, x0<x1 y0>y1 -> start, x0<x1 y0<y1 -> end
        // sprawdzanie czy linia jest poczatkowa czy koncowa i dodanie do odpowiedniej listy
        // jeżeli jest pozioma to sprawdzenie linii przed i za. W zaleznosci od kierunku ruchu będzie to linia otwierajaca albo zamykajaca zliczanie kropek srodkowych
        for (int i = 0; i < numberOfLines; i++) {
            point1PosX = lineNumberPointNumberX[i][1];
            point1PosY = lineNumberPointNumberY[i][1];

            int nextLine = i + 1;
            if (i == numberOfLines - 1) nextLine = 0;
            boolean neNW = lineDirection[nextLine].equals("N") || lineDirection[nextLine].equals("E") || lineDirection[nextLine].equals("NE") || lineDirection[nextLine].equals("NW");
            boolean sWs = lineDirection[nextLine].equals("W") || lineDirection[nextLine].equals("SW") || lineDirection[nextLine].equals("SE") || lineDirection[nextLine].equals("S");
            if (lineDirection[i].equals("N")) {
                if (lineDirection[nextLine].equals("W") || lineDirection[nextLine].equals("SW") || lineDirection[nextLine].equals("SE")) {
                    ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                } else endPointsTable[point1PosY][numOfEndPointsAtY[point1PosY]++] = point1PosX;
            } else if (lineDirection[i].equals("E")) {
                if (neNW) {
                    ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                } else startPointsTable[point1PosY][numOfStartPointsAtY[point1PosY]++] = point1PosX;
            } else if (lineDirection[i].equals("S")) {
                if (lineDirection[nextLine].equals("E") || lineDirection[nextLine].equals("NE") || lineDirection[nextLine].equals("NW")) {
                    ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                } else startPointsTable[point1PosY][numOfStartPointsAtY[point1PosY]++] = point1PosX;
            } else if (lineDirection[i].equals("W")) {
                if (sWs) {
                    ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                } else endPointsTable[point1PosY][numOfEndPointsAtY[point1PosY]++] = point1PosX;
            } else if (lineDirection[i].equals("NE")) {
                if (sWs) {
                    ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                } else endPointsTable[point1PosY][numOfEndPointsAtY[point1PosY]++] = point1PosX;
            } else if (lineDirection[i].equals("SE")) {
                if (neNW) {
                    ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                } else startPointsTable[point1PosY][numOfStartPointsAtY[point1PosY]++] = point1PosX;
            } else if (lineDirection[i].equals("NW")) {
                if (sWs) {
                    ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                } else endPointsTable[point1PosY][numOfEndPointsAtY[point1PosY]++] = point1PosX;
            } else if (lineDirection[i].equals("SW")) {
                if (neNW) {
                    ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                } else startPointsTable[point1PosY][numOfStartPointsAtY[point1PosY]++] = point1PosX;
            }


        }


        for (int i = lowestY; i < highestY; i++) {
            for (int j = lowestX; j < highestX; j++) {

            }
        }
        return counter;
    }

    static String findDirectionOfLine(int x0, int x1, int y0, int y1) {

        if (x0 == x1) {
            if (y0 > y1) return "S";
            else return "N";
        } else if (y0 == y1)
            if (x0 > x1) return "W";
            else return "E";
        else if (x0 > x1) {
            if (y0 > y1) return "SW";
            else return "NW";
        } else {
            if (y0 > y1) return "SE";
            else return "NE";
        }
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
