# 📌 Day 2: 2561. Rearranging Fruits 🎯

**🔗 LeetCode Link:** [2561. Rearranging Fruits](https://leetcode.com/problems/rearranging-fruits/)

---

## 🧩 Problem Description

<p>You have two fruit baskets containing <code>n</code> fruits each. You are given two <strong>0-indexed</strong> integer arrays <code>basket1</code> and <code>basket2</code> representing the cost of fruit in each basket. You want to make both baskets <strong>equal</strong>. To do so, you can use the following operation as many times as you want:</p>

<ul>
	<li>Chose two indices <code>i</code> and <code>j</code>, and swap the <code>i<font size="1">th</font>&nbsp;</code>fruit of <code>basket1</code> with the <code>j<font size="1">th</font></code>&nbsp;fruit of <code>basket2</code>.</li>
	<li>The cost of the swap is <code>min(basket1[i],basket2[j])</code>.</li>
</ul>

<p>Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.</p>

<p>Return <em>the minimum cost to make both the baskets equal or </em><code>-1</code><em> if impossible.</em></p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Greedy
- Sort
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> basket1 = [4,2,2,2], basket2 = [1,4,1,2]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> basket1 = [2,3,4,1], basket2 = [3,2,5,1]
<strong>Output:</strong> -1
<strong>Explanation:</strong> It can be shown that it is impossible to make both the baskets equal.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>basket1.length == basket2.length</code></li>
	<li><code>1 &lt;= basket1.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= basket1[i],basket2[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public long minCost(final int[] basket1, final int[] basket2) {
        final int n = basket1.length;
        final Map<Integer, Integer> counts = new HashMap<>();

        for(int i = 0; i < n; ++i)
            counts.put(basket1[i], counts.getOrDefault(basket1[i], 0) + 1);

        for(int i = 0; i < n; ++i)
            counts.put(basket2[i], counts.getOrDefault(basket2[i], 0) - 1);

        final List<Integer> swaps = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for(final Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            final int num = entry.getKey(), count = entry.getValue();

            if(count % 2 > 0)
                return -1;

            min = Math.min(num, min);

            for(int i = 0; i < Math.abs(count) / 2; ++i)
                swaps.add(num);
        }

        Collections.sort(swaps);

        long result = 0;

        for(int i = 0; i < swaps.size() / 2; ++i)
            result += Math.min(swaps.get(i), min * 2);

        return result;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> basket1 = [4,2,2,2], basket2 = [1,4,1,2]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">


