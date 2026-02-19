# 📌 Day 19: 696. Count Binary Substrings 🎯

**🔗 LeetCode Link:** [696. Count Binary Substrings](http://leetcode.com/problems/count-binary-substrings)

---

## 🧩 Problem Description

<p>Given a binary string <code>s</code>, return the number of non-empty substrings that have the same number of <code>0</code>&#39;s and <code>1</code>&#39;s, and all the <code>0</code>&#39;s and all the <code>1</code>&#39;s in these substrings are grouped consecutively.</p>

<p>Substrings that occur multiple times are counted the number of times they occur.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Two Pointers
- String
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;00110011&quot;
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 substrings that have equal number of consecutive 1&#39;s and 0&#39;s: &quot;0011&quot;, &quot;01&quot;, &quot;1100&quot;, &quot;10&quot;, &quot;0011&quot;, and &quot;01&quot;.
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, &quot;00110011&quot; is not a valid substring because all the 0&#39;s (and 1&#39;s) are not grouped together.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;10101&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 substrings: &quot;10&quot;, &quot;01&quot;, &quot;10&quot;, &quot;01&quot; that have equal number of consecutive 1&#39;s and 0&#39;s.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0, prev = 0, strk = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) strk++;
            else {
                prev = strk;
                strk = 1;
            }
            if (strk <= prev) res++;
        }
        return res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;00110011&quot;
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 substrings that have equal number of consecutive 1&#39;s and 0&#39;s: &quot;0011&quot;, &quot;01&quot;, &quot;1100&quot;, &quot;10&quot;, &quot;0011&quot;, and &quot;01&quot;.
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, &quot;00110011&quot; is not a valid substring because all the 0&#39;s (and 1&#39;s) are not grouped together.
</pre>

<p><strong class="example">


