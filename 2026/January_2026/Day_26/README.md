# 📌 Day 26: 1200. Minimum Absolute Difference 🎯

**🔗 LeetCode Link:** [1200. Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/)

---

## 🧩 Problem Description

<p>Given an array of <strong>distinct</strong> integers <code>arr</code>, find all pairs of elements with the minimum absolute difference of any two elements.</p>

<p>Return a list of pairs in ascending order(with respect to pairs), each pair <code>[a, b]</code> follows</p>

<ul>
	<li><code>a, b</code> are from <code>arr</code></li>
	<li><code>a &lt; b</code></li>
	<li><code>b - a</code> equals to the minimum absolute difference of any two elements in <code>arr</code></li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Sorting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [4,2,1,3]
<strong>Output:</strong> [[1,2],[2,3],[3,4]]
<strong>Explanation: </strong>The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,3,6,10,15]
<strong>Output:</strong> [[1,3]]
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [3,8,-10,23,19,-4,-14,27]
<strong>Output:</strong> [[-14,-10],[19,23],[23,27]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>6</sup> &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = arr[n-1] - arr[n-2];
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i-1] == minDiff) {
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [4,2,1,3]
<strong>Output:</strong> [[1,2],[2,3],[3,4]]
<strong>Explanation: </strong>The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.</pre>

<p><strong class="example">


