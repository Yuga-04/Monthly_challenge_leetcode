# 📌 Day 22: 868. Binary Gap 🎯

**🔗 LeetCode Link:** [868. Binary Gap](https://leetcode.com/problems/binary-gap/)

---

## 🧩 Problem Description

<p>Given a positive integer <code>n</code>, find and return <em>the <strong>longest distance</strong> between any two <strong>adjacent</strong> </em><code>1</code><em>&#39;s in the binary representation of </em><code>n</code><em>. If there are no two adjacent </em><code>1</code><em>&#39;s, return </em><code>0</code><em>.</em></p>

<p>Two <code>1</code>&#39;s are <strong>adjacent</strong> if there are only <code>0</code>&#39;s separating them (possibly no <code>0</code>&#39;s). The <b>distance</b> between two <code>1</code>&#39;s is the absolute difference between their bit positions. For example, the two <code>1</code>&#39;s in <code>&quot;1001&quot;</code> have a distance of 3.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Bit Manipulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 22
<strong>Output:</strong> 2
<strong>Explanation:</strong> 22 in binary is &quot;10110&quot;.
The first adjacent pair of 1&#39;s is &quot;<u>1</u>0<u>1</u>10&quot; with a distance of 2.
The second adjacent pair of 1&#39;s is &quot;10<u>11</u>0&quot; with a distance of 1.
The answer is the largest of these two distances, which is 2.
Note that &quot;<u>1</u>01<u>1</u>0&quot; is not a valid pair since there is a 1 separating the two 1&#39;s underlined.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 8
<strong>Output:</strong> 0
<strong>Explanation:</strong> 8 in binary is &quot;1000&quot;.
There are not any adjacent pairs of 1&#39;s in the binary representation of 8, so we return 0.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 5
<strong>Output:</strong> 2
<strong>Explanation:</strong> 5 in binary is &quot;101&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int binaryGap(int n) {
        int maxdist = 0;
        int currdist = 0;
        boolean found = false;
        
        while (n > 0) {
            int bit = n % 2;
            
            if (bit == 1) {
                if (found) {
                    maxdist = Math.max(maxdist, currdist);
                }
                currdist = 1;
                found = true;
            } else {
                if (found) {
                    currdist++;
                }
            }
            
            n /= 2;
        }
        
        return maxdist;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 22
<strong>Output:</strong> 2
<strong>Explanation:</strong> 22 in binary is &quot;10110&quot;.
The first adjacent pair of 1&#39;s is &quot;<u>1</u>0<u>1</u>10&quot; with a distance of 2.
The second adjacent pair of 1&#39;s is &quot;10<u>11</u>0&quot; with a distance of 1.
The answer is the largest of these two distances, which is 2.
Note that &quot;<u>1</u>01<u>1</u>0&quot; is not a valid pair since there is a 1 separating the two 1&#39;s underlined.
</pre>

<p><strong class="example">


