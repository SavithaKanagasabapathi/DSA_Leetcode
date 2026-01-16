# Sorting Algorithms — Comparison & Key Insights

## Comparison Table

| Algorithm         | Best Time            | Average Time          | Worst Time            | Space Complexity | Stable? |
|------------------|----------------------|------------------------|------------------------|------------------|---------|
| **Bubble Sort**      | O(n)                  | O(n²)                   | O(n²)                   | O(1)             | Yes     |
| **Selection Sort**   | O(n²)                 | O(n²)                   | O(n²)                   | O(1)             | No      |
| **Insertion Sort**   | O(n)                  | O(n²)                   | O(n²)                   | O(1)             | Yes     |
| **Merge Sort**       | O(n log n)            | O(n log n)              | O(n log n)              | O(n)             | Yes     |
| **Quick Sort**       | O(n log n)            | O(n log n)              | O(n²)                   | O(log n)         | No      |
| **Counting Sort**    | O(n + k)              | O(n + k)                | O(n + k)                | O(k)             | Yes     |
| **Radix Sort**       | O(d(n + k))           | O(d(n + k))             | O(d(n + k))             | O(n + k)         | Yes     |

---

## Key Insights

### 1. **The Simple Sorts**  
**(Bubble, Selection, Insertion)**  
- All are **in‑place** algorithms with **O(1)** extra memory.  
- **Insertion Sort** is extremely efficient for:  
  - Nearly sorted arrays  
  - Very small arrays (≈15 elements or fewer)

---

### 2. **Efficient Comparison Sorts**  
**(Merge Sort, Quick Sort)**  
- **Merge Sort**  
  - Predictable performance  
  - Requires extra memory (O(n))  
  - Stable  

- **Quick Sort**  
  - Usually fastest in practice due to cache locality  
  - Worst‑case O(n²) if pivot choice is poor  
  - Not stable  

---

### 3. **Non‑Comparison Sorts**  
**(Counting Sort, Radix Sort)**  
- **Counting Sort**  
  - Can achieve true O(n) performance  
  - Only practical when the value range (k) is small  

- **Radix Sort**  
  - Excellent for large integers  
  - Avoids the O(n log n) comparison limit by processing digits  

---

## Which Algorithm Should You Choose?

- **If memory is tight:** Quick Sort  
- **If you need guaranteed performance:** Merge Sort  
- **If sorting small integers (ages, scores):** Counting Sort  
- **If the data is almost sorted:** Insertion Sort  

## Other Important Sorting Algorithms

| Sort Name              | Used In                     | Strategy                     | Best Case      | Average Case      | Worst Case        | Space Complexity |
|------------------------|-----------------------------|------------------------------|----------------|--------------------|--------------------|------------------|
| **Timsort**            | `Collections.sort()` (Java Objects) | Merge Sort + Insertion Sort | O(n)           | O(n log n)        | O(n log n)        | O(n)             |
| **Dual-Pivot Quick Sort** | `Arrays.sort(int[])` (Java Primitives) | Quick Sort with 2 pivots     | O(n log n)     | O(n log n)        | O(n²)             | O(log n)         |
| **Heap Sort**          | Some libraries, fallback in IntroSort | Binary Heap (Max-Heap)       | O(n log n)     | O(n log n)        | O(n log n)        | O(1)             |
| **Tree Sort**          | Conceptual / BST-based sorting | Insert into BST + Inorder traversal | O(n log n) | O(n log n)        | O(n²) (unbalanced) | O(n)             |
