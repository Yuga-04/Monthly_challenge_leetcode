# 📌 Day 4: 3307. Find the K-th Character in String Game II 🎯

**🔗 LeetCode Link:** [3307. Find the K-th Character in String Game II](https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/)

---

## 🧩 Problem Description

<p>Alice and Bob are playing a game. Initially, Alice has a string <code>word = &quot;a&quot;</code>.</p>

<p>You are given a <strong>positive</strong> integer <code>k</code>. You are also given an integer array <code>operations</code>, where <code>operations[i]</code> represents the <strong>type</strong> of the <code>i<sup>th</sup></code> operation.</p>

<p>Now Bob will ask Alice to perform <strong>all</strong> operations in sequence:</p>

<ul>
	<li>If <code>operations[i] == 0</code>, <strong>append</strong> a copy of <code>word</code> to itself.</li>
	<li>If <code>operations[i] == 1</code>, generate a new string by <strong>changing</strong> each character in <code>word</code> to its <strong>next</strong> character in the English alphabet, and <strong>append</strong> it to the <em>original</em> <code>word</code>. For example, performing the operation on <code>&quot;c&quot;</code> generates <code>&quot;cd&quot;</code> and performing the operation on <code>&quot;zb&quot;</code> generates <code>&quot;zbac&quot;</code>.</li>
</ul>

<p>Return the value of the <code>k<sup>th</sup></code> character in <code>word</code> after performing all the operations.</p>

<p><strong>Note</strong> that the character <code>&#39;z&#39;</code> can be changed to <code>&#39;a&#39;</code> in the second type of operation.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Bit Manipulation
- Recursion
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">k = 5, operations = [0,0,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;a&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Initially, <code>word == &quot;a&quot;</code>. Alice performs the three operations as follows:</p>

<ul>
	<li>Appends <code>&quot;a&quot;</code> to <code>&quot;a&quot;</code>, <code>word</code> becomes <code>&quot;aa&quot;</code>.</li>
	<li>Appends <code>&quot;aa&quot;</code> to <code>&quot;aa&quot;</code>, <code>word</code> becomes <code>&quot;aaaa&quot;</code>.</li>
	<li>Appends <code>&quot;aaaa&quot;</code> to <code>&quot;aaaa&quot;</code>, <code>word</code> becomes <code>&quot;aaaaaaaa&quot;</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">k = 10, operations = [0,1,0,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;b&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Initially, <code>word == &quot;a&quot;</code>. Alice performs the four operations as follows:</p>

<ul>
	<li>Appends <code>&quot;a&quot;</code> to <code>&quot;a&quot;</code>, <code>word</code> becomes <code>&quot;aa&quot;</code>.</li>
	<li>Appends <code>&quot;bb&quot;</code> to <code>&quot;aa&quot;</code>, <code>word</code> becomes <code>&quot;aabb&quot;</code>.</li>
	<li>Appends <code>&quot;aabb&quot;</code> to <code>&quot;aabb&quot;</code>, <code>word</code> becomes <code>&quot;aabbaabb&quot;</code>.</li>
	<li>Appends <code>&quot;bbccbbcc&quot;</code> to <code>&quot;aabbaabb&quot;</code>, <code>word</code> becomes <code>&quot;aabbaabbbbccbbcc&quot;</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 10<sup>14</sup></code></li>
	<li><code>1 &lt;= operations.length &lt;= 100</code></li>
	<li><code>operations[i]</code> is either 0 or 1.</li>
	<li>The input is generated such that <code>word</code> has <strong>at least</strong> <code>k</code> characters after all operations.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public char kthCharacter(long k, int[] operations) {
        int shift = 0; // total number of +1 (mod 26) operations
        List<Long> lengths = new ArrayList<>();
        long len = 1;

        for (int op : operations) {
            len *= 2;
            lengths.add(len);
            if (len >= k) break;
        }

        for (int i = lengths.size() - 1; i >= 0; i--) {
            long half = lengths.get(i) / 2;
            int op = operations[i];

            if (k > half) {
                k -= half;
                if (op == 1) shift++;
            }
            // else: k remains the same
        }

        // Apply total shift from 'a'
        return (char) ((('a' - 'a' + shift) % 26) + 'a');
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">k = 5, operations = [0,0,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;a&quot;</span></p>

</div>

<p><strong class="example">


