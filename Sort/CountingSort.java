import java.util.Arrays;

public class CountingSort {// Non-Comparison Sort

    public static void main(String[] args) {
        int[] inputArray = { 10, 5, 40, 8, 9, 6 };
        int length = inputArray.length;
        int max = Arrays.stream(inputArray).max().getAsInt();
        int[] countArray = new int[max + 1];// Including 0
        for (int input : inputArray)// Store count of occurrences
            countArray[input]++;
        for (int i = 1; i <= max; i++) {// Cumulative
            countArray[i] += countArray[i - 1];
        }
        int[] outputArray = new int[length];
        for (int i = length - 1; i >= 0; i--) {// Iterating backwards maintains stability
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }
        System.out.println(Arrays.toString(outputArray));
    }

    // Initial - [10, 5, 40, 8, 9, 6], max - 40
    // Create a countArray of size 41 (indices 0 to 40)
    // countArray[0,..,1,1,0,1,1,1,0,..,1]
    // countArray[0,..,1,2,2,3,4,5,5,..,6]
    // outputArray[5, 6, 8, 9, 10, 40]

    // Why Cumulation
    // Counts: There are 2 First-graders, 1 Second-grader, and 3 Third-graders.
    // Cumulative Sum:The First-graders take spots 1 and 2.
    // The Second-grader must start after the First-graders.
    // So, $2 (\text{previous}) + 1 = 3$. The Second-grader takes spot 3.

    // If two elements are the same, their relative order should be preserved,
    // so iterate backwards to maintain stability
    // inputArray element - that index in countArray -1 is the position in output.

    // we subtract 1 because of the difference between Position and Index.

    // Time: O(n + k) where n=6 (elements) and k=40 (range).
    // Space: O(n + k) because we need the outputArray and the large countArray.
    // Notice the inefficiency here:
    // We had to create a helper array of size 41 just to sort 6 numbers.
    // This is why Counting Sort is only used when k (the max value),
    // is not much larger than n.
}
