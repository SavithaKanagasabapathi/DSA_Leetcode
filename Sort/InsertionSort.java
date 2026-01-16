import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] inputArray = { 10, 5, 40, 8, 9, 6 };
        int length = inputArray.length;

        for (int i = 1; i < length; i++) {// Let be first element sorted
            int key = inputArray[i];
            int j = i - 1;

            while (j >= 0 && inputArray[j] > key) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = key;

        }
        System.out.println(Arrays.toString(inputArray));
    }

    // Initial - [10, 5, 40, 8, 9, 6] (10 is already "sorted").
    // Pass 1 5 [5, 10, 40, 8, 9, 6] 5 moves before 10.
    // Pass 2 40 [5, 10, 40, 8, 9, 6] 40 stays (already > 10).
    // Pass 3 8 [5, 8, 10, 40, 9, 6] 8 moves before 10 and 40.
    // Pass 4 9 [5, 8, 9, 10, 40, 6] 9 moves before 10 and 40.
    // Pass 5 6 [5, 6, 8, 9, 10, 40] 6 moves before 8, 9, 10, 40.

    // Time Complexity:
    // Best Case (Sorted) O(n) (with flag)
    // Worst Case (Reverse) O(n^2)
    // Space Complexity - O(1)
}
