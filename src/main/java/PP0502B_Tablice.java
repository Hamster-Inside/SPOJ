import java.util.Scanner;

class PP0502B_Tablice {
    public static void main(String[] args) {
        int numTests;
        int numOfNumbers;


        Scanner scanner = new Scanner(System.in);
        numTests = scanner.nextInt();
        scanner.nextLine();
        for (int i =0; i<numTests; i++){
            numOfNumbers = scanner.nextInt();
            int[] table = new int[numOfNumbers];
            int[] reversedTable = new int [numOfNumbers];
            for (int j = 0; j<numOfNumbers; j++){
                table[j] = scanner.nextInt();
            }
            for (int j = 0; j<numOfNumbers; j++){
                reversedTable[j] = table[numOfNumbers-j-1];
            }
          for (int a: reversedTable){
              System.out.print(a + " ");

          }
            System.out.println();
        }
    }
}
