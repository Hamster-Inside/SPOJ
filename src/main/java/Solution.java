class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(15958));
    }

    public int solution(int N) {
        // write your code in Java SE 11
        int highestNumber = 0;
        String incomingValue = Integer.toString(N);

        if (N > 0) {
            int toCutNumber = incomingValue.indexOf("5");
            StringBuilder sb = new StringBuilder(incomingValue);
            sb.deleteCharAt(toCutNumber);
            String afterCutValue = sb.toString();
            highestNumber = Integer.parseInt(afterCutValue);
        }
        if (N < 0) {
            int toCutNumber = incomingValue.lastIndexOf("5");
            StringBuilder sb = new StringBuilder(incomingValue);
            sb.deleteCharAt(toCutNumber);
            String afterCutValue = sb.toString();
            highestNumber = Integer.parseInt(afterCutValue);


        }
        return highestNumber;
    }
}
