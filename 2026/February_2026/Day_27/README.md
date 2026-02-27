# 📌 Day 27: 3666. Minimum Operations to Equalize Binary String 🎯

**🔗 LeetCode Link:** [3666. Minimum Operations to Equalize Binary String](https://leetcode.com/problems/minimum-operations-to-equalize-binary-string/)

---

## 🧩 Problem Description

<p>You are given a binary string <code>s</code>, and an integer <code>k</code>.</p>

<p>In one operation, you must choose <strong>exactly</strong> <code>k</code> <strong>different</strong> indices and <strong>flip</strong> each <code>&#39;0&#39;</code> to <code>&#39;1&#39;</code> and each <code>&#39;1&#39;</code> to <code>&#39;0&#39;</code>.</p>

<p>Return the <strong>minimum</strong> number of operations required to make all characters in the string equal to <code>&#39;1&#39;</code>. If it is not possible, return -1.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- String
- Breadth-First Search
- Union-Find
- Ordered Set
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;110&quot;, k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is one <code>&#39;0&#39;</code> in <code>s</code>.</li>
	<li>Since <code>k = 1</code>, we can flip it directly in one operation.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;0101&quot;, k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>One optimal set of operations choosing <code>k = 3</code> indices in each operation is:</p>

<ul>
	<li><strong>Operation 1</strong>: Flip indices <code>[0, 1, 3]</code>. <code>s</code> changes from <code>&quot;0101&quot;</code> to <code>&quot;1000&quot;</code>.</li>
	<li><strong>Operation 2</strong>: Flip indices <code>[1, 2, 3]</code>. <code>s</code> changes from <code>&quot;1000&quot;</code> to <code>&quot;1111&quot;</code>.</li>
</ul>

<p>Thus, the minimum number of operations is 2.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;101&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>Since <code>k = 2</code> and <code>s</code> has only one <code>&#39;0&#39;</code>, it is impossible to flip exactly <code>k</code> indices to make all <code>&#39;1&#39;</code>. Hence, the answer is -1.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>​​​​​​​5</sup></code></li>
	<li><code>s[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int minOperations(String s, int k) {
        int zero = 0;
        int len = s.length();

        for (int i = 0; i < len; i++)
            zero += ~s.charAt(i) & 1;

        if (zero == 0)
            return 0;

        if (len == k)
            return ((zero == len ? 1 : 0) << 1) - 1;

        int base = len - k;

        int odd = Math.max(
            (zero + k - 1) / k,
            (len - zero + base - 1) / base
        );

        odd += ~odd & 1;

        int even = Math.max(
            (zero + k - 1) / k,
            (zero + base - 1) / base
        );

        even += even & 1;

        int res = Integer.MAX_VALUE;

        if ((k & 1) == (zero & 1))
            res = Math.min(res, odd);

        if ((~zero & 1) == 1)
            res = Math.min(res, even);

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;110&quot;, k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is one <code>&#39;0&#39;</code> in <code>s</code>.</li>
	<li>Since <code>k = 1</code>, we can flip it directly in one operation.</li>
</ul>
</div>

<p><strong class="example">


