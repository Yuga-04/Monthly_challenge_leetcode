# 📌 Day 9: 3129. Find All Possible Stable Binary Arrays I 🎯

**🔗 LeetCode Link:** [3129. Find All Possible Stable Binary Arrays I](https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/)

---

## 🧩 Problem Description

<p>You are given 3 positive integers <code>zero</code>, <code>one</code>, and <code>limit</code>.</p>

<p>A <span data-keyword="binary-array">binary array</span> <code>arr</code> is called <strong>stable</strong> if:</p>

<ul>
	<li>The number of occurrences of 0 in <code>arr</code> is <strong>exactly </strong><code>zero</code>.</li>
	<li>The number of occurrences of 1 in <code>arr</code> is <strong>exactly</strong> <code>one</code>.</li>
	<li>Each <span data-keyword="subarray-nonempty">subarray</span> of <code>arr</code> with a size greater than <code>limit</code> must contain <strong>both </strong>0 and 1.</li>
</ul>

<p>Return the <em>total</em> number of <strong>stable</strong> binary arrays.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Dynamic Programming
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">zero = 1, one = 1, limit = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The two possible stable binary arrays are <code>[1,0]</code> and <code>[0,1]</code>, as both arrays have a single 0 and a single 1, and no subarray has a length greater than 2.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">zero = 1, one = 2, limit = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The only possible stable binary array is <code>[1,0,1]</code>.</p>

<p>Note that the binary arrays <code>[1,1,0]</code> and <code>[0,1,1]</code> have subarrays of length 2 with identical elements, hence, they are not stable.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">zero = 3, one = 3, limit = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">14</span></p>

<p><strong>Explanation:</strong></p>

<p>All the possible stable binary arrays are <code>[0,0,1,0,1,1]</code>, <code>[0,0,1,1,0,1]</code>, <code>[0,1,0,0,1,1]</code>, <code>[0,1,0,1,0,1]</code>, <code>[0,1,0,1,1,0]</code>, <code>[0,1,1,0,0,1]</code>, <code>[0,1,1,0,1,0]</code>, <code>[1,0,0,1,0,1]</code>, <code>[1,0,0,1,1,0]</code>, <code>[1,0,1,0,0,1]</code>, <code>[1,0,1,0,1,0]</code>, <code>[1,0,1,1,0,0]</code>, <code>[1,1,0,0,1,0]</code>, and <code>[1,1,0,1,0,0]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= zero, one, limit &lt;= 200</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {

    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1000000007;
        // dp[z][o][0] -> ways where last element is 0
        // dp[z][o][1] -> ways where last element is 1
        long[][][] dp = new long[zero + 1][one + 1][2];
        // base cases: only zeros
        for(int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        // base cases: only ones
        for(int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        for(int z = 1; z <= zero; z++) {
            for(int o = 1; o <= one; o++) {
                // place 0 at the end
                dp[z][o][0] = (dp[z-1][o][0] + dp[z-1][o][1]) % MOD;

                if(z - limit - 1 >= 0) {
                    dp[z][o][0] = (dp[z][o][0] - dp[z-limit-1][o][1] + MOD) % MOD;
                }
                // place 1 at the end
                dp[z][o][1] = (dp[z][o-1][0] + dp[z][o-1][1]) % MOD;

                if(o - limit - 1 >= 0) {
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o-limit-1][0] + MOD) % MOD;
                }
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">zero = 1, one = 1, limit = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The two possible stable binary arrays are <code>[1,0]</code> and <code>[0,1]</code>, as both arrays have a single 0 and a single 1, and no subarray has a length greater than 2.</p>
</div>

<p><strong class="example">


