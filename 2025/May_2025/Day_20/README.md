# 📌 Day 20: 3355. Zero Array Transformation I 🎯

**🔗 LeetCode Link:** [3355. Zero Array Transformation I](https://leetcode.com/problems/zero-array-transformation-i/description/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code> of length <code>n</code> and a 2D array <code>queries</code>, where <code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>]</code>.</p>

<p>For each <code>queries[i]</code>:</p>

<ul>
	<li>Select a <span data-keyword="subset" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-:rn:" data-state="closed" class="">subset</button></span> of indices within the range <code>[l<sub>i</sub>, r<sub>i</sub>]</code> in <code>nums</code>.</li>
	<li>Decrement the values at the selected indices by 1.</li>
</ul>

<p>A <strong>Zero Array</strong> is an array where all elements are equal to 0.</p>

<p>Return <code>true</code> if it is <em>possible</em> to transform <code>nums</code> into a <strong>Zero Array </strong>after processing all the queries sequentially, otherwise return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,0,1], queries = [[0,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><strong>For i = 0:</strong>

	<ul>
		<li>Select the subset of indices as <code>[0, 2]</code> and decrement the values at these indices by 1.</li>
		<li>The array will become <code>[0, 0, 0]</code>, which is a Zero Array.</li>
	</ul>
	</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,3,2,1], queries = [[1,3],[0,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><strong>For i = 0:</strong>

	<ul>
		<li>Select the subset of indices as <code>[1, 2, 3]</code> and decrement the values at these indices by 1.</li>
		<li>The array will become <code>[4, 2, 1, 0]</code>.</li>
	</ul>
	</li>
	<li><strong>For i = 1:</strong>
	<ul>
		<li>Select the subset of indices as <code>[0, 1, 2]</code> and decrement the values at these indices by 1.</li>
		<li>The array will become <code>[3, 1, 0, 0]</code>, which is not a Zero Array.</li>
	</ul>
	</li>
</ul>
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
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            diff[q[0]]--;
            if (q[1] + 1 < n) diff[q[1] + 1]++;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] > -sum) return false;
        }
        return true;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,0,1], queries = [[0,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">


