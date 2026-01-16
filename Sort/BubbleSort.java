import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] inputArray = { 10, 5, 40, 8, 9, 6 };
        int length = inputArray.length;
        boolean swapped = false;

        for (int i = 0; i < length - 1; i++) {// iterations
            for (int j = 0; j < length - 1 - i; j++) {// For swapping consecutive numbers
                                                      // and at the End of each iteration, last element will be sorted
                if (inputArray[j] > inputArray[j + 1]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                System.out.println("Given input is Sorted Array: " + Arrays.toString(inputArray));
                break;
            }
        }
        System.out.println(Arrays.toString(inputArray));
    }

    // Initial [10, 5, 40, 8, 9, 6] Starting state.
    // Pass 1 [5, 10, 8, 9, 6, 40] 40 bubbled to the end.
    // Pass 2 [5, 8, 9, 6, 10, 40] 10 bubbled to the second-to-last spot.
    // Pass 3 [5, 8, 6, 9, 10, 40] 9 bubbled to its spot.
    // Pass 4 [5, 6, 8, 9, 10, 40] 8 bubbled to its spot.
    // Pass 5 [5, 6, 8, 9, 10, 40] Sorted. (Algorithm checks one last time).

    // Time Complexity:
    // Best Case (Sorted) O(n) (with flag)
    // Worst Case (Reverse) $O(n^2)
    // Space Complexity - O(1)
}
