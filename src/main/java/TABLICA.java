import java.util.Scanner;

public class TABLICA {
    public static void main(String[] args) {

      int[] numberTable = new int[1000];

      int counter = 0;
        int test = 5;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            numberTable[counter] = scanner.nextInt();
            counter++;


       }
        int[] reversedTable = new int[counter];
        for (int i = 0; i<counter; i++){
            reversedTable[i] = numberTable[counter-1-i];
        }

        for(int k: reversedTable){
            System.out.println(k + " ");
        }
    }


}
