# 📌 Day 25: 2131. Longest Palindrome by Concatenating Two Letter Words 🎯

**🔗 LeetCode Link:** [2131. Longest Palindrome by Concatenating Two Letter Words](https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/)

---

## 🧩 Problem Description

<p>You are given an array of strings <code>words</code>. Each element of <code>words</code> consists of <strong>two</strong> lowercase English letters.</p>

<p>Create the <strong>longest possible palindrome</strong> by selecting some elements from <code>words</code> and concatenating them in <strong>any order</strong>. Each element can be selected <strong>at most once</strong>.</p>

<p>Return <em>the <strong>length</strong> of the longest palindrome that you can create</em>. If it is impossible to create any palindrome, return <code>0</code>.</p>

<p>A <strong>palindrome</strong> is a string that reads the same forward and backward.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- String
- Greedy
- Counting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["lc","cl","gg"]
<strong>Output:</strong> 6
<strong>Explanation:</strong> One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["ab","ty","yt","lc","cl","ab"]
<strong>Output:</strong> 8
<strong>Explanation:</strong> One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre><strong>Input:</strong> words = ["cc","ll","xx"]
<strong>Output:</strong> 2
<strong>Explanation:</strong> One longest palindrome is "cc", of length 2.
Note that "ll" is another longest palindrome that can be created, and so is "xx".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 10<sup>5</sup></code></li>
	<li><code>words[i].length == 2</code></li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        boolean hasCentralWord = false;

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        for (String word : map.keySet()) {
            int freq = map.get(word);
            if (freq == 0) continue;

            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                count += (freq / 2) * 4;
                if (freq % 2 == 1) hasCentralWord = true;
            } else if (map.containsKey(reversed)) {
                int pairs = Math.min(freq, map.get(reversed));
                count += pairs * 4;
                map.put(reversed, 0);
            }
            map.put(word, 0);
        }

        if (hasCentralWord) count += 2;
        return count;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["lc","cl","gg"]
<strong>Output:</strong> 6
</pre>

<p><strong class="example">


