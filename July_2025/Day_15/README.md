# 📌 Day 15: 3136. Valid Word 🎯

**🔗 LeetCode Link:** [3136. Valid Word](https://leetcode.com/problems/valid-word/)

---

## 🧩 Problem Description

<p>A word is considered <strong>valid</strong> if:</p>

<ul>
	<li>It contains a <strong>minimum</strong> of 3 characters.</li>
	<li>It contains only digits (0-9), and English letters (uppercase and lowercase).</li>
	<li>It includes <strong>at least</strong> one <strong>vowel</strong>.</li>
	<li>It includes <strong>at least</strong> one <strong>consonant</strong>.</li>
</ul>

<p>You are given a string <code>word</code>.</p>

<p>Return <code>true</code> if <code>word</code> is valid, otherwise, return <code>false</code>.</p>

<p><strong>Notes:</strong></p>

<ul>
	<li><code>&#39;a&#39;</code>, <code>&#39;e&#39;</code>, <code>&#39;i&#39;</code>, <code>&#39;o&#39;</code>, <code>&#39;u&#39;</code>, and their uppercases are <strong>vowels</strong>.</li>
	<li>A <strong>consonant</strong> is an English letter that is not a vowel.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;234Adas&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>This word satisfies the conditions.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;b3&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>The length of this word is fewer than 3, and does not have a vowel.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;a3$e&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>This word contains a <code>&#39;$&#39;</code> character and does not have a consonant.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 20</code></li>
	<li><code>word</code> consists of English uppercase and lowercase letters, digits, <code>&#39;@&#39;</code>, <code>&#39;#&#39;</code>, and <code>&#39;$&#39;</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    private static final String VOWELS = "aeiouAEIOU";

    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        int v = 0, c = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) continue;

            if (Character.isLetter(ch)) {
                if (VOWELS.indexOf(ch) >= 0) ++v;
                else ++c;
            } else {
                return false;                 // invalid symbol
            }
        }
        return v > 0 && c > 0;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;234Adas&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

</div>

<p><strong class="example">


