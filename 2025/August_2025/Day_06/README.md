# 📌 Day 6: 3479. Fruits Into Baskets III 🎯

**🔗 LeetCode Link:** [3479. Fruits Into Baskets III](https://leetcode.com/problems/fruits-into-baskets-iii/)

---

## 🧩 Problem Description

<p>You are given two arrays of integers, <code>fruits</code> and <code>baskets</code>, each of length <code>n</code>, where <code>fruits[i]</code> represents the <strong>quantity</strong> of the <code>i<sup>th</sup></code> type of fruit, and <code>baskets[j]</code> represents the <strong>capacity</strong> of the <code>j<sup>th</sup></code> basket.</p>

<p>From left to right, place the fruits according to these rules:</p>

<ul>
	<li>Each fruit type must be placed in the <strong>leftmost available basket</strong> with a capacity <strong>greater than or equal</strong> to the quantity of that fruit type.</li>
	<li>Each basket can hold <b>only one</b> type of fruit.</li>
	<li>If a fruit type <b>cannot be placed</b> in any basket, it remains <b>unplaced</b>.</li>
</ul>

<p>Return the number of fruit types that remain unplaced after all possible allocations are made.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Binary Search
- Segment Tree
- Ordered Set
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">fruits = [4,2,5], baskets = [3,5,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><code>fruits[0] = 4</code> is placed in <code>baskets[1] = 5</code>.</li>
	<li><code>fruits[1] = 2</code> is placed in <code>baskets[0] = 3</code>.</li>
	<li><code>fruits[2] = 5</code> cannot be placed in <code>baskets[2] = 4</code>.</li>
</ul>

<p>Since one fruit type remains unplaced, we return 1.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">fruits = [3,6,1], baskets = [6,4,7]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><code>fruits[0] = 3</code> is placed in <code>baskets[0] = 6</code>.</li>
	<li><code>fruits[1] = 6</code> cannot be placed in <code>baskets[1] = 4</code> (insufficient capacity) but can be placed in the next available basket, <code>baskets[2] = 7</code>.</li>
	<li><code>fruits[2] = 1</code> is placed in <code>baskets[1] = 4</code>.</li>
</ul>

<p>Since all fruits are successfully placed, we return 0.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == fruits.length == baskets.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= fruits[i], baskets[i] &lt;= 10<sup>9</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int N = 1;
        while(N <= n) N <<= 1;
        // Build the segment tree
        int[] segTree = new int[N << 1];
        for (int i = 0; i < n; i++)
        segTree[N + i] = baskets[i];
        for (int i = N - 1; i > 0; i--) 
        segTree[i] = Math.max(segTree[2 * i], segTree[2 * i + 1]);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int x = fruits[i];
            int index = 1; // Start from the root of the segment tree
            if (segTree[index] < x) {
                count++;
                continue;
            }
            // Query the first valid basket
            while (index < N) {
                if (segTree[index * 2] >= x) 
                index *= 2;
                else
                index = index * 2 + 1;
            }
            // Mark the found basket as used and update the segment tree
            segTree[index] = -1;
            while (index > 1) {
                index >>= 1;
                segTree[index] = Math.max(segTree[2 * index], segTree[2 * index + 1]);
            }
        }
        return count;     
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">fruits = [4,2,5], baskets = [3,5,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

</div>

<p><strong class="example">


