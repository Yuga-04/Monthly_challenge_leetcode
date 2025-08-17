# 📌 Day 17: 837. New 21 Game 🎯

**🔗 LeetCode Link:** [837. New 21 Game](https://leetcode.com/problems/new-21-game/)

---

## 🧩 Problem Description

<p>Alice plays the following game, loosely based on the card game <strong>&quot;21&quot;</strong>.</p>

<p>Alice starts with <code>0</code> points and draws numbers while she has less than <code>k</code> points. During each draw, she gains an integer number of points randomly from the range <code>[1, maxPts]</code>, where <code>maxPts</code> is an integer. Each draw is independent and the outcomes have equal probabilities.</p>

<p>Alice stops drawing numbers when she gets <code>k</code> <strong>or more points</strong>.</p>

<p>Return the probability that Alice has <code>n</code> or fewer points.</p>

<p>Answers within <code>10<sup>-5</sup></code> of the actual answer are considered accepted.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Dynamic Programming
- Sliding Window
- Probability and Statistics
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10, k = 1, maxPts = 10
<strong>Output:</strong> 1.00000
<strong>Explanation:</strong> Alice gets a single card, then stops.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 6, k = 1, maxPts = 10
<strong>Output:</strong> 0.60000
<strong>Explanation:</strong> Alice gets a single card, then stops.
In 6 out of 10 possibilities, she is at or below 6 points.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 21, k = 17, maxPts = 10
<strong>Output:</strong> 0.73278
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= k &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= maxPts &lt;= 10<sup>4</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public double new21Game(int N, int K, int maxPts) {
        if (K == 0 || N >= K - 1 + maxPts)
            return 1.0;

        double[] dp = new double[maxPts];
        dp[0] = 1.0;
        double windowSum = 1.0, result = 0.0;

        for (int i = 1; i <= N; i++) {
            double prob = windowSum / maxPts;

            if (i < K) {
                windowSum += prob;
            } else {
                result += prob;
            }

            if (i >= maxPts) {
                windowSum -= dp[i % maxPts];
            }

            dp[i % maxPts] = prob;
        }

        return result;
    }

}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10, k = 1, maxPts = 10
<strong>Output:</strong> 1.00000
</pre>

<p><strong class="example">


