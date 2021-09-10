import java.util.Scanner;

public class EUCGAME {
    public static void main(String[] args) {
        int numberOfTests;
        int a;
        int b;

        Scanner scanner = new Scanner(System.in);
        numberOfTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i<numberOfTests; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            while (true){
                if (a == b){
                    System.out.println(a+b);
                    break;
                }
                if (a>b){
                    a-=b;
                }
                else{
                    b-=a;
                }
            }
        }
    }
}
