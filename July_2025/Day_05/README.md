# 📌 Day 5: 1394. Find Lucky Integer in an Array 🎯

**🔗 LeetCode Link:** [1394. Find Lucky Integer in an Array](https://leetcode.com/problems/find-lucky-integer-in-an-array/)

---

## 🧩 Problem Description

<p>Given an array of integers <code>arr</code>, a <strong>lucky integer</strong> is an integer that has a frequency in the array equal to its value.</p>

<p>Return <em>the largest <strong>lucky integer</strong> in the array</em>. If there is no <strong>lucky integer</strong> return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Counting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,2,3,4]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The only lucky number in the array is 2 because frequency[2] == 2.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,2,3,3,3]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 1, 2 and 3 are all lucky numbers, return the largest of them.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,2,2,3,3]
<strong>Output:</strong> -1
<strong>Explanation:</strong> There are no lucky numbers in the array.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 500</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 500</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;

        // Check if number == its frequency
        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                max = Math.max(max, key);
            }
        }

        return max;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,2,3,4]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">


