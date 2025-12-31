# 📌 Day 10: 3442. Maximum Difference Between Even and Odd Frequency I 🎯

**🔗 LeetCode Link:** [3442. Maximum Difference Between Even and Odd Frequency I](https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/)

---

## 🧩 Problem Description

<p>You are given a string <code>s</code> consisting of lowercase English letters. </p>

<p>Your task is to find the <strong>maximum</strong> difference <code>diff = a<sub>1</sub> - a<sub>2</sub></code> between the frequency of characters <code>a<sub>1</sub></code> and <code>a<sub>2</sub></code> in the string such that:</p>

<ul>
	<li><code>a<sub>1</sub></code> has an <strong>odd frequency</strong> in the string.</li>
	<li><code>a<sub>2</sub></code> has an <strong>even frequency</strong> in the string.</li>
</ul>

<p>Return this <strong>maximum</strong> difference.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Hash Table
- String
- Counting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aaaaabbc&quot;</span></p>

<p><strong>Output:</strong> 3</p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The character <code>&#39;a&#39;</code> has an <strong>odd frequency</strong> of <code><font face="monospace">5</font></code><font face="monospace">,</font> and <code>&#39;b&#39;</code> has an <strong>even frequency</strong> of <code><font face="monospace">2</font></code>.</li>
	<li>The maximum difference is <code>5 - 2 = 3</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abcabcab&quot;</span></p>

<p><strong>Output:</strong> 1</p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The character <code>&#39;a&#39;</code> has an <strong>odd frequency</strong> of <code><font face="monospace">3</font></code><font face="monospace">,</font> and <code>&#39;c&#39;</code> has an <strong>even frequency</strong> of <font face="monospace">2</font>.</li>
	<li>The maximum difference is <code>3 - 2 = 1</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
	<li><code>s</code> contains at least one character with an odd frequency and one with an even frequency.</li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count % 2 == 0) {
                minEven = Math.min(minEven, count);
            } else {
                maxOdd = Math.max(maxOdd, count);
            }
        }

        return maxOdd - minEven;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aaaaabbc&quot;</span></p>

<p><strong>Output:</strong> 3</p>

<p><strong>Explanation:</strong></p>
</div>

<p><strong class="example">


