# 📌 Day 12: 3539. Find Sum of Array Product of Magical Sequences 🎯

**🔗 LeetCode Link:** [3539. Find Sum of Array Product of Magical Sequences](https://leetcode.com/problems/find-sum-of-array-product-of-magical-sequences/)

---

## 🧩 Problem Description

<p>You are given two integers, <code>m</code> and <code>k</code>, and an integer array <code>nums</code>.</p>
A sequence of integers <code>seq</code> is called <strong>magical</strong> if:

<ul>
	<li><code>seq</code> has a size of <code>m</code>.</li>
	<li><code>0 &lt;= seq[i] &lt; nums.length</code></li>
	<li>The <strong>binary representation</strong> of <code>2<sup>seq[0]</sup> + 2<sup>seq[1]</sup> + ... + 2<sup>seq[m - 1]</sup></code> has <code>k</code> <strong>set bits</strong>.</li>
</ul>

<p>The <strong>array product</strong> of this sequence is defined as <code>prod(seq) = (nums[seq[0]] * nums[seq[1]] * ... * nums[seq[m - 1]])</code>.</p>

<p>Return the <strong>sum</strong> of the <strong>array products</strong> for all valid <strong>magical</strong> sequences.</p>

<p>Since the answer may be large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>A <strong>set bit</strong> refers to a bit in the binary representation of a number that has a value of 1.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
- Dynamic Programming
- Bit Manipulation
- Combinatorics
- Bitmask
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">m = 5, k = 5, nums = [1,10,100,10000,1000000]</span></p>

<p><strong>Output:</strong> <span class="example-io">991600007</span></p>

<p><strong>Explanation:</strong></p>

<p>All permutations of <code>[0, 1, 2, 3, 4]</code> are magical sequences, each with an array product of 10<sup>13</sup>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">m = 2, k = 2, nums = [5,4,3,2,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">170</span></p>

<p><strong>Explanation:</strong></p>

<p>The magical sequences are <code>[0, 1]</code>, <code>[0, 2]</code>, <code>[0, 3]</code>, <code>[0, 4]</code>, <code>[1, 0]</code>, <code>[1, 2]</code>, <code>[1, 3]</code>, <code>[1, 4]</code>, <code>[2, 0]</code>, <code>[2, 1]</code>, <code>[2, 3]</code>, <code>[2, 4]</code>, <code>[3, 0]</code>, <code>[3, 1]</code>, <code>[3, 2]</code>, <code>[3, 4]</code>, <code>[4, 0]</code>, <code>[4, 1]</code>, <code>[4, 2]</code>, and <code>[4, 3]</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">m = 1, k = 1, nums = [28]</span></p>

<p><strong>Output:</strong> <span class="example-io">28</span></p>

<p><strong>Explanation:</strong></p>

<p>The only magical sequence is <code>[0]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= m &lt;= 30</code></li>
	<li><code>1 &lt;= nums.length &lt;= 50</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>8</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    static final int MOD = 1_000_000_007, MAX = 31;
    static final long[] FACT = new long[MAX], INV_FACT = new long[MAX];

    static {
        FACT[0] = 1;
        for (int i = 1; i < MAX; i++) FACT[i] = FACT[i - 1] * i % MOD;
        INV_FACT[MAX - 1] = pow(FACT[MAX - 1], MOD - 2);
        for (int i = MAX - 1; i > 0; i--) INV_FACT[i - 1] = INV_FACT[i] * i % MOD;
    }

    static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n >>= 1, x = x * x % MOD)
            if ((n & 1) == 1) res = res * x % MOD;
        return res;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int[][] pows = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            pows[i][0] = 1;
            for (int j = 1; j <= m; j++)
                pows[i][j] = (int) ((long) pows[i][j - 1] * nums[i] % MOD);
        }

        int[][][][] memo = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : memo)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);

        return (int) (dfs(0, m, 0, k, pows, memo) * FACT[m] % MOD);
    }

    long dfs(int i, int mLeft, int carry, int kLeft, int[][] pows, int[][][][] memo) {
        int ones = Integer.bitCount(carry);
        if (ones + mLeft < kLeft) return 0; // agar baaki bits se k banana possible nahi toh return 0
        if (i == pows.length) return (mLeft == 0 && ones == kLeft) ? 1 : 0; // base case check
        if (memo[i][mLeft][carry][kLeft] != -1) return memo[i][mLeft][carry][kLeft]; // memo use karo

        long res = 0;
        for (int j = 0; j <= mLeft; j++) {
            int bit = (carry + j) & 1; // current bit nikala (odd/even)
            if (bit <= kLeft) { // agar bit useful hai
                long r = dfs(i + 1, mLeft - j, (carry + j) >> 1, kLeft - bit, pows, memo);
                res = (res + r * pows[i][j] % MOD * INV_FACT[j]) % MOD; // result add karo
            }
        }
        return memo[i][mLeft][carry][kLeft] = (int) res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">m = 5, k = 5, nums = [1,10,100,10000,1000000]</span></p>

<p><strong>Output:</strong> <span class="example-io">991600007</span></p>

<p><strong>Explanation:</strong></p>

<p>All permutations of <code>[0, 1, 2, 3, 4]</code> are magical sequences, each with an array product of 10<sup>13</sup>.</p>
</div>

<p><strong class="example">


