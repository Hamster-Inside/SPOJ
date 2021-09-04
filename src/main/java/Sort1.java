import java.util.*;
import java.util.stream.Collectors;


public class Sort1 {
    public static void main(String[] args) {
        int t; // number of tests
        int n; // number of x-y coordinates for each test
        String sign; // unique sign for coordinates
        int x; // coordinate x
        int y; // coordinate y
        double c; // distance from mid
        String coordinates;
        String[][] coordinatesList = new String[100][1000];
        int[] howManyInside = new int[1000];
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            Map<String, Double> map = new HashMap<>();

            n = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < n; j++) {
                sign = scanner.next();
                x = scanner.nextInt();
                y = scanner.nextInt();
                c = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
                coordinates = sign + " " + x + " " + y;
                map.put(coordinates, c);

            }

            List<Double> keyValues = new ArrayList<>(map.values());
            Collections.sort(keyValues);
            int index = 0;
            for (Double keyVal : keyValues) {
                coordinatesList[i][index] = getKeys(map, keyVal);
                index++;
                howManyInside[i] = index;
            }

            scanner.nextLine();
        }
        for (int k = 0; k < t; k++) {
            for (n = 0; n < howManyInside[k]; n++) {
                System.out.println(coordinatesList[k][n]);
            }
            System.out.println();
        }
    }

    private static String getKeys(
            Map<String, Double> map, Double value) {

        return map
                .entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).toString()
                .replace("[", "")
                .replace("]", "");

    }
}
