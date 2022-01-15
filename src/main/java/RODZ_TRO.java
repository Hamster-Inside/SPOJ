import java.util.Scanner;

public class RODZ_TRO {
    public static void main(String[] args) {
        int[] line = new int[3];
        int result1,result2;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            line[0] = scanner.nextInt();
            line[1] = scanner.nextInt();
            line[2] = scanner.nextInt();
           if (line[0] > line[1]) swap(line,0,1);
           if (line[1] > line[2]) swap(line,1,2);
           if (line[0] + line[1] <= line[2]) {
               System.out.println("brak");
               continue;
           }
           result1 = (int) Math.pow((double)line[2],2);
           result2 = (int) Math.pow((double)line[0],2) + (int) Math.pow((double)line[1],2);
           if (result1 > result2) {
               System.out.println("rozwartokatny");
           }
           else if (result1 == result2){
               System.out.println("prostokatny");
           }
           else {
               System.out.println("ostrokatny");
           }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

}
