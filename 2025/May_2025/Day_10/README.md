# 📌 Day 10: 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros 🎯

**🔗 LeetCode Link:** [2918. Minimum Equal Sum of Two Arrays After Replacing Zeros](https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/)

---

## 🧩 Problem Description

<p>You are given two arrays <code>nums1</code> and <code>nums2</code> consisting of positive integers.</p>

<p>You have to replace <strong>all</strong> the <code>0</code>'s in both arrays with <strong>strictly</strong> positive integers such that the sum of elements of both arrays becomes <strong>equal</strong>.</p>

<p>Return <em>the <strong>minimum</strong> equal sum you can obtain, or </em><code>-1</code><em> if it is impossible</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Greedy
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [3,2,0,1,0], nums2 = [6,5,0]
<strong>Output:</strong> 12
<strong>Explanation:</strong> We can replace 0's in the following way:
- Replace the two 0's in nums1 with the values 2 and 4. The resulting array is nums1 = [3,2,2,1,4].
- Replace the 0 in nums2 with the value 1. The resulting array is nums2 = [6,5,1].
Both arrays have an equal sum of 12. It can be shown that it is the minimum sum we can obtain.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [2,0,2,0], nums2 = [1,4]
<strong>Output:</strong> -1
<strong>Explanation:</strong> It is impossible to make the sum of both arrays equal.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m = nums2.length;
        long nsum=0; int nzeroes=0;
        long msum=0; int mzeroes=0;
        for(int i=0; i<n; i++){
            nsum+=nums1[i];
            if(nums1[i]==0){
                nzeroes++;
            }
        }
        for(int i=0; i<m; i++){
            msum+=nums2[i];
            if(nums2[i]==0){
                mzeroes++;
            }
        }
        return ((nzeroes==0 && nsum-mzeroes<msum)||(mzeroes==0 && msum-nzeroes<nsum)) ? -1 : Math.max(nzeroes+nsum, mzeroes+msum);
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [3,2,0,1,0], nums2 = [6,5,0]
<strong>Output:</strong> 12
</pre>

<p><strong class="example">


