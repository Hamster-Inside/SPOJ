import java.util.Scanner;

class PA05_POT_CzyUmieszPotegowac {
    public static void main(String[] args) {
        int a;
        int b;
        String inputValues;
        int spacePos;
        int numCheck;
        int lastOfab = 0;
        Scanner scanner = new Scanner(System.in);
        numCheck = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numCheck; i++) {
            inputValues = scanner.nextLine();
            spacePos = inputValues.indexOf(" ");
            a = Integer.parseInt(inputValues.substring(0,spacePos));
            b = Integer.parseInt(inputValues.substring(spacePos+1));
            lastOfab = a;
            for (int j = 1; j < b; j++) {
                lastOfab = a*lastOfab;
                if (lastOfab > 10){
                    lastOfab = lastOfab%10;
                }
            }
            System.out.println(lastOfab);
        }
    }
}
