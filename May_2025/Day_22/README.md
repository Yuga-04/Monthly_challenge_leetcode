# 📌 Day 24: 3362. Zero Array Transformation III 🎯

**🔗 LeetCode Link:** [3362. Zero Array Transformation III](https://leetcode.com/problems/zero-array-transformation-iii/description)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code> of length <code>n</code> and a 2D array <code>queries</code> where <code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>]</code>.</p>

<p>Each <code>queries[i]</code> represents the following action on <code>nums</code>:</p>

<ul>
	<li>Decrement the value at each index in the range <code>[l<sub>i</sub>, r<sub>i</sub>]</code> in <code>nums</code> by <strong>at most</strong><strong> </strong>1.</li>
	<li>The amount by which the value is decremented can be chosen <strong>independently</strong> for each index.</li>
</ul>

<p>A <strong>Zero Array</strong> is an array with all its elements equal to 0.</p>

<p>Return the <strong>maximum </strong>number of elements that can be removed from <code>queries</code>, such that <code>nums</code> can still be converted to a <strong>zero array</strong> using the <em>remaining</em> queries. If it is not possible to convert <code>nums</code> to a <strong>zero array</strong>, return -1.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Greedy
- Sorting
- Heap (Priority Queue)
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>After removing <code>queries[2]</code>, <code>nums</code> can still be converted to a zero array.</p>

<ul>
	<li>Using <code>queries[0]</code>, decrement <code>nums[0]</code> and <code>nums[2]</code> by 1 and <code>nums[1]</code> by 0.</li>
	<li>Using <code>queries[1]</code>, decrement <code>nums[0]</code> and <code>nums[2]</code> by 1 and <code>nums[1]</code> by 0.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>We can remove <code>queries[2]</code> and <code>queries[3]</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4], queries = [[0,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p><code>nums</code> cannot be converted to a zero array even after using all the queries.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>0 &lt;= l<sub>i</sub> &lt;= r<sub>i</sub> &lt; nums.length</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        List<List<Integer>> qEnd = new ArrayList<>();
        for (int i = 0; i < n; i++) qEnd.add(new ArrayList<>());
        for (int[] query : queries) {
            qEnd.get(query[0]).add(query[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] cntQ = new int[n + 1];
        int dec = 0;

        for (int i = 0; i < n; i++) {
            dec += cntQ[i];
            for (int end : qEnd.get(i)) {
                pq.offer(end);
            }

            int x = nums[i];
            while (x > dec && !pq.isEmpty() && pq.peek() >= i) {
                int k = pq.poll();
                cntQ[k + 1]--;
                dec++;
            }

            if (x > dec) return -1;
        }

        return pq.size();
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>


<p><strong class="example">


