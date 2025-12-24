# 📌 Day 24: 3074. Apple Redistribution into Boxes 🎯

**🔗 LeetCode Link:** [3074. Apple Redistribution into Boxes](https://leetcode.com/problems/apple-redistribution-into-boxes/)

---

## 🧩 Problem Description

<p>You are given an array <code>apple</code> of size <code>n</code> and an array <code>capacity</code> of size <code>m</code>.</p>

<p>There are <code>n</code> packs where the <code>i<sup>th</sup></code> pack contains <code>apple[i]</code> apples. There are <code>m</code> boxes as well, and the <code>i<sup>th</sup></code> box has a capacity of <code>capacity[i]</code> apples.</p>

<p>Return <em>the <strong>minimum</strong> number of boxes you need to select to redistribute these </em><code>n</code><em> packs of apples into boxes</em>.</p>

<p><strong>Note</strong> that, apples from the same pack can be distributed into different boxes.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Greedy
- Sorting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> apple = [1,3,2], capacity = [4,3,1,5,2]
<strong>Output:</strong> 2
<strong>Explanation:</strong> We will use boxes with capacities 4 and 5.
It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> apple = [5,5,5], capacity = [2,4,2,7]
<strong>Output:</strong> 4
<strong>Explanation:</strong> We will need to use all the boxes.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == apple.length &lt;= 50</code></li>
	<li><code>1 &lt;= m == capacity.length &lt;= 50</code></li>
	<li><code>1 &lt;= apple[i], capacity[i] &lt;= 50</code></li>
	<li>The input is generated such that it&#39;s possible to redistribute packs of apples into boxes.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Calculate total apples
        int total = 0;
        for (int a : apple) {
            total += a;
        }
        
        // Sorts in ascending order
        Arrays.sort(capacity);
        
        int cnt = 0;
        // Iterate from the end to pick largest boxes first
        for (int i = capacity.length - 1; i >= 0; i--) {
            total -= capacity[i];
            cnt++;
            if (total <= 0) {
                return cnt;
            }
        }
        return cnt;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> apple = [1,3,2], capacity = [4,3,1,5,2]
<strong>Output:</strong> 2
<strong>Explanation:</strong> We will use boxes with capacities 4 and 5.
It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.
</pre>

<p><strong class="example">


