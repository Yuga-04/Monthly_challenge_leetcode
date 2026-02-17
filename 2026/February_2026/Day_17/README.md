# 📌 Day 17: 401. Binary Watch 🎯

**🔗 LeetCode Link:** [401. Binary Watch](https://leetcode.com/problems/binary-watch/)

---

## 🧩 Problem Description

<p>A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent&nbsp;the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.</p>

<ul>
	<li>For example, the below binary watch reads <code>&quot;4:51&quot;</code>.</li>
</ul>

<p>![Image](https://assets.leetcode.com/uploads/2021/04/08/binarywatch.jpg)</p>

<p>Given an integer <code>turnedOn</code> which represents the number of LEDs that are currently on (ignoring the PM), return <em>all possible times the watch could represent</em>. You may return the answer in <strong>any order</strong>.</p>

<p>The hour must not contain a leading zero.</p>

<ul>
	<li>For example, <code>&quot;01:00&quot;</code> is not valid. It should be <code>&quot;1:00&quot;</code>.</li>
</ul>

<p>The minute must&nbsp;consist of two digits and may contain a leading zero.</p>

<ul>
	<li>For example, <code>&quot;10:2&quot;</code> is not valid. It should be <code>&quot;10:02&quot;</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Backtracking
- Bit Manipulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<pre><strong>Input:</strong> turnedOn = 1
<strong>Output:</strong> ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
</pre><p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<pre><strong>Input:</strong> turnedOn = 9
<strong>Output:</strong> []
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= turnedOn &lt;= 10</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {

    int cntSetBits(int num) {
        return Integer.bitCount(num);
    }

    String formatTime(int h, int m) {
        String formattedTime = h + ":";

        if (m < 10) {
            formattedTime += "0";
        }
        formattedTime += m;
        return formattedTime;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();

        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                if (cntSetBits(h) + cntSetBits(m) == turnedOn) {
                    times.add(formatTime(h, m));
                }
            }
        }
        return times;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<pre><strong>Input:</strong> turnedOn = 1
<strong>Output:</strong> ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
</pre><p><strong class="example">


