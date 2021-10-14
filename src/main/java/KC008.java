import java.util.Scanner;

public class KC008 {
    public static void main(String[] args) {
        long number;
        long sum=0;
        long sumOfsums = 0;
        String line;
        String num = "";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
           line = scanner.nextLine();

            for (int i =0; i< line.length(); i++){
                if (line.charAt(i) != ' '){
                    num+=line.charAt(i);
                    if (i == line.length()-1){
                        sum+=Integer.parseInt(num);
                        num = "";
                    }
                }
                else {
                    sum+=Integer.parseInt(num);
                    num = "";
                }
            }
            System.out.println(sum);
            sumOfsums+=sum;
            sum = 0;

        }
        System.out.println(sumOfsums);
    }
}
