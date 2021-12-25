import java.util.Scanner;

public class JZAPKAB {
    public static void main(String[] args) {
        String incomingText;
        char[]  chars = {'a', 'b', 'c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','v','x','y','z'};
        int[] nums = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100,200,300,400,500};
        int takeFrom = 0;
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        incomingText = scanner.nextLine();
        for (int i = 0; i < incomingText.length();i++){
            for (int j = 0; j<chars.length; j++){
                if (incomingText.charAt(i) == chars[j]) takeFrom = nums[j];
            }
            result+=takeFrom;
        }
        System.out.println(result);
    }
}
