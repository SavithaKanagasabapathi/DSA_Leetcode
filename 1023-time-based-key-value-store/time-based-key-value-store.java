class TimeMap {

    //SC-O(N)
    //Map<String, List<Pair>> map;//Binary Search
    Map<String, TreeMap<Integer, String>> map;//TreeMap

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        //TC-O(1)
        //map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));//add

        //TC-O(logn)//TreeMap keys sorted
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);//put
    }

    //considering timestamp will be increasing everytime, so will be sorted
    //TC-O(logn)
    //Can use Collections.binarySearch
    // public String get(String key, int timestamp) {
    //     if (!map.containsKey(key)) {
    //         return "";
    //     }
    //     List<Pair> pairs = map.get(key);
    //     int left = 0, right = pairs.size() - 1;
    //     String result = "";
    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;
    //         if (mid <= timestamp) {
    //             result = pairs.get(mid).value;
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //     }
    //     return result;
    // }

    //TC-O(logn)
    //TreeMap-keys sorted
    //Map.Entry will get that particular entry from Map
    //floorEntry-which key is <= timestamp, return that entry
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }

    private class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    //[foo, bar, 1], [foo, bar1, 5], [foo, bar2, 10]
    //get(foo, 4), get time which is <= i/p time
    //bar (1 is less than 4)
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */