# 📌 Day 14: 2264. Largest 3 🎯

**🔗 LeetCode Link:** [2264. Largest 3](https://leetcode.com/problems/largest-3-same-digit-number-in-string/)

---

## 🧩 Problem Description

<p>You are given a string <code>num</code> representing a large integer. An integer is <strong>good</strong> if it meets the following conditions:</p>

<ul>
	<li>It is a <strong>substring</strong> of <code>num</code> with length <code>3</code>.</li>
	<li>It consists of only one unique digit.</li>
</ul>

<p>Return <em>the <strong>maximum good </strong>integer as a <strong>string</strong> or an empty string </em><code>""</code><em> if no such integer exists</em>.</p>

<p>Note:</p>

<ul>
	<li>A <strong>substring</strong> is a contiguous sequence of characters within a string.</li>
	<li>There may be <strong>leading zeroes</strong> in <code>num</code> or a good integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre><strong>Input:</strong> num = "6<strong><u>777</u></strong>133339"
<strong>Output:</strong> "777"
<strong>Explanation:</strong> There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre><strong>Input:</strong> num = "23<strong><u>000</u></strong>19"
<strong>Output:</strong> "000"
<strong>Explanation:</strong> "000" is the only good integer.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre><strong>Input:</strong> num = "42352338"
<strong>Output:</strong> ""
<strong>Explanation:</strong> No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= num.length &lt;= 1000</code></li>
	<li><code>num</code> only consists of digits.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public String largestGoodInteger(String num) {
        String best = "";
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                best = best.compareTo(num.substring(i, i+3)) > 0 ? best : num.substring(i, i+3);
            }
        }
        return best;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre><strong>Input:</strong> num = "6<strong><u>777</u></strong>133339"
<strong>Output:</strong> "777"
</pre>

<p><strong class="example">


