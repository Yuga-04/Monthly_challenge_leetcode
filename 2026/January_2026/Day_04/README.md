# 📌 Day 4: 1390. Four Divisors 🎯

**🔗 LeetCode Link:** [1390. Four Divisors](https://leetcode.com/problems/four-divisors/)

---

## 🧩 Problem Description

<p>Given an integer array <code>nums</code>, return <em>the sum of divisors of the integers in that array that have exactly four divisors</em>. If there is no such integer in the array, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [21,4,7]
<strong>Output:</strong> 32
<strong>Explanation:</strong> 
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [21,21]
<strong>Output:</strong> 64
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,5]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for (int x : nums) {
            // Check p^3
            int p = (int) Math.round(Math.cbrt(x));
            if ((long)p * p * p == x && isPrime(p)) {
                total += 1 + p + p*p + x;
                continue;
            }

            // Check p * q
            boolean found = false;
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    int j = x / i;
                    if (i != j && isPrime(i) && isPrime(j)) {
                        total += 1 + i + j + x;
                    }
                    found = true;
                    break; // only need the first factor
                }
            }
            // if no factor found -> x is prime, skip
        }
        return total;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [21,4,7]
<strong>Output:</strong> 32
<strong>Explanation:</strong> 
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.
</pre>

<p><strong class="example">


