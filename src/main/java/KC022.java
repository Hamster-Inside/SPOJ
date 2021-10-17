import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KC022 {
    public static void main(String[] args) {
        int toFindPos;
        String numbersOfChaos;
        int counter = 1;

        String numAsText = "";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            toFindPos = scanner.nextInt();
            numbersOfChaos = scanner.nextLine();
            numbersOfChaos+=" ";
            List<Integer> numList = new ArrayList<>();
            for (int i = 0; i< numbersOfChaos.length(); i++){

                if (numbersOfChaos.charAt(i) == ' ' && !numAsText.equals("")) {
                    numList.add(Integer.parseInt(numAsText));
                    numAsText = "";
                    continue;
                }
                else if (numbersOfChaos.charAt(i) != ' ') numAsText+=numbersOfChaos.charAt(i);

            }
            Collections.sort(numList);
            if (toFindPos > numList.size()){
                System.out.println("-");
                continue;
            }
            if (toFindPos == 1) {
                System.out.println(numList.get(numList.size()-1));
                continue;
            }


            for (int i = numList.size()-1; i-->0;){
                if (numList.get(i) != numList.get(i+1)) counter++;
                if (counter == toFindPos) {
                    System.out.println(numList.get(i));
                    break;
                }

            }
            if (counter < toFindPos) System.out.println("-");
            counter = 1;


        }
    }
}
