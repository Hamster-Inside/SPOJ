import java.text.DecimalFormat;
import java.util.Scanner;

class PP0504D_Reprezentacja_Liczb_Typu_Float {
    public static void main(String[] args) {
        int numTests;
        float x;
        Scanner scanner = new Scanner(System.in);
        numTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numTests; i++) {
            x = scanner.nextFloat();
            printfloat(x);

        }
    }


    public static void printfloat(float x) {

        long bits = Float.floatToIntBits(x);
        int k = (byte) (bits >> 24) & 0xff;
        int k2 = (byte) (bits >> 16) & 0xff;
        int k3 = (byte) (bits >> 8) & 0xff;
        int k4 = (byte) (bits) & 0xff;

        System.out.println(Integer.toHexString(k) + " " + Integer.toHexString(k2) + " " + Integer.toHexString(k3) + " " + Integer.toHexString(k4));
    }

}
