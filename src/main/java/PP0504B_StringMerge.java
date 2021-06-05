import java.util.Scanner;

class PP0504B_StringMerge {
    public static void main(String[] args) {
        int numTests;
        String manyStrings;
        String[] tableStrings;
        String inputString1;
        String inputString2;

        Scanner scanner = new Scanner(System.in);
        numTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i<numTests; i++) {
            manyStrings = scanner.nextLine();
            tableStrings = manyStrings.split(" ");
            inputString1 = tableStrings[0];
            inputString2 = tableStrings[1];
            char[] charsA = new char[inputString1.length()];
            char[] charsB = new char[inputString2.length()];
            for (int j = 0; j<inputString1.length(); j++){
                charsA[j] = inputString1.charAt(j);
            }
            for (int j = 0; j<inputString2.length(); j++){
                charsB[j] = inputString2.charAt(j);
            }
            System.out.println(string_merge(charsA,charsB));

        }}
    static char[] string_merge(char[] a, char[] b){
      char[] chars;
      int posOfchar = 0;
        if (a.length < b.length) {
             chars = new char[a.length*2];
        }
        else {
             chars = new char[b.length*2];
        }
        for (int i = 0; i<chars.length; i+=2){
            chars[i] = a[posOfchar];
            chars[i+1] = b[posOfchar];
            posOfchar++;
        }
                return chars;
    }
}
