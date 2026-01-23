# 📌 Day 23: 3510. Minimum Pair Removal to Sort Array II 🎯

**🔗 LeetCode Link:** [3510. Minimum Pair Removal to Sort Array II](https://leetcode.com/problems/minimum-pair-removal-to-sort-array-ii/)

---

## 🧩 Problem Description

<p>Given an array <code>nums</code>, you can perform the following operation any number of times:</p>

<ul>
	<li>Select the <strong>adjacent</strong> pair with the <strong>minimum</strong> sum in <code>nums</code>. If multiple such pairs exist, choose the leftmost one.</li>
	<li>Replace the pair with their sum.</li>
</ul>

<p>Return the <strong>minimum number of operations</strong> needed to make the array <strong>non-decreasing</strong>.</p>

<p>An array is said to be <strong>non-decreasing</strong> if each element is greater than or equal to its previous element (if it exists).</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Linked List
- Heap (Priority Queue)
- Simulation
- Doubly-Linked List
- Ordered Set
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [5,2,3,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The pair <code>(3,1)</code> has the minimum sum of 4. After replacement, <code>nums = [5,2,4]</code>.</li>
	<li>The pair <code>(2,4)</code> has the minimum sum of 6. After replacement, <code>nums = [5,6]</code>.</li>
</ul>

<p>The array <code>nums</code> became non-decreasing in two operations.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>The array <code>nums</code> is already sorted.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    static class Node {
        long sum;
        int i;
        Node(long sum, int i) { this.sum = sum; this.i = i; }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) 
            return 0;

        long[] a = new long[n];
        for (int i = 0; i < n; i++) 
            a[i] = nums[i];

        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = (i + 1 < n) ? i + 1 : -1;
        }

        PriorityQueue<Node> heap = new PriorityQueue<>((p, q) -> {
            if (p.sum != q.sum) 
                return Long.compare(p.sum, q.sum);
            return Integer.compare(p.i, q.i);
        });

        for (int i = 0; i < n - 1; i++) 
            heap.add(new Node(a[i] + a[i + 1], i));

        int rest = 0;
        for (int i = 0; i < n - 1; i++) 
            if (a[i] > a[i + 1]) 
                rest++;

        int ans = 0;

        while (rest > 0) {
            Node cur = heap.poll();
            long v = cur.sum;
            int i = cur.i;

            int r = right[i];
            if (r == -1) 
                continue;
            if (left[r] != i) 
                continue;
            if (a[i] + a[r] != v) 
                continue; 

            int li = left[i];
            int rr = right[r];

            if (li != -1 && right[li] == i && a[li] > a[i]) 
                rest--;
            if (a[i] > a[r]) 
                rest--;
            if (rr != -1 && left[rr] == r && a[r] > a[rr]) 
                rest--;

            a[i] = v;

            right[i] = rr;
            if (rr != -1) 
                left[rr] = i;
            left[r] = -1;
            right[r] = -1;

            if (li != -1 && right[li] == i && a[li] > a[i]) 
                rest++;
            if (rr != -1 && left[rr] == i && a[i] > a[rr]) 
                rest++;

            if (li != -1 && right[li] == i) 
                heap.add(new Node(a[li] + a[i], li));
            if (rr != -1 && left[rr] == i) 
                heap.add(new Node(a[i] + a[rr], i));

            ans++;
        }

        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [5,2,3,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The pair <code>(3,1)</code> has the minimum sum of 4. After replacement, <code>nums = [5,2,4]</code>.</li>
	<li>The pair <code>(2,4)</code> has the minimum sum of 6. After replacement, <code>nums = [5,6]</code>.</li>
</ul>

<p>The array <code>nums</code> became non-decreasing in two operations.</p>
</div>

<p><strong class="example">


