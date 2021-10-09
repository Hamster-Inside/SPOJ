import java.util.Scanner;


public class MWPZ06H_v2 {
    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    public static int setPivot(int[] table, int lt, int rt) {
        int pivot = table[rt];
        int i = lt - 1;
        for (int j = lt; j < rt; j++) {
            if (table[j] < pivot) {
                i++;
                swap(table, i,j);
            }
        }
        swap(table, i+1, rt);
        return i + 1;
    }

    public static void QuickSort(int[] table, int lt, int rt) {
        if (lt < rt) {
            int mid = setPivot(table, lt, rt);
            QuickSort(table, lt, mid - 1);
            QuickSort(table, mid + 1, rt);
        }
    }

    public static void main(String[] args) {
        int d; // liczba zestawow danych 1-500
        int n; // liczba calkowita 1-200 - liczba uczestnikow konkursu
        int highestNumber = 0;
        int counter = 0;
        // posortować najpierw max potem od najmniejszej. Np IN: 3 5 1 5 3 2 5 -> OUT: 5 5 5 1 2 3 3

        Scanner scanner = new Scanner(System.in);
        d = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < d; i++) {
            n = scanner.nextInt();
            int[] table = new int[n];
            for (int j = 0; j < n; j++) {
                table[j] = scanner.nextInt();
            }

            QuickSort(table, 0, n - 1);
            highestNumber = table[n - 1];

            for (int j = n - 1; j >= 0; j--) {
                if (table[j] == highestNumber) counter++;
                else break;
            }
            for (int j = 0; j < counter; j++) {
                System.out.print(highestNumber + " ");
            }
            for (int k : table) {

                if (k == highestNumber) break;
                System.out.print(k + " ");

            }
            System.out.println();
            counter = 0;
            highestNumber = 0;
        }

    }
}
