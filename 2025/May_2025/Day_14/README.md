# 📌 Day 14: 3337. Total Characters in String After Transformations II 🎯

**🔗 LeetCode Link:** [3337. Total Characters in String After Transformations II](https://leetcode.com/problems/total-characters-in-string-after-transformations-ii/description/)

---

## 🧩 Problem Description

<p>You are given a string <code>s</code> consisting of lowercase English letters, an integer <code>t</code> representing the number of <strong>transformations</strong> to perform, and an array <code>nums</code> of size 26. In one <strong>transformation</strong>, every character in <code>s</code> is replaced according to the following rules:</p>

<ul>
	<li>Replace <code>s[i]</code> with the <strong>next</strong> <code>nums[s[i] - 'a']</code> consecutive characters in the alphabet. For example, if <code>s[i] = 'a'</code> and <code>nums[0] = 3</code>, the character <code>'a'</code> transforms into the next 3 consecutive characters ahead of it, which results in <code>"bcd"</code>.</li>
	<li>The transformation <strong>wraps</strong> around the alphabet if it exceeds <code>'z'</code>. For example, if <code>s[i] = 'y'</code> and <code>nums[24] = 3</code>, the character <code>'y'</code> transforms into the next 3 consecutive characters ahead of it, which results in <code>"zab"</code>.</li>
</ul>

<p>Return the length of the resulting string after <strong>exactly</strong> <code>t</code> transformations.</p>

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
<p><strong>Input:</strong> <span class="example-io">s = "abcyy", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>
	<p><strong>First Transformation (t = 1):</strong></p>
	<ul>
		<li><code>'a'</code> becomes <code>'b'</code> as <code>nums[0] == 1</code></li>
		<li><code>'b'</code> becomes <code>'c'</code> as <code>nums[1] == 1</code></li>
		<li><code>'c'</code> becomes <code>'d'</code> as <code>nums[2] == 1</code></li>
		<li><code>'y'</code> becomes <code>'z'</code> as <code>nums[24] == 1</code></li>
		<li><code>'y'</code> becomes <code>'z'</code> as <code>nums[24] == 1</code></li>
		<li>String after the first transformation: <code>"bcdzz"</code></li>
	</ul>
	</li>
	<li>
	<p><strong>Second Transformation (t = 2):</strong></p>
	<ul>
		<li><code>'b'</code> becomes <code>'c'</code> as <code>nums[1] == 1</code></li>
		<li><code>'c'</code> becomes <code>'d'</code> as <code>nums[2] == 1</code></li>
		<li><code>'d'</code> becomes <code>'e'</code> as <code>nums[3] == 1</code></li>
		<li><code>'z'</code> becomes <code>'ab'</code> as <code>nums[25] == 2</code></li>
		<li><code>'z'</code> becomes <code>'ab'</code> as <code>nums[25] == 2</code></li>
		<li>String after the second transformation: <code>"cdeabab"</code></li>
	</ul>
	</li>
	<li>
	<p><strong>Final Length of the string:</strong> The string is <code>"cdeabab"</code>, which has 7 characters.</p>
	</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "azbk", t = 1, nums = [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">8</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>
	<p><strong>First Transformation (t = 1):</strong></p>
	<ul>
		<li><code>'a'</code> becomes <code>'bc'</code> as <code>nums[0] == 2</code></li>
		<li><code>'z'</code> becomes <code>'ab'</code> as <code>nums[25] == 2</code></li>
		<li><code>'b'</code> becomes <code>'cd'</code> as <code>nums[1] == 2</code></li>
		<li><code>'k'</code> becomes <code>'lm'</code> as <code>nums[10] == 2</code></li>
		<li>String after the first transformation: <code>"bcabcdlm"</code></li>
	</ul>
	</li>
	<li>
	<p><strong>Final Length of the string:</strong> The string is <code>"bcabcdlm"</code>, which has 8 characters.</p>
	</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
	<li><code>1 &lt;= t &lt;= 10<sup>9</sup></code></li>
	<li><code><font face="monospace">nums.length == 26</font></code></li>
	<li><code><font face="monospace">1 &lt;= nums[i] &lt;= 25</font></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    private static final int K = 26;
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] freq = new long[K];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        long[][] base = new long[K][K];
        for (int i = 0; i < K; i++) {
            int steps = nums.get(i);
            for (int k = 1; k <= steps; k++) {
                base[i][(i + k) % K]++;
            }
        }
        long[][] mt = matrixPower(base, t);
        long ans = 0;
        for (int i = 0; i < K; i++) {
            long fi = freq[i];
            if (fi == 0) continue;
            for (int j = 0; j < K; j++) {
                ans = (ans + fi * mt[i][j]) % MOD;
            }
        }

        return (int)ans;
    }

    private long[][] matrixPower(long[][] M, int exp) {
        long[][] res = new long[K][K];
        for (int i = 0; i < K; i++) {
            res[i][i] = 1;
        }
        long[][] base = M;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return res;
    }
    private long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[K][K];
        for (int i = 0; i < K; i++) {
            for (int k = 0; k < K; k++) {
                long aik = A[i][k];
                if (aik == 0) continue;
                for (int j = 0; j < K; j++) {
                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abcyy", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]</span></p>
<p><strong>Output:</strong> <span class="example-io">7</span></p>
</div>

<p><strong class="example">


