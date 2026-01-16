import java.util.Arrays;

public class RadixSort {// Non-Comparison Sort

    public static void main(String[] args) {
        int[] inputArray = { 10, 5, 40, 8, 9, 6 };
        int max = Arrays.stream(inputArray).max().getAsInt();
        for (int exponential = 1; max / exponential > 0; exponential *= 10) {
            radixSort(inputArray, exponential);// exp-1,10,100
        }
        System.out.println(Arrays.toString(inputArray));
    }

    public static void radixSort(int[] inputArray, int exponential) {
        int length = inputArray.length;
        int[] countArray = new int[10];// 0-9
        for (int input : inputArray)// Store count of occurrences
            countArray[(input / exponential) % 10]++;
        for (int i = 1; i <= 9; i++) {// Cumulative
            countArray[i] += countArray[i - 1];
        }
        int[] outputArray = new int[length];
        for (int i = length - 1; i >= 0; i--) {// Iterating backwards maintains stability
            int digit = (inputArray[i] / exponential) % 10;
            outputArray[countArray[digit] - 1] = inputArray[i];
            countArray[digit]--;
        }
        System.arraycopy(outputArray, 0, inputArray, 0, length);// Copy OutputArray to InputArray
    }

    // Initial - [10, 5, 40, 8, 9, 6], max - 40
    // Create a countArray of size 10 (indices 0 to 9)

    // Ones [0,5,0,8,9,6]
    // countArray-[2,0,0,0,0,1,1,0,1,1]
    // countArray[2,2,2,2,2,3,4,4,5,6]
    // outputArray[0,0,5,6,8,9] - [10,40,5,6,8,9]

    // Tens [1,4,0,0,0,0]
    // countArray-[4,1,0,0,1,0,0,0,0,0]
    // countArray[4,5,5,5,6,6,6,6,6,6]
    // outputArray[0,0,0,0,1,4] - [5,6,8,9,10,40]

    // 123/1 = 123%10 = 3
    // 123/10 = 12%10 = 2

    // Why Cumulation
    // Counts: There are 2 First-graders, 1 Second-grader, and 3 Third-graders.
    // Cumulative Sum:The First-graders take spots 1 and 2.
    // The Second-grader must start after the First-graders.
    // So, $2 (\text{previous}) + 1 = 3$. The Second-grader takes spot 3.

    // If two elements are the same, their relative order should be preserved,
    // so iterate backwards to maintain stability
    // inputArray element - that index in countArray -1 is the position in output.

    // we subtract 1 because of the difference between Position and Index.

    // Arrays.copyOf - Creates a new array and returns it. Slower (more Garbage
    // Collection).
    // System.arraycopy Copies data into an existing array. Fastest (low-level
    // memory copy).

    // Time: O(d(n + k)) where d=max digits n=6 (elements) and k=40 (range).
    // Space: O(n + k) because we need the outputArray and the large countArray.
    // In CountingSort, we need to create max num array but here only array of 10
}
