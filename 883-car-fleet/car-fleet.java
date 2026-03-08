class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //TC-O(nlogn) and SC-O(n), nlogn for sort
        //determine how many groups of cars will arrive at a target destination together.
        //a car cannot pass the car in front of it. If a faster car catches up to a slower one, 
        //they merge into a "fleet" and move at the slower car's speed
        int n = position.length;
        if (n <= 1) {
            return n;
        }
        double[][] posAndTime = new double[n][2];//2 cols-position and time to reach target
        for (int i = 0; i < n; i++) {
            posAndTime[i][0] = position[i];
            posAndTime[i][1] = (double) (target - position[i]) / speed[i];//time=distance/speed
            //dis/speed will be in decimal, if we convert to int, 2.1 and 2.9 will be same 2
        }
        Arrays.sort(posAndTime, (a, b) -> Double.compare(b[0], a[0]));//sort by position and not time
        //descending order (close to far from target)
        double maxTime = 0;
        int fleets = 0;
        for (int i = 0; i < n; i++) {
            if (posAndTime[i][1] > maxTime) {
                fleets++;
                maxTime = posAndTime[i][1];
            }
        }
        return fleets;
    }
    //Target: 12, Positions: [10, 8, 0, 5, 3], Speeds: [2, 4, 1, 1, 3]
    //Sorted: (10, 1.0), (8, 1.0), (5, 7.0), (3, 3.0), (0, 12.0)
    //min time first, if less than that it will reach gradually and fleet
    //1, 1, 7, 3, 12 - 1, 7, 12 - 3 fleets
    //if time<=maxtime-same fleet
}