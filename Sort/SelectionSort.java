import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] inputArray = { 10, 5, 40, 8, 9, 6 };
        int length = inputArray.length;

        for (int i = 0; i < length - 1; i++) {// iterations
            int minimunIndex = i; // End of each iteration, 'i' will be sorted
            for (int j = i + 1; j < length; j++) {// For swapping with minimun index
                if (inputArray[j] < inputArray[minimunIndex]) {
                    minimunIndex = j;
                }
            }
            int temp = inputArray[i];
            inputArray[i] = inputArray[minimunIndex];
            inputArray[minimunIndex] = temp;
        }
        System.out.println(Arrays.toString(inputArray));
    }

    // Initial [10, 5, 40, 8, 9, 6] Starting state.
    // Pass 1 [5, 10, 40, 8, 9, 6] Min was 5. Swapped with 10.
    // Pass 2 [5, 6, 40, 8, 9, 10] Min was 6. Swapped with 10.
    // Pass 3 [5, 6, 8, 40, 9, 10] Min was 8. Swapped with 40.
    // Pass 4 [5, 6, 8, 9, 40, 10] Min was 9. Swapped with 40.
    // Pass 5 [5, 6, 8, 9, 10, 40] Min was 10. Swapped with 40.

    // Time Complexity: Best Case (Sorted) and Worst Case (Reverse) O(n^2)
    // Space Complexity - O(1)
}
