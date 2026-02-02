# 📌 Day 2: 3013. Divide an Array Into Subarrays With Minimum Cost II 🎯

**🔗 LeetCode Link:** [3013. Divide an Array Into Subarrays With Minimum Cost II](https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/)

---

## 🧩 Problem Description

<p>You are given a <strong>0-indexed</strong> array of integers <code>nums</code> of length <code>n</code>, and two <strong>positive</strong> integers <code>k</code> and <code>dist</code>.</p>

<p>The <strong>cost</strong> of an array is the value of its <strong>first</strong> element. For example, the cost of <code>[1,2,3]</code> is <code>1</code> while the cost of <code>[3,4,1]</code> is <code>3</code>.</p>

<p>You need to divide <code>nums</code> into <code>k</code> <strong>disjoint contiguous </strong><span data-keyword="subarray-nonempty">subarrays</span>, such that the difference between the starting index of the <strong>second</strong> subarray and the starting index of the <code>kth</code> subarray should be <strong>less than or equal to</strong> <code>dist</code>. In other words, if you divide <code>nums</code> into the subarrays <code>nums[0..(i<sub>1</sub> - 1)], nums[i<sub>1</sub>..(i<sub>2</sub> - 1)], ..., nums[i<sub>k-1</sub>..(n - 1)]</code>, then <code>i<sub>k-1</sub> - i<sub>1</sub> &lt;= dist</code>.</p>

<p>Return <em>the <strong>minimum</strong> possible sum of the cost of these</em> <em>subarrays</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Sliding Window
- Heap (Priority Queue)
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,2,6,4,2], k = 3, dist = 3
<strong>Output:</strong> 5
<strong>Explanation:</strong> The best possible way to divide nums into 3 subarrays is: [1,3], [2,6,4], and [2]. This choice is valid because i<sub>k-1</sub> - i<sub>1</sub> is 5 - 2 = 3 which is equal to dist. The total cost is nums[0] + nums[2] + nums[5] which is 1 + 2 + 2 = 5.
It can be shown that there is no possible way to divide nums into 3 subarrays at a cost lower than 5.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [10,1,2,2,2,1], k = 4, dist = 3
<strong>Output:</strong> 15
<strong>Explanation:</strong> The best possible way to divide nums into 4 subarrays is: [10], [1], [2], and [2,2,1]. This choice is valid because i<sub>k-1</sub> - i<sub>1</sub> is 3 - 1 = 2 which is less than dist. The total cost is nums[0] + nums[1] + nums[2] + nums[3] which is 10 + 1 + 2 + 2 = 15.
The division [10], [1], [2,2,2], and [1] is not valid, because the difference between i<sub>k-1</sub> and i<sub>1</sub> is 5 - 1 = 4, which is greater than dist.
It can be shown that there is no possible way to divide nums into 4 subarrays at a cost lower than 15.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [10,8,18,9], k = 3, dist = 1
<strong>Output:</strong> 36
<strong>Explanation:</strong> The best possible way to divide nums into 4 subarrays is: [10], [8], and [18,9]. This choice is valid because i<sub>k-1</sub> - i<sub>1</sub> is 2 - 1 = 1 which is equal to dist.The total cost is nums[0] + nums[1] + nums[2] which is 10 + 8 + 18 = 36.
The division [10], [8,18], and [9] is not valid, because the difference between i<sub>k-1</sub> and i<sub>1</sub> is 3 - 1 = 2, which is greater than dist.
It can be shown that there is no possible way to divide nums into 3 subarrays at a cost lower than 36.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>3 &lt;= k &lt;= n</code></li>
	<li><code>k - 2 &lt;= dist &lt;= n - 2</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        long base = nums[0];
        int kSmall = k - 1;
        if (kSmall <= 0) 
            return base;

        TreeMap<Integer, Integer> small = new TreeMap<>();
        TreeMap<Integer, Integer> big = new TreeMap<>();

        long[] sumSmall = new long[]{0};
        int[] cntSmall = new int[]{0};

        Runnable rebalance = () -> {
            while (cntSmall[0] > kSmall) {
                int x = small.lastKey();
                sumSmall[0] -= x;
                cntSmall[0]--;

                small.merge(x, -1, Integer::sum);
                if (small.get(x) == 0) 
                    small.remove(x);
                big.merge(x, 1, Integer::sum);
            }
            while (cntSmall[0] < kSmall && !big.isEmpty()) {
                int x = big.firstKey();
                sumSmall[0] += x;
                cntSmall[0]++;
                big.merge(x, -1, Integer::sum);
                if (big.get(x) == 0) 
                    big.remove(x);
                small.merge(x, 1, Integer::sum);
            }
        };

        int windowSize = dist + 1;
        for (int i = 1; i <= windowSize && i < nums.length; i++) {
            small.merge(nums[i], 1, Integer::sum);
            sumSmall[0] += nums[i];
            cntSmall[0]++;
        }
        rebalance.run();

        long res = base + sumSmall[0];

        for (int l = 1, r = windowSize + 1; r < nums.length; l++, r++) {
            int out = nums[l];
            if (small.containsKey(out)) {
                sumSmall[0] -= out;
                cntSmall[0]--;
                small.merge(out, -1, Integer::sum);
                if (small.get(out) == 0) 
                    small.remove(out);
            } else {
                big.merge(out, -1, Integer::sum);
                if (big.get(out) == 0) 
                    big.remove(out);
            }

            int in = nums[r];
            if (small.isEmpty() || in <= small.lastKey()) {
                small.merge(in, 1, Integer::sum);
                sumSmall[0] += in;
                cntSmall[0]++;
            } else {
                big.merge(in, 1, Integer::sum);
            }

            rebalance.run();
            res = Math.min(res, base + sumSmall[0]);
        }

        return res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,2,6,4,2], k = 3, dist = 3
<strong>Output:</strong> 5
<strong>Explanation:</strong> The best possible way to divide nums into 3 subarrays is: [1,3], [2,6,4], and [2]. This choice is valid because i<sub>k-1</sub> - i<sub>1</sub> is 5 - 2 = 3 which is equal to dist. The total cost is nums[0] + nums[2] + nums[5] which is 1 + 2 + 2 = 5.
It can be shown that there is no possible way to divide nums into 3 subarrays at a cost lower than 5.
</pre>

<p><strong class="example">


