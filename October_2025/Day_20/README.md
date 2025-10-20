# 📌 Day 20: 2011. Final Value of Variable After Performing Operations 🎯

**🔗 LeetCode Link:** [2011. Final Value of Variable After Performing Operations](https://leetcode.com/problems/final-value-of-variable-after-performing-operations/)

---

## 🧩 Problem Description

<p>There is a programming language with only <strong>four</strong> operations and <strong>one</strong> variable <code>X</code>:</p>

<ul>
	<li><code>++X</code> and <code>X++</code> <strong>increments</strong> the value of the variable <code>X</code> by <code>1</code>.</li>
	<li><code>--X</code> and <code>X--</code> <strong>decrements</strong> the value of the variable <code>X</code> by <code>1</code>.</li>
</ul>

<p>Initially, the value of <code>X</code> is <code>0</code>.</p>

<p>Given an array of strings <code>operations</code> containing a list of operations, return <em>the <strong>final </strong>value of </em><code>X</code> <em>after performing all the operations</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- String
- Simulation
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> operations = [&quot;--X&quot;,&quot;X++&quot;,&quot;X++&quot;]
<strong>Output:</strong> 1
<strong>Explanation:</strong>&nbsp;The operations are performed as follows:
Initially, X = 0.
--X: X is decremented by 1, X =  0 - 1 = -1.
X++: X is incremented by 1, X = -1 + 1 =  0.
X++: X is incremented by 1, X =  0 + 1 =  1.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> operations = [&quot;++X&quot;,&quot;++X&quot;,&quot;X++&quot;]
<strong>Output:</strong> 3
<strong>Explanation: </strong>The operations are performed as follows:
Initially, X = 0.
++X: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
X++: X is incremented by 1, X = 2 + 1 = 3.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> operations = [&quot;X++&quot;,&quot;++X&quot;,&quot;--X&quot;,&quot;X--&quot;]
<strong>Output:</strong> 0
<strong>Explanation:</strong>&nbsp;The operations are performed as follows:
Initially, X = 0.
X++: X is incremented by 1, X = 0 + 1 = 1.
++X: X is incremented by 1, X = 1 + 1 = 2.
--X: X is decremented by 1, X = 2 - 1 = 1.
X--: X is decremented by 1, X = 1 - 1 = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= operations.length &lt;= 100</code></li>
	<li><code>operations[i]</code> will be either <code>&quot;++X&quot;</code>, <code>&quot;X++&quot;</code>, <code>&quot;--X&quot;</code>, or <code>&quot;X--&quot;</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int finalValueAfterOperations(String[] o) {
        int x = 0;
        int l = o.length;
        for(int i = 0;i<l;i++){
            if(o[i].charAt(0)=='+'||o[i].charAt(2)=='+') x++;
            else x--;
        }
        return x;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> operations = [&quot;--X&quot;,&quot;X++&quot;,&quot;X++&quot;]
<strong>Output:</strong> 1
<strong>Explanation:</strong>&nbsp;The operations are performed as follows:
Initially, X = 0.
--X: X is decremented by 1, X =  0 - 1 = -1.
X++: X is incremented by 1, X = -1 + 1 =  0.
X++: X is incremented by 1, X =  0 + 1 =  1.
</pre>

<p><strong class="example">


