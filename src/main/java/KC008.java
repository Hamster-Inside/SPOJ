import java.util.Scanner;

public class KC008 {
    public static void main(String[] args) {
        long number;
        long sum=0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            number = scanner.nextLong();
            sum+=number;
            if (number == 0){
                System.out.println(sum);
                sum = 0;
            }
        }
    }
}
