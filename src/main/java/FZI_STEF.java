import java.util.Scanner;

public class FZI_STEF {
    public static void main(String[] args) {
        int cities;
        int plusNumber = 0;
        long highestNum = 0;
        long sum = 0;
        Scanner scanner = new Scanner(System.in);
        cities = scanner.nextInt();
        int[] money = new int[cities];
        for (int i = 0; i < cities; i++) {
            money[i] = scanner.nextInt();
            if (money[i] > 0) {
                highestNum = money[i];
                plusNumber++;
            }
        }
        if (plusNumber > 1){
            for (int i = 0; i<money.length; i++){
                sum+=money[i];
                if (sum < 0 && i != money.length-1){
                    sum = 0;
                }
                else if (sum < 0 && i == money.length-1) break;
                if (highestNum < sum) highestNum = sum;
            }
            System.out.println(highestNum);
        }
        else if (plusNumber == 1) System.out.println(highestNum);
        else System.out.println("0");
    }
}
