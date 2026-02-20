# 📌 Day 20: 761. Special Binary String 🎯

**🔗 LeetCode Link:** [761. Special Binary String](https://leetcode.com/problems/special-binary-string/)

---

## 🧩 Problem Description

<p><strong>Special binary strings</strong> are binary strings with the following two properties:</p>

<ul>
	<li>The number of <code>0</code>&#39;s is equal to the number of <code>1</code>&#39;s.</li>
	<li>Every prefix of the binary string has at least as many <code>1</code>&#39;s as <code>0</code>&#39;s.</li>
</ul>

<p>You are given a <strong>special binary</strong> string <code>s</code>.</p>

<p>A move consists of choosing two consecutive, non-empty, special substrings of <code>s</code>, and swapping them. Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.</p>

<p>Return <em>the lexicographically largest resulting string possible after applying the mentioned operations on the string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
- Divide and Conquer
- Sorting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;11011000&quot;
<strong>Output:</strong> &quot;11100100&quot;
<strong>Explanation:</strong> The strings &quot;10&quot; [occuring at s[1]] and &quot;1100&quot; [at s[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;10&quot;
<strong>Output:</strong> &quot;10&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 50</code></li>
	<li><code>s[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
	<li><code>s</code> is a special binary string.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<>();
        
        for (int j = 0; j < s.length(); j++) {
            // Track balance: +1 for '1', -1 for '0'
            if (s.charAt(j) == '1') count++;
            else count--;
            
            // Found a balanced chunk when count returns to 0
            if (count == 0) {
                // Recursively maximize inner part, wrap with 1...0
                res.add('1' + makeLargestSpecial(s.substring(i + 1, j)) + '0');
                i = j + 1; // Move to next potential chunk
            }
        }
        
        // Sort chunks in descending order for largest arrangement
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }
}
```
---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;11011000&quot;
<strong>Output:</strong> &quot;11100100&quot;
<strong>Explanation:</strong> The strings &quot;10&quot; [occuring at s[1]] and &quot;1100&quot; [at s[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.
</pre>

<p><strong class="example">


