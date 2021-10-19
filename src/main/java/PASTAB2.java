import java.util.Scanner;

public class PASTAB2 {
    public static void main(String[] args) {
        int n;
        char sign;
        int numToCompare;
        Scanner scanner = new Scanner(System.in);
        n= scanner.nextInt();
        int[] numTable = new int[n];
        for (int i = 0; i<n; i++){
            numTable[i] = scanner.nextInt();
        }
        sign = scanner.next().charAt(0);
        numToCompare = scanner.nextInt();
        if (sign == '<'){
            for (int i = 0; i<n; i++){
                if (numTable[i] < numToCompare) System.out.println(numTable[i]);
            }
        }
        else if (sign == '>'){
            for (int i = 0; i<n; i++){
                if (numTable[i] > numToCompare) System.out.println(numTable[i]);
            }
        }
    }
}
