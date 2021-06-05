import java.util.Arrays;

class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] A = {1, 2, 3, 55, 77, 29, 15, 100, 156, 201, 188, 122, 102};
        System.out.println(solution.solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 11
        int smallestInt = 1;
        Arrays.sort(A);
        boolean checkFailure = false;
        for (int i = 0; i < A.length; i++) {

            if (i + 1 < A.length) {


                if (A[i] + 1 == A[i + 1] || A[i] == A[i + 1]) {
                    checkFailure = true;
                    continue;
                } else {
                    checkFailure = false;
                    smallestInt = A[i] + 1;
                }

            }

        }
        if (checkFailure) {
            smallestInt = A[A.length - 1] + 1;
        }
        if (A[A.length - 1] < 1) {
            smallestInt = 1;
        }
        return smallestInt;
    }
}
