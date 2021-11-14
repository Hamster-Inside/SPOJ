import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class BAJTELEK {
    static int toAddBlackFromLines, toAddGrayFromLines;
    static boolean checkingBlack = false;
    static boolean checkingGray = false;

    public static void main(String[] args) {

        int numberOfDrawings, lowestX, highestX, lowestY, highestY;
        int numOfBlackPoints, numOfGrayPoints, numOfPointsInsideBlack, numOfPointsInsideGray;
        long resultArea;
        double areaOfBlack, areaOfGray, resultCountAreaOfGray, resultCountAreaOfBlack;

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

// TODO liczenie punktów na liniach a nie tylko skrajne

            lowestX = findLowestX(blackPointsTable);
            lowestY = findLowestY(blackPointsTable);
            pushToTopRightPartOfCoordinateSystem(blackPointsTable, lowestX, lowestY);
            highestX = findHighestX(blackPointsTable);
            highestY = findHighestY(blackPointsTable);
            checkingBlack = true;
            numOfPointsInsideBlack = pointsInside(blackPointsTable, 0, highestX, 0, highestY);
            checkingBlack = false;

            lowestX = findLowestX(grayPointsTable);
            lowestY = findLowestY(grayPointsTable);
            pushToTopRightPartOfCoordinateSystem(grayPointsTable, lowestX, lowestY);
            highestX = findHighestX(grayPointsTable);
            highestY = findHighestY(grayPointsTable);
            checkingGray = true;
            numOfPointsInsideGray = pointsInside(grayPointsTable, 0, highestX, 0, highestY);
            checkingGray = false;
            numOfBlackPoints = (blackPointsTable.length / 2) - 1;
            numOfGrayPoints = (grayPointsTable.length / 2) - 1;
            numOfBlackPoints += toAddBlackFromLines;
            numOfGrayPoints += toAddGrayFromLines;
            areaOfBlack = countArea(numOfPointsInsideBlack, numOfBlackPoints);
            areaOfGray = countArea(numOfPointsInsideGray, numOfGrayPoints);
            resultCountAreaOfGray = (areaOfGray - areaOfBlack) * 6;
            resultCountAreaOfBlack = areaOfBlack * 10;
            /*System.out.println("result Area of gray = " + resultCountAreaOfGray);
            System.out.println("result Area of black = " + resultCountAreaOfBlack);
            System.out.println("num of black points = " + numOfBlackPoints);
            System.out.println("num of gray points = " + numOfGrayPoints);
            System.out.println("num of points inside black = " + numOfPointsInsideBlack);
            System.out.println("num of points inside gray = " + numOfPointsInsideGray);
            System.out.println("area of black = " + areaOfBlack);
            System.out.println("area of gray = " + areaOfGray);*/

            resultArea = (long) resultCountAreaOfBlack + (long) resultCountAreaOfGray;
            System.out.println(resultArea);
        }
    }


    private static double findAofLine(int y0, int y1, int x0, int x1) {
        double a;
        if (x0 == x1) return 0;
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

    static double countArea(int pointsInside, int numOfPointsAround) {
        // wzór Picka -> P = W + 1/2 B -1
        // gdzie P-pole; W-liczba pkt kratowych wewnątrz wielokąta; B-liczba pkt na brzegu wielokąta
        double area;
        area = pointsInside + ((double) numOfPointsAround / 2) - 1;
        return area;
    }


    static int pointsInside(int[] pointsTable, int lowestX, int highestX, int lowestY, int highestY) {
        toAddBlackFromLines = 0;
        toAddGrayFromLines = 0;
        int counter = 0;
        boolean isStartPoint, isEndPoint;
        int numberOfLines = (pointsTable.length / 2) - 1;
        String[] lineDirection = new String[numberOfLines];
        int point1PosX, point1PosY, point0posX, point0PosY, fromPointY, toPointY, nextLine;
        double a, b; // for y = ax + b
        int xPoints = highestX - lowestX + 1; // Maksymalnie będzie połowa punktów dla start i dla end. Później sprawdzenie czy linia jest startem, czy endem
        int yPoints = highestY - lowestY + 1;
        double[][] startPointsTable = new double[yPoints][xPoints]; // Jeśli punkty są od 0-5 na osi Y to potrzebne nam jest badanie tylko 1-4
        int[] numOfEndPointsAtY = new int[yPoints];
        int[] numOfStartPointsAtY = new int[yPoints];
        double[][] endPointsTable = new double[yPoints][xPoints];
        int[] ignoredPointsAtY = new int[yPoints];
        int[][] ignorePointsAtY = new int[yPoints][xPoints];
        int[][] lineNumberPointNumberX = new int[numberOfLines][2]; // [0][0] pierwsza linia pierwszy pkt [0][1] pierwsza linia drugi pkt (...) 10 11 20 21 itd.
        int[][] lineNumberPointNumberY = new int[numberOfLines][2];
        // assign lines + their directions
        for (int i = 0; i < numberOfLines; i++) {
            lineNumberPointNumberX[i][0] = pointsTable[i * 2];
            lineNumberPointNumberY[i][0] = pointsTable[i * 2 + 1];
            lineNumberPointNumberX[i][1] = pointsTable[i * 2 + 2];
            lineNumberPointNumberY[i][1] = pointsTable[i * 2 + 3];
            lineDirection[i] = findDirectionOfLine(lineNumberPointNumberX[i][0], lineNumberPointNumberX[i][1], lineNumberPointNumberY[i][0], lineNumberPointNumberY[i][1]);


        }


        // 2 1 3 2 4 9 2 1
        // x0>x1 oraz y0>y1 -> start, x0>x1 y0<y1 -> end, x0<x1 y0>y1 -> start, x0<x1 y0<y1 -> end
        // sprawdzanie czy linia jest poczatkowa czy koncowa i dodanie do odpowiedniej listy
        // jeżeli jest pozioma to sprawdzenie linii przed i za. W zaleznosci od kierunku ruchu będzie to linia otwierajaca albo zamykajaca zliczanie kropek srodkowych
        for (int i = 0; i < numberOfLines; i++) {
            point0posX = lineNumberPointNumberX[i][0];
            point0PosY = lineNumberPointNumberY[i][0];
            point1PosX = lineNumberPointNumberX[i][1];
            point1PosY = lineNumberPointNumberY[i][1];
            if (lineDirection[i].equals("N") || lineDirection[i].equals("NW") || lineDirection[i].equals("NE")) {
                isEndPoint = true;
                isStartPoint = false;
            } else if (lineDirection[i].equals("S") || lineDirection[i].equals("SW") || lineDirection[i].equals("SE")) {
                isEndPoint = false;
                isStartPoint = true;
            } else {
                isEndPoint = false;
                isStartPoint = false;
            }
            nextLine = i + 1;
            if (i == numberOfLines - 1) nextLine = 0;

            boolean neNW = lineDirection[nextLine].equals("N") || lineDirection[nextLine].equals("E") || lineDirection[nextLine].equals("NE") || lineDirection[nextLine].equals("NW");
            boolean sWs = lineDirection[nextLine].equals("W") || lineDirection[nextLine].equals("SW") || lineDirection[nextLine].equals("SE") || lineDirection[nextLine].equals("S");
            switch (lineDirection[i]) {
                case "N":
                    if (lineDirection[nextLine].equals("W") || lineDirection[nextLine].equals("SW") || lineDirection[nextLine].equals("SE")) {
                        ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                    } else endPointsTable[point1PosY][numOfEndPointsAtY[point1PosY]++] = point1PosX;
                    break;
                case "E": // SE same effect as E, SW same effect as E
                case "SE":
                case "SW":
                    if (neNW) {
                        ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                    } else startPointsTable[point1PosY][numOfStartPointsAtY[point1PosY]++] = point1PosX;
                    break;
                case "S":
                    if (lineDirection[nextLine].equals("E") || lineDirection[nextLine].equals("NE") || lineDirection[nextLine].equals("NW")) {
                        ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                    } else startPointsTable[point1PosY][numOfStartPointsAtY[point1PosY]++] = point1PosX;
                    break;
                case "W": // NE same effect as W, NW same effect as W
                case "NE":
                case "NW":
                    if (sWs) {
                        ignorePointsAtY[point1PosY][ignoredPointsAtY[point1PosY]++] = point1PosX;
                    } else endPointsTable[point1PosY][numOfEndPointsAtY[point1PosY]++] = point1PosX;
                    break;

            }

            if (point0PosY > point1PosY) {
                fromPointY = point1PosY;
                toPointY = point0PosY;
            } else {
                fromPointY = point0PosY;
                toPointY = point1PosY;
            }


            if (lineDirection[i].equals("E") || lineDirection[i].equals("W")) {
                if (Math.abs(point0posX - point1PosX) > 1) {
                    if (checkingBlack) toAddBlackFromLines += Math.abs(point0posX - point1PosX) - 1;
                    else if (checkingGray) toAddGrayFromLines += Math.abs(point0posX - point1PosX) - 1;
                }
            }
            // y = ax + b need
            if ((toPointY - fromPointY) > 1) {
                if (isEndPoint || isStartPoint) {
                    a = findAofLine(point0PosY, point1PosY, point0posX, point1PosX);
                    b = findBofLine(point0PosY, point0posX, a);
                    for (int j = fromPointY + 1; j < toPointY; j++) {
                        if (isStartPoint) {
                            if (a != 0) {
                                startPointsTable[j][numOfStartPointsAtY[j]++] = findXofLine(j, a, b);

                            } else {
                                startPointsTable[j][numOfStartPointsAtY[j]++] = point0posX;
                            }
                            if ((startPointsTable[j][numOfStartPointsAtY[j] - 1]) % 1 == 0) {
                                if (checkingGray) toAddGrayFromLines++;
                                else if (checkingBlack) toAddBlackFromLines++;
                            }
                        } else {
                            if (a != 0) {
                                endPointsTable[j][numOfEndPointsAtY[j]++] = findXofLine(j, a, b);
                            } else {
                                endPointsTable[j][numOfEndPointsAtY[j]++] = point0posX;
                            }
                            if ((endPointsTable[j][numOfEndPointsAtY[j] - 1]) % 1 == 0) {
                                if (checkingGray) toAddGrayFromLines++;
                                else if (checkingBlack) toAddBlackFromLines++;
                            }
                        }
                    }
                }
            }
        }
        int start, end, pointsToAdd;
        ArrayList<Double> startPointsList = new ArrayList<>();
        ArrayList<Double> endPointsList = new ArrayList<>();
        for (int i = lowestY + 1; i < highestY; i++) {
            startPointsList.clear();
            endPointsList.clear();
            for (int k = 0; k < numOfStartPointsAtY[i]; k++) {
                startPointsList.add(startPointsTable[i][k]);
                endPointsList.add(endPointsTable[i][k]);

            }
            Collections.sort(startPointsList);
            Collections.sort(endPointsList);
            for (int j = 0; j < startPointsList.size(); j++) {
                start = (int) Math.floor(startPointsList.get(j));
                end = (int) Math.ceil(endPointsList.get(j));
                pointsToAdd = end - start - 1;
                counter += pointsToAdd;
                for (int m = 0; m < ignoredPointsAtY[i]; m++) {
                    if (ignorePointsAtY[i][m] > start && ignorePointsAtY[i][m] < end) counter--;
                }
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
        String[] numbers = inputNums.split(" ");
        int[] points = new int[numbers.length];
        int i = 0;
        for (String n : numbers) {
            points[i++] = Integer.parseInt(n);
        }
        return points;
    }
}
