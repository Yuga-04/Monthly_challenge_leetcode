# 📌 Day 16: 2901. Longest Unequal Adjacent Groups Subsequence II 🎯

**🔗 LeetCode Link:** [2901. Longest Unequal Adjacent Groups Subsequence II](https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/description/)

---

## 🧩 Problem Description

<p>You are given a string array <code>words</code>, and an array <code>groups</code>, both arrays having length <code>n</code>.</p>

<p>The <strong>hamming distance</strong> between two strings of equal length is the number of positions at which the corresponding characters are <strong>different</strong>.</p>

<p>You need to select the <strong>longest</strong> <span data-keyword="subsequence-array" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-:rn:" data-state="closed" class="">subsequence</button></span> from an array of indices <code>[0, 1, ..., n - 1]</code>, such that for the subsequence denoted as <code>[i<sub>0</sub>, i<sub>1</sub>, ..., i<sub>k-1</sub>]</code> having length <code>k</code>, the following holds:</p>

<ul>
	<li>For <strong>adjacent</strong> indices in the subsequence, their corresponding groups are <strong>unequal</strong>, i.e., <code>groups[i<sub>j</sub>] != groups[i<sub>j+1</sub>]</code>, for each <code>j</code> where <code>0 &lt; j + 1 &lt; k</code>.</li>
	<li><code>words[i<sub>j</sub>]</code> and <code>words[i<sub>j+1</sub>]</code> are <strong>equal</strong> in length, and the <strong>hamming distance</strong> between them is <code>1</code>, where <code>0 &lt; j + 1 &lt; k</code>, for all indices in the subsequence.</li>
</ul>

<p>Return <em>a string array containing the words corresponding to the indices <strong>(in order)</strong> in the selected subsequence</em>. If there are multiple answers, return <em>any of them</em>.</p>

<p><strong>Note:</strong> strings in <code>words</code> may be <strong>unequal</strong> in length.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- String
- Dynamic Programming
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong><span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">words = ["bab","dab","cab"], groups = [1,2,2]</span></p>

<p><strong>Output: </strong><span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">["bab","cab"]</span></p>

<p><strong>Explanation: </strong>A subsequence that can be selected is <code>[0,2]</code>.</p>

<ul>
	<li><code>groups[0] != groups[2]</code></li>
	<li><code>words[0].length == words[2].length</code>, and the hamming distance between them is 1.</li>
</ul>

<p>So, a valid answer is <code>[words[0],words[2]] = ["bab","cab"]</code>.</p>

<p>Another subsequence that can be selected is <code>[0,1]</code>.</p>

<ul>
	<li><code>groups[0] != groups[1]</code></li>
	<li><code>words[0].length == words[1].length</code>, and the hamming distance between them is <code>1</code>.</li>
</ul>

<p>So, another valid answer is <code>[words[0],words[1]] = ["bab","dab"]</code>.</p>

<p>It can be shown that the length of the longest subsequence of indices that satisfies the conditions is <code>2</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong><span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">words = ["a","b","c","d"], groups = [1,2,3,4]</span></p>

<p><strong>Output: </strong><span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">["a","b","c","d"]</span></p>

<p><strong>Explanation: </strong>We can select the subsequence <code>[0,1,2,3]</code>.</p>

<p>It satisfies both conditions.</p>

<p>Hence, the answer is <code>[words[0],words[1],words[2],words[3]] = ["a","b","c","d"]</code>.</p>

<p>It has the longest length among all subsequences of indices that satisfy the conditions.</p>

<p>Hence, it is the only answer.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == words.length == groups.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 10</code></li>
	<li><code>1 &lt;= groups[i] &lt;= n</code></li>
	<li><code>words</code> consists of <strong>distinct</strong> strings.</li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] next = new int[n], dp = new int[n];
        Arrays.fill(next, n);

        Map<Long, List<Integer>> maskMap = new HashMap<>();
        int bestStart = 0;

        for (int i = n - 1; i >= 0; i--) {
            char[] word = words[i].toCharArray();
            int len = word.length;
            long fullMask = 0;
            long[] charMasks = new long[len];
            
            for (int j = 0; j < len; j++) {
                long shift = (word[j] - 'a' + 1L) << (5 * j);
                charMasks[j] = shift;
                fullMask |= shift;
            }

            int maxLen = 1;
            int nextIndex = n;

            for (int j = 0; j < len; j++) {
                long alteredMask = fullMask ^ charMasks[j];
                List<Integer> candidates = maskMap.get(alteredMask);
                if (candidates == null) continue;

                for (int idx : candidates) {
                    if (groups[i] != groups[idx] && dp[idx] + 1 > maxLen) {
                        maxLen = dp[idx] + 1;
                        nextIndex = idx;
                    }
                }
            }

            dp[i] = maxLen;
            next[i] = nextIndex;
            if (dp[i] > dp[bestStart]) bestStart = i;

            // Insert current word into map
            for (int j = 0; j < len; j++) {
                long alteredMask = fullMask ^ charMasks[j];
                maskMap.computeIfAbsent(alteredMask, k -> new ArrayList<>()).add(i);
            }
        }

        List<String> result = new ArrayList<>(dp[bestStart]);
        for (int i = bestStart; i < n; i = next[i]) {
            result.add(words[i]);
        }

        return result;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong><span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">words = ["bab","dab","cab"], groups = [1,2,2]</span></p>

<p><strong>Output: </strong><span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">["bab","cab"]</span></p>
</div>

<p><strong class="example">


