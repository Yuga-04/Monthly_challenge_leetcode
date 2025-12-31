# 📌 Day 24: 166. Fraction to Recurring Decimal 🎯

**🔗 LeetCode Link:** [166. Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)

---

## 🧩 Problem Description

<p>Given two integers representing the <code>numerator</code> and <code>denominator</code> of a fraction, return <em>the fraction in string format</em>.</p>

<p>If the fractional part is repeating, enclose the repeating part in parentheses.</p>

<p>If multiple answers are possible, return <strong>any of them</strong>.</p>

<p>It is <strong>guaranteed</strong> that the length of the answer string is less than <code>10<sup>4</sup></code> for all the given inputs.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Hash Table
- Math
- String
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> numerator = 1, denominator = 2
<strong>Output:</strong> &quot;0.5&quot;
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> numerator = 2, denominator = 1
<strong>Output:</strong> &quot;2&quot;
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> numerator = 4, denominator = 333
<strong>Output:</strong> &quot;0.(012)&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;=&nbsp;numerator, denominator &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>denominator != 0</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);
        long rem = num % den;
        if (rem == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> seen = new HashMap<>();
        while (rem != 0) {
            if (seen.containsKey(rem)) {
                int pos = seen.get(rem);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }
            seen.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem %= den;
        }
        return sb.toString();
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> numerator = 1, denominator = 2
<strong>Output:</strong> &quot;0.5&quot;
</pre>

<p><strong class="example">


