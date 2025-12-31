# 📌 Day 21: 955. Delete Columns to Make Sorted II 🎯

**🔗 LeetCode Link:** [955. Delete Columns to Make Sorted II](https://leetcode.com/problems/delete-columns-to-make-sorted-ii/)

---

## 🧩 Problem Description

<p>You are given an array of <code>n</code> strings <code>strs</code>, all of the same length.</p>

<p>We may choose any deletion indices, and we delete all the characters in those indices for each string.</p>

<p>For example, if we have <code>strs = [&quot;abcdef&quot;,&quot;uvwxyz&quot;]</code> and deletion indices <code>{0, 2, 3}</code>, then the final array after deletions is <code>[&quot;bef&quot;, &quot;vyz&quot;]</code>.</p>

<p>Suppose we chose a set of deletion indices <code>answer</code> such that after deletions, the final array has its elements in <strong>lexicographic</strong> order (i.e., <code>strs[0] &lt;= strs[1] &lt;= strs[2] &lt;= ... &lt;= strs[n - 1]</code>). Return <em>the minimum possible value of</em> <code>answer.length</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- String
- Greedy
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;ca&quot;,&quot;bb&quot;,&quot;ac&quot;]
<strong>Output:</strong> 1
<strong>Explanation:</strong> 
After deleting the first column, strs = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;].
Now strs is in lexicographic order (ie. strs[0] &lt;= strs[1] &lt;= strs[2]).
We require at least 1 deletion since initially strs was not in lexicographic order, so the answer is 1.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;xc&quot;,&quot;yb&quot;,&quot;za&quot;]
<strong>Output:</strong> 0
<strong>Explanation:</strong> 
strs is already in lexicographic order, so we do not need to delete anything.
Note that the rows of strs are not necessarily in lexicographic order:
i.e., it is NOT necessarily true that (strs[0][0] &lt;= strs[0][1] &lt;= ...)
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;zyx&quot;,&quot;wvu&quot;,&quot;tsr&quot;]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We have to delete every column.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == strs.length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code> consists of lowercase English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int minDeletionSize(String[] A) {
        int n = A.length;
        if(n == 0) {
            return 0;
        }
        int w = A[0].length();    /* length of each word */
        int truth = 1; /* we assume the last element is sorted (or first, depending on your code) */
        int j;
        boolean[] sorted = new boolean[n - 1]; /* tells us if we know if an element is sorted */
        int delete = 0;
        for(int i = 0; i < w; i++) {
            
            for(j = 0; j < n - 1; j++) {
                if(!sorted[j] && (A[j].charAt(i) > A[j + 1].charAt(i))) {
                    delete++;
                    break;  /* no need to continue checking, we know the column is not 100% in order */
                }
            }
            
            if(j < n - 1) {
                continue;
            }
            for(int k = 0; k < n - 1; k++) {
                if(!sorted[k] && A[k].charAt(i) < A[k + 1].charAt(i)) {
                    sorted[k] = true;
                    truth++;
                }
            }
            if(truth == n) {
                return delete;
            }
        }
        return delete;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;ca&quot;,&quot;bb&quot;,&quot;ac&quot;]
<strong>Output:</strong> 1
<strong>Explanation:</strong> 
After deleting the first column, strs = [&quot;a&quot;, &quot;b&quot;, &quot;c&quot;].
Now strs is in lexicographic order (ie. strs[0] &lt;= strs[1] &lt;= strs[2]).
We require at least 1 deletion since initially strs was not in lexicographic order, so the answer is 1.
</pre>

<p><strong class="example">


