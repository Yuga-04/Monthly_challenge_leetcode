# 📌 Day 23: 2081. Sum of k-Mirror Numbers 🎯

**🔗 LeetCode Link:** [2081. Sum of k-Mirror Numbers](https://leetcode.com/problems/sum-of-k-mirror-numbers/)

---

## 🧩 Problem Description

<p>A <strong>k-mirror number</strong> is a <strong>positive</strong> integer <strong>without leading zeros</strong> that reads the same both forward and backward in base-10 <strong>as well as</strong> in base-k.</p>

<ul>
	<li>For example, <code>9</code> is a 2-mirror number. The representation of <code>9</code> in base-10 and base-2 are <code>9</code> and <code>1001</code> respectively, which read the same both forward and backward.</li>
	<li>On the contrary, <code>4</code> is not a 2-mirror number. The representation of <code>4</code> in base-2 is <code>100</code>, which does not read the same both forward and backward.</li>
</ul>

<p>Given the base <code>k</code> and the number <code>n</code>, return <em>the <strong>sum</strong> of the</em> <code>n</code> <em><strong>smallest</strong> k-mirror numbers</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Enumeration
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 2, n = 5
<strong>Output:</strong> 25
<strong>Explanation:
</strong>The 5 smallest 2-mirror numbers and their representations in base-2 are listed as follows:
  base-10    base-2
    1          1
    3          11
    5          101
    7          111
    9          1001
Their sum = 1 + 3 + 5 + 7 + 9 = 25. 
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> k = 3, n = 7
<strong>Output:</strong> 499
<strong>Explanation:
</strong>The 7 smallest 3-mirror numbers are and their representations in base-3 are listed as follows:
  base-10    base-3
    1          1
    2          2
    4          11
    8          22
    121        11111
    151        12121
    212        21212
Their sum = 1 + 2 + 4 + 8 + 121 + 151 + 212 = 499.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> k = 7, n = 17
<strong>Output:</strong> 20379000
<strong>Explanation:</strong> The 17 smallest 7-mirror numbers are:
1, 2, 3, 4, 5, 6, 8, 121, 171, 242, 292, 16561, 65656, 2137312, 4602064, 6597956, 6958596
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= k &lt;= 9</code></li>
	<li><code>1 &lt;= n &lt;= 30</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public long kMirror(int k, int n) {
        // Step 1: Initialize sum
        long sum = 0;

        // Step 1: Initialize counter
        int found = 0;

        // Step 2: Loop over increasing decimal palindrome lengths
        for (int len = 1; found < n; len++) {
            int start = (int) Math.pow(10, (len - 1) / 2); // Start of half
            int end = (int) Math.pow(10, (len + 1) / 2); // End of half

            // Step 3: Generate decimal palindromes using half and mirroring
            for (int half = start; half < end; half++) {
                long pal = createPalindrome(half, len % 2 == 1); // Step 3

                // Step 4: Check if the number is also a base-k palindrome
                if (isBaseKPalindrome(pal, k)) {
                    // Step 5: Add to sum
                    sum += pal;

                    // Step 5: Increment count
                    found++;

                    // Step 6: If enough numbers found, return
                    if (found == n) {
                        return sum;
                    }
                }
            }
        }

        return sum; // Final return
    }

    // Step 3 helper: Create full decimal palindrome from half
    private long createPalindrome(int half, boolean odd) {
        long pal = half;
        if (odd) {
            half /= 10; // Drop last digit for odd-length palindromes
        }

        while (half > 0) {
            pal = pal * 10 + (half % 10); // Mirror digit
            half /= 10;
        }

        return pal;
    }

    // Step 4 helper: Check if number is palindrome in base-k
    private boolean isBaseKPalindrome(long num, int k) {
        long rev = 0;
        long orig = num;
        while (num > 0) {
            rev = rev * k + (num % k); // Reconstruct reverse of base-k
            num /= k;
        }

        return rev == orig;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 2, n = 5
<strong>Output:</strong> 25
</pre>

<p><strong class="example">


