# 📌 Day 8: 1888. Minimum Number of Flips to Make the Binary String Alternating 🎯

**🔗 LeetCode Link:** [1888. Minimum Number of Flips to Make the Binary String Alternating](https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/)

---

## 🧩 Problem Description

<p>You are given a binary string <code>s</code>. You are allowed to perform two types of operations on the string in any sequence:</p>

<ul>
	<li><strong>Type-1: Remove</strong> the character at the start of the string <code>s</code> and <strong>append</strong> it to the end of the string.</li>
	<li><strong>Type-2: Pick</strong> any character in <code>s</code> and <strong>flip</strong> its value, i.e., if its value is <code>&#39;0&#39;</code> it becomes <code>&#39;1&#39;</code> and vice-versa.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> number of <strong>type-2</strong> operations you need to perform</em> <em>such that </em><code>s</code> <em>becomes <strong>alternating</strong>.</em></p>

<p>The string is called <strong>alternating</strong> if no two adjacent characters are equal.</p>

<ul>
	<li>For example, the strings <code>&quot;010&quot;</code> and <code>&quot;1010&quot;</code> are alternating, while the string <code>&quot;0100&quot;</code> is not.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
- Dynamic Programming
- Sliding Window
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;111000&quot;
<strong>Output:</strong> 2
<strong>Explanation</strong>: Use the first operation two times to make s = &quot;100011&quot;.
Then, use the second operation on the third and sixth elements to make s = &quot;10<u>1</u>01<u>0</u>&quot;.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;010&quot;
<strong>Output:</strong> 0
<strong>Explanation</strong>: The string is already alternating.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;1110&quot;
<strong>Output:</strong> 1
<strong>Explanation</strong>: Use the second operation on the second element to make s = &quot;1<u>0</u>10&quot;.
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
    public int minFlips(String s) {
        int n = s.length();
        int res = n;
        int[] op = {0, 0};

        for (int i = 0; i < n; i++)
            op[(s.charAt(i) ^ i) & 1]++;

        for (int i = 0; i < n; i++) {
            op[(s.charAt(i) ^ i) & 1]--;
            op[(s.charAt(i) ^ (n + i)) & 1]++;
            res = Math.min(res, Math.min(op[0], op[1]));
        }

        return res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;111000&quot;
<strong>Output:</strong> 2
<strong>Explanation</strong>: Use the first operation two times to make s = &quot;100011&quot;.
Then, use the second operation on the third and sixth elements to make s = &quot;10<u>1</u>01<u>0</u>&quot;.
</pre>

<p><strong class="example">


