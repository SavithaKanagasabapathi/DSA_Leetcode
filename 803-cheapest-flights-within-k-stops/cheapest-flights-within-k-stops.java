class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Bellman ford
        //TC-O(K.F) and SC-O(N), F is flights
        // int[] prices = new int[n];//price to reach each stop
        // Arrays.fill(prices, Integer.MAX_VALUE);
        // prices[src] = 0;//to reach src=0
        // for (int i = 0; i <= k; i++) {//first iteration fill prices for 0 stops, so loop upto k stops
        //     int[] tempPrices = Arrays.copyOf(prices, n);
        //     for (int[] flight : flights) {
        //         int u = flight[0], v = flight[1], cost = flight[2];
        //         if (prices[u] == Integer.MAX_VALUE) {//here prices and not tempPrices
        //             continue;
        //         }
        //         if (prices[u] + cost < tempPrices[v]) {//only this block tempPrices
        //             tempPrices[v] = prices[u] + cost;
        //         }
        //     }
        //     prices = tempPrices;
        // }
        // return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

        //Modified Dijkstra 
        //TC-O() and SC-O(N), F is flights
        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        for (int[] flight : flights) {
            adjMap.computeIfAbsent(flight[0], key -> new ArrayList<>())
                    .add(new int[] { flight[1], flight[2] });
        }
        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);//cheapest cost
        pq.offer(new int[] { 0, src, 0 });//cost, destination, stops to reach destination
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0], dest = current[1], stops = current[2];
            if (dest == dst) {
                return cost;//this will be the cheapest as pq
            }
            if (stops > k || stops >= minStops[dest]) {
                continue;
            }
            minStops[dest] = stops;
            if (adjMap.containsKey(dest)) {
                for (int[] neighbour : adjMap.get(dest)) {
                    pq.offer(new int[] { cost + neighbour[1], neighbour[0], stops + 1 });
                }
            }
        }
        return -1;
    }
}