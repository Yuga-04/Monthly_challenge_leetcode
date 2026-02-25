# 📌 Day 25: 1356. Sort Integers by The Number of 1 Bits 🎯

**🔗 LeetCode Link:** [1356. Sort Integers by The Number of 1 Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>arr</code>. Sort the integers in the array&nbsp;in ascending order by the number of <code>1</code>&#39;s&nbsp;in their binary representation and in case of two or more integers have the same number of <code>1</code>&#39;s you have to sort them in ascending order.</p>

<p>Return <em>the array after sorting it</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Bit Manipulation
- Sorting
- Counting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [0,1,2,3,4,5,6,7,8]
<strong>Output:</strong> [0,1,2,4,8,3,5,6,7]
<strong>Explantion:</strong> [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1024,512,256,128,64,32,16,8,4,2,1]
<strong>Output:</strong> [1,2,4,8,16,32,64,128,256,512,1024]
<strong>Explantion:</strong> All integers have 1 bit in the binary representation, you should just sort them in ascending order.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 500</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>4</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int[] sortByBits(int[] arr) {
        java.util.TreeMap<Integer, java.util.PriorityQueue<Integer>> bitmap = new java.util.TreeMap<>();
        
        for (int val : arr) {
            int bits = Integer.bitCount(val);
            bitmap.putIfAbsent(bits, new java.util.PriorityQueue<>());
            bitmap.get(bits).add(val);
        }
        
        int[] ans = new int[arr.length];
        int index = 0;
        
        for (int key : bitmap.keySet()) {
            java.util.PriorityQueue<Integer> pq = bitmap.get(key);
            while (!pq.isEmpty()) {
                ans[index++] = pq.poll();
            }
        }
        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [0,1,2,3,4,5,6,7,8]
<strong>Output:</strong> [0,1,2,4,8,3,5,6,7]
<strong>Explantion:</strong> [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
</pre>

<p><strong class="example">


