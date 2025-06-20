# 📌 Day 15: 1432. Max Difference You Can Get From Changing an Integer 🎯

**🔗 LeetCode Link:** [1432. Max Difference You Can Get From Changing an Integer](https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/)

---

## 🧩 Problem Description

<p>You are given an integer <code>num</code>. You will apply the following steps to <code>num</code> <strong>two</strong> separate times:</p>

<ul>
	<li>Pick a digit <code>x (0 &lt;= x &lt;= 9)</code>.</li>
	<li>Pick another digit <code>y (0 &lt;= y &lt;= 9)</code>. Note <code>y</code> can be equal to <code>x</code>.</li>
	<li>Replace all the occurrences of <code>x</code> in the decimal representation of <code>num</code> by <code>y</code>.</li>
</ul>

<p>Let <code>a</code> and <code>b</code> be the two results from applying the operation to <code>num</code> <em>independently</em>.</p>

<p>Return <em>the max difference</em> between <code>a</code> and <code>b</code>.</p>

<p>Note that neither <code>a</code> nor <code>b</code> may have any leading zeros, and <strong>must not</strong> be 0.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Greedy
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 555
<strong>Output:</strong> 888
<strong>Explanation:</strong> The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 9
<strong>Output:</strong> 8
<strong>Explanation:</strong> The first time pick x = 9 and y = 9 and store the new integer in a.
The second time pick x = 9 and y = 1 and store the new integer in b.
We have now a = 9 and b = 1 and max difference = 8
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 10<sup>8</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);
        StringBuilder maxStr = new StringBuilder(str);
        StringBuilder minStr = new StringBuilder(str);

        // Get max number by replacing first non-'9' digit
        char maxDigit = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                maxDigit = str.charAt(i);
                break;
            }
        }

        if (maxDigit != ' ') {
            for (int i = 0; i < maxStr.length(); i++) {
                if (maxStr.charAt(i) == maxDigit) {
                    maxStr.setCharAt(i, '9');
                }
            }
        }

        // Get min number
        char minDigit = str.charAt(0);
        char replace = '1';

        if (minDigit == '1') {
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                    minDigit = str.charAt(i);
                    replace = '0';
                    break;
                }
            }
        }

        for (int i = 0; i < minStr.length(); i++) {
            if (minStr.charAt(i) == minDigit) {
                minStr.setCharAt(i, replace);
            }
        }

        int maxVal = Integer.parseInt(maxStr.toString());
        int minVal = Integer.parseInt(minStr.toString());

        return maxVal - minVal;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 555
<strong>Output:</strong> 888
</pre>

<p><strong class="example">


