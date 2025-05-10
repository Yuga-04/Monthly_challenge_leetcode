# 📌 Day 5: 790. Domino and Tromino Tiling

**LeetCode Link:** [790. Domino and Tromino Tiling](https://leetcode.com/problems/domino-and-tromino-tiling/description/)

---

## 🧩 Problem

You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

<img src="https://assets.leetcode.com/uploads/2021/07/15/lc-domino.jpg" alt="Image">

Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

### Example:

<img src="https://assets.leetcode.com/uploads/2021/07/15/lc-domino1.jpg" alt="photo">

```
Input:  n = 3
Output: 5
Explanation: The five different ways are show above.
```

---

## 🧠 Topics

- Dynamic Programming

---

## ✅ Code (Java)

```Java
class Solution {
    public int numTilings(int n) {
        long[] dp = new long[Math.max(4, n + 1)];
        int MOD = 1_000_000_007;
        dp[1] = 1; dp[2] = 2; dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        return (int) dp[n];
    }
}
```

---

## 🧪 Sample Test Case

```Java
Input:  n = 3
Output: 5
```

---


