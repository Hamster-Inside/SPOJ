import java.util.Scanner;

public class WI_TRIGR {
    public static void main(String[] args) {
        StringBuilder incomingText = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            incomingText.append(scanner.nextLine());
            incomingText.append("\n");
        }
        for (int i = 0; i < incomingText.length(); i++) {
            if (i+2 != incomingText.length()) {
                if (incomingText.charAt(i) == '?' && incomingText.charAt(i + 1) == '?' && incomingText.charAt(i + 2) != '?') {

                    if (incomingText.charAt(i + 2) == '=') incomingText.setCharAt(i, '#');
                    else if (incomingText.charAt(i + 2) == '/') incomingText.setCharAt(i, '\\');
                    else if (incomingText.charAt(i + 2) == '\'') incomingText.setCharAt(i, '^');
                    else if (incomingText.charAt(i + 2) == '(') incomingText.setCharAt(i, '[');
                    else if (incomingText.charAt(i + 2) == ')') incomingText.setCharAt(i, ']');
                    else if (incomingText.charAt(i + 2) == '!') incomingText.setCharAt(i, '|');
                    else if (incomingText.charAt(i + 2) == '<') incomingText.setCharAt(i, '{');
                    else if (incomingText.charAt(i + 2) == '>') incomingText.setCharAt(i, '}');
                    else if (incomingText.charAt(i + 2) == '-') incomingText.setCharAt(i, '~');

                    incomingText.deleteCharAt(i + 1);
                    incomingText.deleteCharAt(i + 1);
                }
            }
        }
        System.out.println(incomingText);
    }
}
