# 📌 Day 20: 944. Delete Columns to Make Sorted 🎯

**🔗 LeetCode Link:** [944. Delete Columns to Make Sorted](https://leetcode.com/problems/delete-columns-to-make-sorted/)

---

## 🧩 Problem Description

<p>You are given an array of <code>n</code> strings <code>strs</code>, all of the same length.</p>

<p>The strings can be arranged such that there is one on each line, making a grid.</p>

<ul>
	<li>For example, <code>strs = [&quot;abc&quot;, &quot;bce&quot;, &quot;cae&quot;]</code> can be arranged as follows:</li>
</ul>

<pre>
abc
bce
cae
</pre>

<p>You want to <strong>delete</strong> the columns that are <strong>not sorted lexicographically</strong>. In the above example (<strong>0-indexed</strong>), columns 0 (<code>&#39;a&#39;</code>, <code>&#39;b&#39;</code>, <code>&#39;c&#39;</code>) and 2 (<code>&#39;c&#39;</code>, <code>&#39;e&#39;</code>, <code>&#39;e&#39;</code>) are sorted, while column 1 (<code>&#39;b&#39;</code>, <code>&#39;c&#39;</code>, <code>&#39;a&#39;</code>) is not, so you would delete column 1.</p>

<p>Return <em>the number of columns that you will delete</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- String
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;cba&quot;,&quot;daf&quot;,&quot;ghi&quot;]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;a&quot;,&quot;b&quot;]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The grid looks as follows:
  a
  b
Column 0 is the only column and is sorted, so you will not delete any columns.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;zyx&quot;,&quot;wvu&quot;,&quot;tsr&quot;]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The grid looks as follows:
  zyx
  wvu
  tsr
All 3 columns are not sorted, so you will delete all 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == strs.length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= strs[i].length &lt;= 1000</code></li>
	<li><code>strs[i]</code> consists of lowercase English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public boolean isSortedColumn(int col, String[] strs) {
        for(int i=1;i<strs.length;i++) {
            if(strs[i].charAt(col) < strs[i-1].charAt(col))
                return false;
        }
        return true;
    }
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i=0;i<strs[0].length();i++) {
            if(!isSortedColumn(i, strs)) {
                count++;
            }
        }
        return count;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;cba&quot;,&quot;daf&quot;,&quot;ghi&quot;]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
</pre>

<p><strong class="example">


