# 📌 Day 5: 3321. Find X-Sum of All K-Long Subarrays II 🎯

**🔗 LeetCode Link:** [3321. Find X-Sum of All K-Long Subarrays II](https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/)

---

## 🧩 Problem Description

<p>You are given an array <code>nums</code> of <code>n</code> integers and two integers <code>k</code> and <code>x</code>.</p>

<p>The <strong>x-sum</strong> of an array is calculated by the following procedure:</p>

<ul>
	<li>Count the occurrences of all elements in the array.</li>
	<li>Keep only the occurrences of the top <code>x</code> most frequent elements. If two elements have the same number of occurrences, the element with the <strong>bigger</strong> value is considered more frequent.</li>
	<li>Calculate the sum of the resulting array.</li>
</ul>

<p><strong>Note</strong> that if an array has less than <code>x</code> distinct elements, its <strong>x-sum</strong> is the sum of the array.</p>

<p>Return an integer array <code>answer</code> of length <code>n - k + 1</code> where <code>answer[i]</code> is the <strong>x-sum</strong> of the <span data-keyword="subarray-nonempty">subarray</span> <code>nums[i..i + k - 1]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Sliding Window
- Heap (Priority Queue)
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,2,2,3,4,2,3], k = 6, x = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[6,10,12]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>For subarray <code>[1, 1, 2, 2, 3, 4]</code>, only elements 1 and 2 will be kept in the resulting array. Hence, <code>answer[0] = 1 + 1 + 2 + 2</code>.</li>
	<li>For subarray <code>[1, 2, 2, 3, 4, 2]</code>, only elements 2 and 4 will be kept in the resulting array. Hence, <code>answer[1] = 2 + 2 + 2 + 4</code>. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.</li>
	<li>For subarray <code>[2, 2, 3, 4, 2, 3]</code>, only elements 2 and 3 are kept in the resulting array. Hence, <code>answer[2] = 2 + 2 + 2 + 3 + 3</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,8,7,8,7,5], k = 2, x = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[11,15,15,15,12]</span></p>

<p><strong>Explanation:</strong></p>

<p>Since <code>k == x</code>, <code>answer[i]</code> is equal to the sum of the subarray <code>nums[i..i + k - 1]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums.length == n</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= x &lt;= k &lt;= nums.length</code></li>
</ul>

---

## ✅ Code (Java)

```java
public class Solution {
    class Element {
        int value;
        int freq;
        Element(int value, int freq) { this.value = value; this.freq = freq; }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            Element other = (Element) obj;
            return this.value == other.value && this.freq == other.freq;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, freq);
        }
    }

    private final Comparator<Element> comp = (a, b) -> {
        if (a.freq != b.freq) return Integer.compare(b.freq, a.freq);
        if (a.value != b.value) return Integer.compare(b.value, a.value);
        return 0;
    };

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        TreeSet<Element> xset = new TreeSet<>(comp);   // top-x elements, size is always x
        TreeSet<Element> remset = new TreeSet<>(comp); 
        long[] ans = new long[n - k + 1];
        long xsum = 0; // running sum 
        int idx = 0;

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            int prevFreq = hmap.getOrDefault(num, 0);
            // [1,1,2,2,3,4,2,3]
            if (prevFreq > 0) {
                Element old = new Element(num, prevFreq);
                if (xset.contains(old)) {
                    xsum -= (long) old.value * old.freq;
                    xset.remove(old);
                } else {
                    remset.remove(old);
                }
            }
            // [1,1,2,2,3,4,2,3]
            int newFreq = prevFreq + 1;
            hmap.put(num, newFreq);
            Element added = new Element(num, newFreq);
            xset.add(added);
            xsum += (long) added.value * added.freq;

            if (xset.size() > x) {
                Element last = xset.last(); // lowest among top-x
                xsum -= (long) last.value * last.freq;
                xset.remove(last);
                remset.add(last);
            }
             // [1,1,2,2,3,4,2,3]
            if (i >= k) {
                int out = nums[i - k];
                int freqOut = hmap.get(out);
                Element outElem = new Element(out, freqOut);

                if (xset.contains(outElem)) {
                    xsum -= (long) outElem.value * outElem.freq;
                    xset.remove(outElem);
                } else {
                    remset.remove(outElem);
                }

                if (freqOut == 1) {
                    hmap.remove(out);
                } else {
                    int reduced = freqOut - 1;
                    hmap.put(out, reduced);
                    remset.add(new Element(out, reduced));
                }

                while (xset.size() < x && !remset.isEmpty()) {
                    Element promote = remset.first();
                    remset.remove(promote);
                    xset.add(promote);
                    xsum += (long) promote.value * promote.freq;
                }
            }

            if (i >= k - 1) {
                ans[idx++] = xsum;
            }
        }

        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,2,2,3,4,2,3], k = 6, x = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[6,10,12]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>For subarray <code>[1, 1, 2, 2, 3, 4]</code>, only elements 1 and 2 will be kept in the resulting array. Hence, <code>answer[0] = 1 + 1 + 2 + 2</code>.</li>
	<li>For subarray <code>[1, 2, 2, 3, 4, 2]</code>, only elements 2 and 4 will be kept in the resulting array. Hence, <code>answer[1] = 2 + 2 + 2 + 4</code>. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.</li>
	<li>For subarray <code>[2, 2, 3, 4, 2, 3]</code>, only elements 2 and 3 are kept in the resulting array. Hence, <code>answer[2] = 2 + 2 + 2 + 3 + 3</code>.</li>
</ul>
</div>

<p><strong class="example">


