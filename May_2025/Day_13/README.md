# 📌 Day 13: 3335. Total Characters in String After Transformations I 🎯

**🔗 LeetCode Link:** [3335. Total Characters in String After Transformations I](https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/)

---

## 🧩 Problem Description

<p>You are given a string <code>s</code> and an integer <code>t</code>, representing the number of <strong>transformations</strong> to perform. In one <strong>transformation</strong>, every character in <code>s</code> is replaced according to the following rules:</p>

<ul>
	<li>If the character is <code>'z'</code>, replace it with the string <code>"ab"</code>.</li>
	<li>Otherwise, replace it with the <strong>next</strong> character in the alphabet. For example, <code>'a'</code> is replaced with <code>'b'</code>, <code>'b'</code> is replaced with <code>'c'</code>, and so on.</li>
</ul>

<p>Return the <strong>length</strong> of the resulting string after <strong>exactly</strong> <code>t</code> transformations.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Hash Table
- Math
- String
- Dynamic Programming
- Counting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abcyy", t = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><strong>First Transformation (t = 1)</strong>:
	<ul>
		<li><code>'a'</code> becomes <code>'b'</code></li>
		<li><code>'b'</code> becomes <code>'c'</code></li>
		<li><code>'c'</code> becomes <code>'d'</code></li>
		<li><code>'y'</code> becomes <code>'z'</code></li>
		<li><code>'y'</code> becomes <code>'z'</code></li>
		<li>String after the first transformation: <code>"bcdzz"</code></li>
	</ul>
	</li>
	<li><strong>Second Transformation (t = 2)</strong>:
	<ul>
		<li><code>'b'</code> becomes <code>'c'</code></li>
		<li><code>'c'</code> becomes <code>'d'</code></li>
		<li><code>'d'</code> becomes <code>'e'</code></li>
		<li><code>'z'</code> becomes <code>"ab"</code></li>
		<li><code>'z'</code> becomes <code>"ab"</code></li>
		<li>String after the second transformation: <code>"cdeabab"</code></li>
	</ul>
	</li>
	<li><strong>Final Length of the string</strong>: The string is <code>"cdeabab"</code>, which has 7 characters.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "azbk", t = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><strong>First Transformation (t = 1)</strong>:
	<ul>
		<li><code>'a'</code> becomes <code>'b'</code></li>
		<li><code>'z'</code> becomes <code>"ab"</code></li>
		<li><code>'b'</code> becomes <code>'c'</code></li>
		<li><code>'k'</code> becomes <code>'l'</code></li>
		<li>String after the first transformation: <code>"babcl"</code></li>
	</ul>
	</li>
	<li><strong>Final Length of the string</strong>: The string is <code>"babcl"</code>, which has 5 characters.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
	<li><code>1 &lt;= t &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    private static final int mod = 1000000007;
    private int mod_add(int a, int b) {
        a %= mod; b %= mod;
        return ((a + b) % mod + mod) % mod;
    }
    public int lengthAfterTransformations(String s, int t) {
        int[] nums = new int[26];
        for (char ch : s.toCharArray()) nums[ch - 'a']++;
        while (t-- > 0) {
            int[] cur = new int[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25 && nums[j] > 0) {
                    cur[0] = mod_add(cur[0], nums[j]);
                    cur[1] = mod_add(cur[1], nums[j]);
                } else {
                    if (j < 25) cur[j + 1] = mod_add(cur[j + 1], nums[j]);
                }
            }
            nums = cur;
        }
        int ans = 0;
        for (int i : nums) ans = mod_add(ans, i);
        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abcyy", t = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>
</div>

<p><strong class="example">


