# 📌 Day 11: 3721. Longest Balanced Subarray II 🎯

**🔗 LeetCode Link:** [3721. Longest Balanced Subarray II](https://leetcode.com/problems/longest-balanced-subarray-ii/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code>.</p>

<p>A <strong><span data-keyword="subarray-nonempty">subarray</span></strong> is called <strong>balanced</strong> if the number of <strong>distinct even</strong> numbers in the subarray is equal to the number of <strong>distinct odd</strong> numbers.</p>

<p>Return the length of the <strong>longest</strong> balanced subarray.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Divide and Conquer
- Segment Tree
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,5,4,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The longest balanced subarray is <code>[2, 5, 4, 3]</code>.</li>
	<li>It has 2 distinct even numbers <code>[2, 4]</code> and 2 distinct odd numbers <code>[5, 3]</code>. Thus, the answer is 4.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,2,2,5,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The longest balanced subarray is <code>[3, 2, 2, 5, 4]</code>.</li>
	<li>It has 2 distinct even numbers <code>[2, 4]</code> and 2 distinct odd numbers <code>[3, 5]</code>. Thus, the answer is 5.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The longest balanced subarray is <code>[2, 3, 2]</code>.</li>
	<li>It has 1 distinct even number <code>[2]</code> and 1 distinct odd number <code>[3]</code>. Thus, the answer is 3.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    static class Node {
        int mn, mx, lz;
    }
    int n;
    Node[] seg;

    void push(int node) {
        int val = seg[node].lz;
        if (val == 0) 
            return;
        int lc = node << 1, rc = lc | 1;
        seg[lc].mn += val; seg[lc].mx += val; seg[lc].lz += val;
        seg[rc].mn += val; seg[rc].mx += val; seg[rc].lz += val;

        seg[node].lz = 0;
    }

    void pull(int node) {
        int lc = node << 1, rc = lc | 1;
        seg[node].mn = Math.min(seg[lc].mn, seg[rc].mn);
        seg[node].mx = Math.max(seg[lc].mx, seg[rc].mx);
    }

    void update(int node, int segLeft, int segRight, int queryLeft, int queryRight, int addValue) {
        if (queryLeft > queryRight) 
            return;

        if (queryLeft == segLeft && queryRight == segRight) {
            seg[node].mn += addValue;
            seg[node].mx += addValue;
            seg[node].lz += addValue;
            return;
        }
        push(node);
        int mid = (segLeft + segRight) >> 1;
        update(node << 1, segLeft, mid, queryLeft, Math.min(queryRight, mid), addValue);
        update(node << 1 | 1, mid + 1, segRight, Math.max(queryLeft, mid + 1), queryRight, addValue);

        pull(node);
    }

    int findFirst(int node, int segLeft, int segRight, int limit) {
        if (segLeft > limit) 
            return -1;
        if (seg[node].mn > 0 || seg[node].mx < 0) 
            return -1;
        if (segLeft == segRight) 
            return segLeft;

        push(node);
        int mid = (segLeft + segRight) >> 1;

        int leftRes = findFirst(node << 1, segLeft, mid, limit);
        if (leftRes != -1) 
            return leftRes;

        if (mid < limit) 
            return findFirst(node << 1 | 1, mid + 1, segRight, limit);
        return -1;
    }

    public int longestBalanced(int[] nums) {
        n = nums.length;
        seg = new Node[4 * n + 5];
        for (int i = 0; i < seg.length; i++) seg[i] = new Node();
        int[] lastPos = new int[100005];
        Arrays.fill(lastPos, -1);
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prev = lastPos[val];
            int diff = (val & 1) == 1 ? -1 : 1;

            update(1, 0, n - 1, prev + 1, i, diff);

            lastPos[val] = i;

            int start = findFirst(1, 0, n - 1, i);
            if (start != -1) {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,5,4,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The longest balanced subarray is <code>[2, 5, 4, 3]</code>.</li>
	<li>It has 2 distinct even numbers <code>[2, 4]</code> and 2 distinct odd numbers <code>[5, 3]</code>. Thus, the answer is 4.</li>
</ul>
</div>

<p><strong class="example">


