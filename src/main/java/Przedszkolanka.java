import java.util.Scanner;

class Przedszkolanka {
    public static void main(String[] args) {
        byte numLoop;
        int a;
        int b;
        int result;
        int multiplier = 2;

        Scanner scanner = new Scanner(System.in);
        numLoop = scanner.nextByte();
        scanner.nextLine();
        for (int i = 0; i<numLoop; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            if (a<b){
                while (true){
                    if ((a*multiplier)%b == 0){
                        result = a*multiplier;
                        multiplier = 2;
                        break;
                    }
                    multiplier++;
                }
            } else if (a > b) {
                while (true){
                    if ((b*multiplier)%a == 0){
                        result = b*multiplier;
                        multiplier = 2;
                        break;
                    }
                    multiplier++;
                }
            }
            else {
                result = a;
            }
            System.out.println(result);
        }
    }
}
