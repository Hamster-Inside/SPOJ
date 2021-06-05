import java.util.Scanner;

class FCTRL3_DwieCyfrySilni {
    public static void main(String[] args) {
        int factorialNum;
        int numLoop;
        int factorialResult;
        Scanner scanner = new Scanner(System.in);
        numLoop = scanner.nextInt();
        for (int i = 0; i < numLoop; i++) {
            factorialNum = scanner.nextInt();
            if (factorialNum < 2) {
                System.out.println("0 1");
            }
            if (factorialNum >= 10) {
                System.out.println("0 0");
            }
            if (factorialNum >= 2 && factorialNum< 10){
                factorialResult = 1;
                for (int j = 1; j <= factorialNum; j++) {
                    factorialResult = (factorialResult * j) % 100;
                }
                int a;
                int b;
                b = factorialResult % 10;
                a = (factorialResult - b) / 10;
                System.out.println(a + " " + b);

            }

        }
    }
}
