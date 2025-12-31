# 📌 Day 26: 3480. Maximize Subarrays After Removing One Conflicting Pair 🎯

**🔗 LeetCode Link:** [3480. Maximize Subarrays After Removing One Conflicting Pair](https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/)

---

## 🧩 Problem Description

<p>You are given an integer <code>n</code> which represents an array <code>nums</code> containing the numbers from 1 to <code>n</code> in order. Additionally, you are given a 2D array <code>conflictingPairs</code>, where <code>conflictingPairs[i] = [a, b]</code> indicates that <code>a</code> and <code>b</code> form a conflicting pair.</p>

<p>Remove <strong>exactly</strong> one element from <code>conflictingPairs</code>. Afterward, count the number of <span data-keyword="subarray-nonempty">non-empty subarrays</span> of <code>nums</code> which do not contain both <code>a</code> and <code>b</code> for any remaining conflicting pair <code>[a, b]</code>.</p>

<p>Return the <strong>maximum</strong> number of subarrays possible after removing <strong>exactly</strong> one conflicting pair.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Segment Tree
- Enumeration
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 4, conflictingPairs = [[2,3],[1,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">9</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Remove <code>[2, 3]</code> from <code>conflictingPairs</code>. Now, <code>conflictingPairs = [[1, 4]]</code>.</li>
	<li>There are 9 subarrays in <code>nums</code> where <code>[1, 4]</code> do not appear together. They are <code>[1]</code>, <code>[2]</code>, <code>[3]</code>, <code>[4]</code>, <code>[1, 2]</code>, <code>[2, 3]</code>, <code>[3, 4]</code>, <code>[1, 2, 3]</code> and <code>[2, 3, 4]</code>.</li>
	<li>The maximum number of subarrays we can achieve after removing one element from <code>conflictingPairs</code> is 9.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5, conflictingPairs = [[1,2],[2,5],[3,5]]</span></p>

<p><strong>Output:</strong> <span class="example-io">12</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Remove <code>[1, 2]</code> from <code>conflictingPairs</code>. Now, <code>conflictingPairs = [[2, 5], [3, 5]]</code>.</li>
	<li>There are 12 subarrays in <code>nums</code> where <code>[2, 5]</code> and <code>[3, 5]</code> do not appear together.</li>
	<li>The maximum number of subarrays we can achieve after removing one element from <code>conflictingPairs</code> is 12.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= conflictingPairs.length &lt;= 2 * n</code></li>
	<li><code>conflictingPairs[i].length == 2</code></li>
	<li><code>1 &lt;= conflictingPairs[i][j] &lt;= n</code></li>
	<li><code>conflictingPairs[i][0] != conflictingPairs[i][1]</code></li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] right = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            right[i] = new ArrayList<>();
        }
        for (int[] pair : conflictingPairs) {
            right[Math.max(pair[0], pair[1])].add(Math.min(pair[0], pair[1]));
        }

        long ans = 0;
        long[] left = {0, 0}; // left[0] is top1, left[1] is top2
        long[] bonus = new long[n + 1];

        for (int r = 1; r <= n; r++) {
            for (int l_val : right[r]) {
                // Manually update top two values
                if (l_val > left[0]) {
                    left[1] = left[0];
                    left[0] = l_val;
                } else if (l_val > left[1]) {
                    left[1] = l_val;
                }
            }

            ans += r - left[0];
            
            if (left[0] > 0) {
                bonus[(int)left[0]] += left[0] - left[1];
            }
        }
        
        long maxBonus = 0;
        for (long b : bonus) {
            maxBonus = Math.max(maxBonus, b);
        }

        return ans + maxBonus;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 4, conflictingPairs = [[2,3],[1,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">9</span></p>

</div>

<p><strong class="example">


