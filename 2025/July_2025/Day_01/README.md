# 📌 Day 1: 3330. Find the Original Typed String I 🎯

**🔗 LeetCode Link:** [3330. Find the Original Typed String I](https://leetcode.com/problems/find-the-original-typed-string-i/)

---

## 🧩 Problem Description

<p>Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and <strong>may</strong> press a key for too long, resulting in a character being typed <strong>multiple</strong> times.</p>

<p>Although Alice tried to focus on her typing, she is aware that she may still have done this <strong>at most</strong> <em>once</em>.</p>

<p>You are given a string <code>word</code>, which represents the <strong>final</strong> output displayed on Alice&#39;s screen.</p>

<p>Return the total number of <em>possible</em> original strings that Alice <em>might</em> have intended to type.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;abbcccc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p>The possible strings are: <code>&quot;abbcccc&quot;</code>, <code>&quot;abbccc&quot;</code>, <code>&quot;abbcc&quot;</code>, <code>&quot;abbc&quot;</code>, and <code>&quot;abcccc&quot;</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;abcd&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The only possible string is <code>&quot;abcd&quot;</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;aaaa&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 100</code></li>
	<li><code>word</code> consists only of lowercase English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int possibleStringCount(String word) {
        int n=word.length();
        int count=n;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(i-1)){
                count--;
            }
        }
        return count;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;abbcccc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

</div>

<p><strong class="example">


