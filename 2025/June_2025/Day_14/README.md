# 📌 Day 14: 2566. Maximum Difference by Remapping a Digit 🎯

**🔗 LeetCode Link:** [2566. Maximum Difference by Remapping a Digit](https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/)

---

## 🧩 Problem Description

<p>You are given an integer <code>num</code>. You know that Bob will sneakily <strong>remap</strong> one of the <code>10</code> possible digits (<code>0</code> to <code>9</code>) to another digit.</p>

<p>Return <em>the difference between the maximum and minimum&nbsp;values Bob can make by remapping&nbsp;<strong>exactly</strong> <strong>one</strong> digit in </em><code>num</code>.</p>

<p><strong>Notes:</strong></p>

<ul>
	<li>When Bob remaps a digit <font face="monospace">d1</font>&nbsp;to another digit <font face="monospace">d2</font>, Bob replaces all occurrences of <code>d1</code>&nbsp;in <code>num</code>&nbsp;with <code>d2</code>.</li>
	<li>Bob can remap a digit to itself, in which case <code>num</code>&nbsp;does not change.</li>
	<li>Bob can remap different digits for obtaining minimum and maximum values respectively.</li>
	<li>The resulting number after remapping can contain leading zeroes.</li>
</ul>

<p>&nbsp;</p>
<p><strong>

---

## 🧠 Topics

- Math
- Greedy
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 11891
<strong>Output:</strong> 99009
<strong>Explanation:</strong> 
To achieve the maximum value, Bob can remap the digit 1 to the digit 9 to yield 99899.
To achieve the minimum value, Bob can remap the digit 1 to the digit 0, yielding 890.
The difference between these two numbers is 99009.
</pre>

<p><strong>

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 90
<strong>Output:</strong> 99
<strong>Explanation:</strong>
The maximum value that can be returned by the function is 99 (if 0 is replaced by 9) and the minimum value that can be returned by the function is 0 (if 9 is replaced by 0).
Thus, we return 99.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 10<sup>8</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int minMaxDifference(int num) {
        String str = Integer.toString(num);
        char[] maxChars = str.toCharArray();
        char[] minChars = str.toCharArray();

        // Step 1: Find first non-9 digit for max replacement
        char replaceForMax = ' ';
        for (char c : maxChars) {
            if (c != '9') {
                replaceForMax = c;
                break;
            }
        }

        // Step 2: Replace that digit with 9 for max
        for (int i = 0; i < maxChars.length; i++) {
            if (maxChars[i] == replaceForMax) {
                maxChars[i] = '9';
            }
        }

        // Step 3: Replace first digit for min with 0
        char replaceForMin = minChars[0];
        for (int i = 0; i < minChars.length; i++) {
            if (minChars[i] == replaceForMin) {
                minChars[i] = '0';
            }
        }

        // Step 4: Convert and calculate result
        int maxVal = Integer.parseInt(new String(maxChars));
        int minVal = Integer.parseInt(new String(minChars));

        return maxVal - minVal;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 11891
<strong>Output:</strong> 99009
</pre>

<p><strong>


