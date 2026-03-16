import java.util.*;

public class WallsAndGates {
    // TC-O(M.N) and SC-O(M.N)
    // First in queue add all gates
    // fill all four cells near gates to gates+1=0+1=1
    // add filled +1 to queue, this will fill 1+1=2
    // same way fill all cells

    private static final int INF = 2147483647;

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        int rows = rooms.length, cols = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0) {
                    queue.offer(new int[] { row, col });
                }
            }
        }
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1];
            for (int[] dir : directions) {
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                        && rooms[nextRow][nextCol] == INF) {
                    rooms[nextRow][nextCol] = rooms[row][col] + 1;
                    queue.offer(new int[] { nextRow, nextCol });
                }
            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();

        // Sample Input: INF is an empty room, -1 is a wall, 0 is a gate
        int[][] grid = {
                { INF, -1, 0, INF },
                { INF, INF, INF, -1 },
                { INF, -1, INF, -1 },
                { 0, -1, INF, INF }
        };

        System.out.println("Input Grid:");
        printGrid(grid);

        solution.wallsAndGates(grid);

        System.out.println("\nOutput Grid (Distances to nearest gate):");
        printGrid(grid);
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}