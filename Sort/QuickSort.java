import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] inputArray = { 10, 5, 40, 8, 9, 6 };
        int length = inputArray.length;

        quickPartition(inputArray, 0, length - 1);

        System.out.println(Arrays.toString(inputArray));
    }

    public static void quickPartition(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = quickPivotIndex(array, startIndex, endIndex);

            quickPartition(array, startIndex, pivotIndex - 1);
            quickPartition(array, pivotIndex + 1, endIndex);
        }
    }

    public static int quickPivotIndex(int[] array, int startIndex, int endIndex) {
        int pivotElement = array[endIndex];// Let pivot be last element
        int smallIndex = startIndex - 1;
        for (int i = startIndex; i < endIndex; i++) {// Upto pivot-1
            if (array[i] < pivotElement) {
                smallIndex++;
                int temp = array[i];
                array[i] = array[smallIndex];
                array[smallIndex] = temp;
            }
        }
        int temp = array[smallIndex + 1];
        array[smallIndex + 1] = array[endIndex];
        array[endIndex] = temp;

        return smallIndex + 1;
    }
    // Input: [10, 5, 40, 8, 9, 6] | Pivot = 6(last element) | smallIndex = -1
    // Iteration 1 (i=0, arr[i]=10): 10 is NOT smaller than 6.
    // Do nothing. (smallIndex stays -1).
    // Iteration 2 (i=1, arr[i]=5): 5 IS smaller than 6.
    // Increment smallIndex to 0.
    // Swap arr[0] (10) and arr[1] (5).
    // Array is now: [5, 10, 40, 8, 9, 6].
    // See? The 5 moved to the "Small Zone" at the front!
    // Iteration 3, 4, 5: 40, 8, and 9 are all larger than 6. Do nothing.
    // Final Step (Outside the loop):
    // Swap the Pivot (6) with the element at smallIndex + 1 (which is 10).
    // Array becomes: [5, 6, 40, 8, 9, 10].

    // Final Result: [5, 6, 8, 9, 10, 40]

    // Time Complexity:
    // Best Case O(nlogn)
    // Worst Case O(n^2) - if the array is already sorted and you always pick the
    // last element as the pivot
    // Space Complexity: O(log n) due to the recursion stack

    // Pivot Choice: In real-world Java (like Arrays.sort()), they use a Dual-Pivot
    // or pick a random pivot to avoid the O(n^2) worst case.
}
