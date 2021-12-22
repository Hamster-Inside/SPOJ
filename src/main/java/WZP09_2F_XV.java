import java.math.BigInteger;
import java.util.Scanner;

public class WZP09_2F_XV {
    public static void main(String[] args) {
        BigInteger yeahBigNumber;
        Scanner scanner = new Scanner(System.in);
        while (true){
            yeahBigNumber = scanner.nextBigInteger();
            if (yeahBigNumber.equals(BigInteger.ZERO)) break;
            if (yeahBigNumber.mod(BigInteger.valueOf(15)).equals(BigInteger.ZERO)) System.out.println("TAK");
            else System.out.println("NIE");
        }
    }
}
