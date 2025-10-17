# 📌 Day 17: 3003. Maximize the Number of Partitions After Operations 🎯

**🔗 LeetCode Link:** [3003. Maximize the Number of Partitions After Operations](https://leetcode.com/problems/maximize-the-number-of-partitions-after-operations/)

---

## 🧩 Problem Description

<p>You are given a string <code>s</code> and an integer <code>k</code>.</p>

<p>First, you are allowed to change <strong>at most</strong> <strong>one</strong> index in <code>s</code> to another lowercase English letter.</p>

<p>After that, do the following partitioning operation until <code>s</code> is <strong>empty</strong>:</p>

<ul>
	<li>Choose the <strong>longest</strong> <strong>prefix</strong> of <code>s</code> containing at most <code>k</code> <strong>distinct</strong> characters.</li>
	<li><strong>Delete</strong> the prefix from <code>s</code> and increase the number of partitions by one. The remaining characters (if any) in <code>s</code> maintain their initial order.</li>
</ul>

<p>Return an integer denoting the <strong>maximum</strong> number of resulting partitions after the operations by optimally choosing at most one index to change.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
- Dynamic Programming
- Bit Manipulation
- Bitmask
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;accca&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The optimal way is to change <code>s[2]</code> to something other than a and c, for example, b. then it becomes <code>&quot;acbca&quot;</code>.</p>

<p>Then we perform the operations:</p>

<ol>
	<li>The longest prefix containing at most 2 distinct characters is <code>&quot;ac&quot;</code>, we remove it and <code>s</code> becomes <code>&quot;bca&quot;</code>.</li>
	<li>Now The longest prefix containing at most 2 distinct characters is <code>&quot;bc&quot;</code>, so we remove it and <code>s</code> becomes <code>&quot;a&quot;</code>.</li>
	<li>Finally, we remove <code>&quot;a&quot;</code> and <code>s</code> becomes empty, so the procedure ends.</li>
</ol>

<p>Doing the operations, the string is divided into 3 partitions, so the answer is 3.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aabaab&quot;, k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>Initially&nbsp;<code>s</code>&nbsp;contains 2 distinct characters, so whichever character we change, it will contain at most 3 distinct characters, so the longest prefix with at most 3 distinct characters would always be all of it, therefore the answer is 1.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;xxyz&quot;, k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p>The optimal way is to change&nbsp;<code>s[0]</code>&nbsp;or&nbsp;<code>s[1]</code>&nbsp;to something other than characters in&nbsp;<code>s</code>, for example, to change&nbsp;<code>s[0]</code>&nbsp;to&nbsp;<code>w</code>.</p>

<p>Then&nbsp;<code>s</code>&nbsp;becomes <code>&quot;wxyz&quot;</code>, which consists of 4 distinct characters, so as <code>k</code> is 1, it will divide into 4 partitions.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
	<li><code>1 &lt;= k &lt;= 26</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    private HashMap<Long, Integer> cache;
    private String s;
    private int k;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.cache = new HashMap<>();
        this.s = s;
        this.k = k;
        return dp(0, 0, true) + 1;
    }

    private int dp(int index, int currentSet, boolean canChange) {
        long key = ((long) index << 27)
                | ((long) currentSet << 1)
                | (canChange ? 1 : 0);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (index == s.length()) {
            return 0;
        }

        int characterIndex = s.charAt(index) - 'a';
        int currentSetUpdated = currentSet | (1 << characterIndex);
        int distinctCount = Integer.bitCount(currentSetUpdated);

        int res;
        if (distinctCount > k) {
            res = 1 + dp(index + 1, 1 << characterIndex, canChange);
        } else {
            res = dp(index + 1, currentSetUpdated, canChange);
        }

        if (canChange) {
            for (int newCharIndex = 0; newCharIndex < 26; newCharIndex++) {
                int newSet = currentSet | (1 << newCharIndex);
                int newDistinctCount = Integer.bitCount(newSet);

                if (newDistinctCount > k) {
                    res = Math.max(res, 1 + dp(index + 1, 1 << newCharIndex, false));
                } else {
                    res = Math.max(res, dp(index + 1, newSet, false));
                }
            }
        }

        cache.put(key, res);
        return res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;accca&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The optimal way is to change <code>s[2]</code> to something other than a and c, for example, b. then it becomes <code>&quot;acbca&quot;</code>.</p>

<p>Then we perform the operations:</p>

<ol>
	<li>The longest prefix containing at most 2 distinct characters is <code>&quot;ac&quot;</code>, we remove it and <code>s</code> becomes <code>&quot;bca&quot;</code>.</li>
	<li>Now The longest prefix containing at most 2 distinct characters is <code>&quot;bc&quot;</code>, so we remove it and <code>s</code> becomes <code>&quot;a&quot;</code>.</li>
	<li>Finally, we remove <code>&quot;a&quot;</code> and <code>s</code> becomes empty, so the procedure ends.</li>
</ol>

<p>Doing the operations, the string is divided into 3 partitions, so the answer is 3.</p>
</div>

<p><strong class="example">


