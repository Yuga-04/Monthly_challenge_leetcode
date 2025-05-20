# 📌 Day 12: 2094. Finding 3-Digit Even Numbers🎯

**🔗 LeetCode Link:** [2095. Finding 3-Digit Even Numbers](https://leetcode.com/problems/finding-3-digit-even-numbers/description/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>digits</code>, where each element is a digit. The array may contain duplicates.</p>

<p>You need to find <strong>all</strong> the <strong>unique</strong> integers that follow the given requirements:</p>

<ul>
	<li>The integer consists of the <strong>concatenation</strong> of <strong>three</strong> elements from <code>digits</code> in <strong>any</strong> arbitrary order.</li>
	<li>The integer does not have <strong>leading zeros</strong>.</li>
	<li>The integer is <strong>even</strong>.</li>
</ul>

<p>For example, if the given <code>digits</code> were <code>[1, 2, 3]</code>, integers <code>132</code> and <code>312</code> follow the requirements.</p>

<p>Return <em>a <strong>sorted</strong> array of the unique integers.</em></p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Sorting
- Enumeration
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre><strong>Input:</strong> digits = [2,1,3,0]
<strong>Output:</strong> [102,120,130,132,210,230,302,310,312,320]
<strong>Explanation:</strong> All the possible integers that follow the requirements are in the output array. 
Notice that there are no <strong>odd</strong> integers or integers with <strong>leading zeros</strong>.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre><strong>Input:</strong> digits = [2,2,8,8,2]
<strong>Output:</strong> [222,228,282,288,822,828,882]
<strong>Explanation:</strong> The same digit can be used as many times as it appears in digits. 
In this example, the digit 8 is used twice each time in 288, 828, and 882. 
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre><strong>Input:</strong> digits = [3,7,5]
<strong>Output:</strong> []
<strong>Explanation:</strong> No <strong>even</strong> integers can be formed using the given digits.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= digits.length &lt;= 100</code></li>
	<li><code>0 &lt;= digits[i] &lt;= 9</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] mpp = new int[10];
        for (int d : digits) mpp[d]++;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (mpp[i] == 0) continue;
            mpp[i]--;
            for (int j = 0; j <= 9; j++) {
                if (mpp[j] == 0) continue;
                mpp[j]--;
                for (int k = 0; k <= 8; k += 2) {
                    if (mpp[k] == 0) continue;
                    mpp[k]--;
                    res.add(i*100 + j*10 + k);
                    mpp[k]++;
                }
                mpp[j]++;
            }
            mpp[i]++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre><strong>Input:</strong> digits = [2,1,3,0]
<strong>Output:</strong> [102,120,130,132,210,230,302,310,312,320]
</pre>

<p><strong class="example">


