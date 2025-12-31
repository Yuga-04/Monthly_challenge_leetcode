# 📌 Day 16: Unknown. Maximum 69 Number 🎯

**🔗 LeetCode Link:** [Unknown. Maximum 69 Number](https://leetcode.com/problems/maximum-69-number/)

---

## 🧩 Problem Description

<p>You are given a positive integer <code>num</code> consisting only of digits <code>6</code> and <code>9</code>.</p>

<p>Return <em>the maximum number you can get by changing <strong>at most</strong> one digit (</em><code>6</code><em> becomes </em><code>9</code><em>, and </em><code>9</code><em> becomes </em><code>6</code><em>)</em>.</p>

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

<pre><strong>Input:</strong> num = 9669
<strong>Output:</strong> 9969
<strong>Explanation:</strong> 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre><strong>Input:</strong> num = 9996
<strong>Output:</strong> 9999
<strong>Explanation:</strong> Changing the last digit 6 to 9 results in the maximum number.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre><strong>Input:</strong> num = 9999
<strong>Output:</strong> 9999
<strong>Explanation:</strong> It is better not to apply any change.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 10<sup>4</sup></code></li>
	<li><code>num</code>&nbsp;consists of only <code>6</code> and <code>9</code> digits.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int maximum69Number(int num) {
  char[] digits = String.valueOf(num).toCharArray();  
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; 
            }
        }
        return Integer.parseInt(new String(digits));
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre><strong>Input:</strong> num = 9669
<strong>Output:</strong> 9969
</pre>

<p><strong class="example">


