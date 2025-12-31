# 📌 Day 27: 2125. Number of Laser Beams in a Bank 🎯

**🔗 LeetCode Link:** [2125. Number of Laser Beams in a Bank](https://leetcode.com/problems/number-of-laser-beams-in-a-bank/)

---

## 🧩 Problem Description

<p>Anti-theft security devices are activated inside a bank. You are given a <strong>0-indexed</strong> binary string array <code>bank</code> representing the floor plan of the bank, which is an <code>m x n</code> 2D matrix. <code>bank[i]</code> represents the <code>i<sup>th</sup></code> row, consisting of <code>&#39;0&#39;</code>s and <code>&#39;1&#39;</code>s. <code>&#39;0&#39;</code> means the cell is empty, while<code>&#39;1&#39;</code> means the cell has a security device.</p>

<p>There is <strong>one</strong> laser beam between any <strong>two</strong> security devices <strong>if both</strong> conditions are met:</p>

<ul>
	<li>The two devices are located on two <strong>different rows</strong>: <code>r<sub>1</sub></code> and <code>r<sub>2</sub></code>, where <code>r<sub>1</sub> &lt; r<sub>2</sub></code>.</li>
	<li>For <strong>each</strong> row <code>i</code> where <code>r<sub>1</sub> &lt; i &lt; r<sub>2</sub></code>, there are <strong>no security devices</strong> in the <code>i<sup>th</sup></code> row.</li>
</ul>

<p>Laser beams are independent, i.e., one beam does not interfere nor join with another.</p>

<p>Return <em>the total number of laser beams in the bank</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
- String
- Matrix
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser1.jpg" style="width: 400px; height: 368px;" />
<pre>
<strong>Input:</strong> bank = [&quot;011001&quot;,&quot;000000&quot;,&quot;010100&quot;,&quot;001000&quot;]
<strong>Output:</strong> 8
<strong>Explanation:</strong> Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0<sup>th</sup> row with any on the 3<sup>rd</sup> row.
This is because the 2<sup>nd</sup> row contains security devices, which breaks the second condition.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser2.jpg" style="width: 244px; height: 325px;" />
<pre>
<strong>Input:</strong> bank = [&quot;000&quot;,&quot;111&quot;,&quot;000&quot;]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There does not exist two devices located on two different rows.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == bank.length</code></li>
	<li><code>n == bank[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 500</code></li>
	<li><code>bank[i][j]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        if (n == 0) return 0;

        int[] sd = new int[n];
        int row = 0;

        for (String it : bank) {
            int count = 0;
            for (int i = 0; i < bank[0].length(); i++) {
                if (it.charAt(i) == '1') count++;
            }
            sd[row++] = count;
        }

        List<Integer> sdwz = new ArrayList<>();
        for (int i = 0; i < sd.length; i++) {
            if (sd[i] != 0) sdwz.add(sd[i]);
        }

        int ans = 0;
        if (sdwz.size() <= 1) return ans;

        for (int i = 0; i < sdwz.size() - 1; i++) {
            ans += sdwz.get(i) * sdwz.get(i + 1);
        }

        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/laser1.jpg" style="width: 400px; height: 368px;" />
<pre>
<strong>Input:</strong> bank = [&quot;011001&quot;,&quot;000000&quot;,&quot;010100&quot;,&quot;001000&quot;]
<strong>Output:</strong> 8
<strong>Explanation:</strong> Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0<sup>th</sup> row with any on the 3<sup>rd</sup> row.
This is because the 2<sup>nd</sup> row contains security devices, which breaks the second condition.
</pre>

<p><strong class="example">


