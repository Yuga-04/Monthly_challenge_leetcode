# 📌 Day 5: 1061. Lexicographically Smallest Equivalent String 🎯

**🔗 LeetCode Link:** [1061. Lexicographically Smallest Equivalent String](https://leetcode.com/problems/lexicographically-smallest-equivalent-string/)

---

## 🧩 Problem Description

<p>You are given two strings of the same length <code>s1</code> and <code>s2</code> and a string <code>baseStr</code>.</p>

<p>We say <code>s1[i]</code> and <code>s2[i]</code> are equivalent characters.</p>

<ul>
	<li>For example, if <code>s1 = &quot;abc&quot;</code> and <code>s2 = &quot;cde&quot;</code>, then we have <code>&#39;a&#39; == &#39;c&#39;</code>, <code>&#39;b&#39; == &#39;d&#39;</code>, and <code>&#39;c&#39; == &#39;e&#39;</code>.</li>
</ul>

<p>Equivalent characters follow the usual rules of any equivalence relation:</p>

<ul>
	<li><strong>Reflexivity:</strong> <code>&#39;a&#39; == &#39;a&#39;</code>.</li>
	<li><strong>Symmetry:</strong> <code>&#39;a&#39; == &#39;b&#39;</code> implies <code>&#39;b&#39; == &#39;a&#39;</code>.</li>
	<li><strong>Transitivity:</strong> <code>&#39;a&#39; == &#39;b&#39;</code> and <code>&#39;b&#39; == &#39;c&#39;</code> implies <code>&#39;a&#39; == &#39;c&#39;</code>.</li>
</ul>

<p>For example, given the equivalency information from <code>s1 = &quot;abc&quot;</code> and <code>s2 = &quot;cde&quot;</code>, <code>&quot;acd&quot;</code> and <code>&quot;aab&quot;</code> are equivalent strings of <code>baseStr = &quot;eed&quot;</code>, and <code>&quot;aab&quot;</code> is the lexicographically smallest equivalent string of <code>baseStr</code>.</p>

<p>Return <em>the lexicographically smallest equivalent string of </em><code>baseStr</code><em> by using the equivalency information from </em><code>s1</code><em> and </em><code>s2</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
- Union Find
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> s1 = &quot;parker&quot;, s2 = &quot;morris&quot;, baseStr = &quot;parser&quot;
<strong>Output:</strong> &quot;makkek&quot;
<strong>Explanation:</strong> Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is &quot;makkek&quot;.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> s1 = &quot;hello&quot;, s2 = &quot;world&quot;, baseStr = &quot;hold&quot;
<strong>Output:</strong> &quot;hdld&quot;
<strong>Explanation: </strong>Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
So only the second letter &#39;o&#39; in baseStr is changed to &#39;d&#39;, the answer is &quot;hdld&quot;.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> s1 = &quot;leetcode&quot;, s2 = &quot;programs&quot;, baseStr = &quot;sourcecode&quot;
<strong>Output:</strong> &quot;aauaaaaada&quot;
<strong>Explanation:</strong> We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except &#39;u&#39; and &#39;d&#39; are transformed to &#39;a&#39;, the answer is &quot;aauaaaaada&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s1.length, s2.length, baseStr &lt;= 1000</code></li>
	<li><code>s1.length == s2.length</code></li>
	<li><code>s1</code>, <code>s2</code>, and <code>baseStr</code> consist of lowercase English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    // Union-Find parent array for 26 lowercase letters
    public int[] parent;

    // Main method to return the lexicographically smallest equivalent string
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];

        // Initialize each character to be its own parent
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }

        // Build equivalence groups based on s1 and s2
        for (int i = 0; i < s1.length(); ++i) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            int pu = find(u);
            int pv = find(v);

            // Union by lexicographical order (keep smaller one as root)
            if (pu < pv) {
                parent[pv] = pu;
            } else {
                parent[pu] = pv;
            }
        }

        // Construct result using the smallest equivalent character for each
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            char mapped = (char) (find(ch - 'a') + 'a');
            result.append(mapped);
        }
        return result.toString();
    }

    // Find operation with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> s1 = &quot;parker&quot;, s2 = &quot;morris&quot;, baseStr = &quot;parser&quot;
<strong>Output:</strong> &quot;makkek&quot;
</pre>

<p><strong class="example">


