# 📌 Day 9: 440. K-th Smallest in Lexicographical Order 🎯

**🔗 LeetCode Link:** [440. K-th Smallest in Lexicographical Order](https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/)

---

## 🧩 Problem Description

<p>Given two integers <code>n</code> and <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>lexicographically smallest integer in the range</em> <code>[1, n]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Trie
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 13, k = 2
<strong>Output:</strong> 10
<strong>Explanation:</strong> The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1, k = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        k -= 1; // we already include 1 in our result

        while (k > 0) {
            long count = getCount(curr, n);
            if (count <= k) {
                // skip current prefix subtree
                curr++;
                k -= count;
            } else {
                // go deeper in the tree
                curr *= 10;
                k -= 1;
            }
        }
        return (int) curr;
    }

    private long getCount(long prefix, long n) {
        long count = 0;
        long current = prefix;
        long next = prefix + 1;

        while (current <= n) {
            count += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return count;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 13, k = 2
<strong>Output:</strong> 10
</pre>

<p><strong class="example">


