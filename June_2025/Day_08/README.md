# 📌 Day 8: 386. Lexicographical Numbers 🎯

**🔗 LeetCode Link:** [386. Lexicographical Numbers](https://leetcode.com/problems/lexicographical-numbers/)

---

## 🧩 Problem Description

<p>Given an integer <code>n</code>, return all the numbers in the range <code>[1, n]</code> sorted in lexicographical order.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and uses <code>O(1)</code> extra space.&nbsp;</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Depth-First Search
- Trie
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<pre><strong>Input:</strong> n = 13
<strong>Output:</strong> [1,10,11,12,13,2,3,4,5,6,7,8,9]
</pre><p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> [1,2]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < n; i++) {
            result.add(count);
            if (count * 10 <= n) {
                count *= 10; // Move to next lexicographical level
            } else {
                if (count >= n)
                    count /= 10; // Backtrack if needed
                count++;
                while (count % 10 == 0) {
                    count /= 10; // Skip trailing zeros
                }
            }
        }

        return result;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<pre><strong>Input:</strong> n = 13
<strong>Output:</strong> [1,10,11,12,13,2,3,4,5,6,7,8,9]
</pre><p><strong class="example">


