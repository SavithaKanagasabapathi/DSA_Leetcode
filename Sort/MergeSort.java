import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] inputArray = { 10, 5, 40, 8, 9, 6 };
        int length = inputArray.length;

        mergeDivide(inputArray, 0, length - 1);

        System.out.println(Arrays.toString(inputArray));
    }

    public static void mergeDivide(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;

            // If i/p is large, start+end gives big number gives int overflow
            // as int has max value of 2,147,483,647.
            // int midIndex = startIndex + (endIndex-startIndex)/2;

            mergeDivide(array, startIndex, midIndex);
            mergeDivide(array, midIndex + 1, endIndex);

            mergeConquer(array, startIndex, midIndex, endIndex);
        }
    }

    public static void mergeConquer(int[] array, int startIndex, int midIndex, int endIndex) {// Merge 2 sorted arrays
        int[] leftArray = Arrays.copyOfRange(array, startIndex, midIndex + 1);
        int[] rightArray = Arrays.copyOfRange(array, midIndex + 1, endIndex + 1);

        int i = 0, j = 0, k = startIndex;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) { // For leftover leftarray elements
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {// For leftover rightarray elements
            array[k++] = rightArray[j++];
        }
    }
    // Start: [10, 5, 40, 8, 9, 6]
    // Split 1: [10, 5, 40] and [8, 9, 6]
    // Split 2: [10] , [5, 40] | [8] , [9, 6]
    // Split 3: [10] , [5] , [40] | [8] , [9] , [6]

    // Final Merge: Compare [5, 10, 40] and [6, 8, 9]
    // Final Result: [5, 6, 8, 9, 10, 40]

    // Time Complexity:
    // Best Case (Sorted) or Worst Case (Reverse) O(nlogn) as divide and conquer,
    // it's dividing so only log n operations, conquering n times
    // Total Work = (Number of Levels log n) x (Work per Level n) = nlogn
    // Space Complexity - O(n)
}
