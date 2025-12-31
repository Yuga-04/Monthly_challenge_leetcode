# 📌 Day 21: 3085. Minimum Deletions to Make String K-Special 🎯

**🔗 LeetCode Link:** [3085. Minimum Deletions to Make String K-Special](https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/)

---

## 🧩 Problem Description

<p>You are given a string <code>word</code> and an integer <code>k</code>.</p>

<p>We consider <code>word</code> to be <strong>k-special</strong> if <code>|freq(word[i]) - freq(word[j])| &lt;= k</code> for all indices <code>i</code> and <code>j</code> in the string.</p>

<p>Here, <code>freq(x)</code> denotes the <span data-keyword="frequency-letter">frequency</span> of the character <code>x</code> in <code>word</code>, and <code>|y|</code> denotes the absolute value of <code>y</code>.</p>

<p>Return <em>the <strong>minimum</strong> number of characters you need to delete to make</em> <code>word</code> <strong><em>k-special</em></strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Hash Table
- String
- Greedy
- Sorting
- Counting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: .875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong><span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;">word = &quot;aabcaba&quot;, k = 0</span></p>

<p><strong>Output: </strong><span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;">3</span></p>

<p><strong>Explanation:</strong> We can make <code>word</code> <code>0</code>-special by deleting <code>2</code> occurrences of <code>&quot;a&quot;</code> and <code>1</code> occurrence of <code>&quot;c&quot;</code>. Therefore, <code>word</code> becomes equal to <code>&quot;baba&quot;</code> where <code>freq(&#39;a&#39;) == freq(&#39;b&#39;) == 2</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: .875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong><span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;">word = &quot;dabdcbdcdcd&quot;, k = 2</span></p>

<p><strong>Output: </strong><span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;">2</span></p>

<p><strong>Explanation:</strong> We can make <code>word</code> <code>2</code>-special by deleting <code>1</code> occurrence of <code>&quot;a&quot;</code> and <code>1</code> occurrence of <code>&quot;d&quot;</code>. Therefore, <code>word</code> becomes equal to &quot;bdcbdcdcd&quot; where <code>freq(&#39;b&#39;) == 2</code>, <code>freq(&#39;c&#39;) == 3</code>, and <code>freq(&#39;d&#39;) == 4</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: .875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong><span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;">word = &quot;aaabaaa&quot;, k = 2</span></p>

<p><strong>Output: </strong><span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;">1</span></p>

<p><strong>Explanation:</strong> We can make <code>word</code> <code>2</code>-special by deleting <code>1</code> occurrence of <code>&quot;b&quot;</code>. Therefore, <code>word</code> becomes equal to <code>&quot;aaaaaa&quot;</code> where each letter&#39;s frequency is now uniformly <code>6</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li>
	<li><code>word</code> consists only of lowercase English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int minimumDeletions(String word, int k) {
         Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Collect frequencies and sort them
        List<Integer> frequencies = new ArrayList<>(freqMap.values());
        Collections.sort(frequencies);
        
        int minDeletions = Integer.MAX_VALUE;
        int n = frequencies.size();
        
        // Step 3: For each frequency, consider it as the base and calculate deletions
        for (int i = 0; i < n; i++) {
            int base = frequencies.get(i);
            int totalDeletions = 0;
            
            // For frequencies less than base, delete all occurrences (since we can't increase frequencies)
            for (int j = 0; j < i; j++) {
                totalDeletions += frequencies.get(j);
            }
            
            // For frequencies greater than base + k, reduce them to base + k
            for (int j = i; j < n; j++) {
                if (frequencies.get(j) > base + k) {
                    totalDeletions += frequencies.get(j) - (base + k);
                }
            }
            
            if (totalDeletions < minDeletions) {
                minDeletions = totalDeletions;
            }
        }
        
        return minDeletions;
        
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: .875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong><span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;">word = &quot;aabcaba&quot;, k = 0</span></p>

<p><strong>Output: </strong><span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;">3</span></p>

</div>

<p><strong class="example">


