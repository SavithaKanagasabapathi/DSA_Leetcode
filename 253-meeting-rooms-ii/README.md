# Meeting Rooms II (LeetCode #253) Difficulty Medium

## Problem Description
Given an array of meeting time intervals consisting of start and end times `[[s1,e1],[s2,e2],...]` where ($s_i < e_i$), find the minimum number of conference rooms required.

### Examples
**Example 1:**
* **Input:** `[[0, 30], [5, 10], [15, 20]]`
* **Output:** `2`
* **Explanation:** 1. Meeting 1 (0-30) starts. Room 1 is occupied.
  2. Meeting 2 (5-10) starts. Room 1 is still busy, so Room 2 is opened.
  3. Meeting 2 ends at 10. Room 2 is now free.
  4. Meeting 3 (15-20) starts. Room 2 is reused.
  5. Total rooms: 2.

**Example 2:**
* **Input:** `[[7, 10], [2, 4]]`
* **Output:** `1`

---

## Strategy: Min-Heap (Dynamic Resource Allocation)
To solve this efficiently, we process meetings in chronological order and use a **Min-Heap** to track when rooms become available.

### Steps:
1. **Sort** the meetings by their **start times**.
2. **Initialize** a Min-Heap to store the **end times** of active meetings.
3. **Iterate** through each meeting:
    * Compare the current meeting's start time with the earliest end time in the heap (`minHeap.peek()`).
    * **If `current.start >= minHeap.peek()`**: A room has finished its meeting. We `poll()` the old end time (reuse the room).
    * **If `current.start < minHeap.peek()`**: All rooms are occupied. We don't poll (a new room is opened).
    * **Always `offer()`** the current meeting's end time to the heap.
4. The final **size of the heap** represents the total rooms required.



---
