# 📌 Day 14: 966. Vowel Spellchecker 🎯

**🔗 LeetCode Link:** [966. Vowel Spellchecker](https://leetcode.com/problems/vowel-spellchecker/)

---

## 🧩 Problem Description

<p>Given a <code>wordlist</code>, we want to implement a spellchecker that converts a query word into a correct word.</p>

<p>For a given <code>query</code> word, the spell checker handles two categories of spelling mistakes:</p>

<ul>
	<li>Capitalization: If the query matches a word in the wordlist (<strong>case-insensitive</strong>), then the query word is returned with the same case as the case in the wordlist.

	<ul>
		<li>

---

## 🧠 Topics

- Array
- Hash Table
- String
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<pre><strong>Input:</strong> wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
<strong>Output:</strong> ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
</pre><p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<pre><strong>Input:</strong> wordlist = ["yellow"], queries = ["YellOw"]
<strong>Output:</strong> ["yellow"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= wordlist.length, queries.length &lt;= 5000</code></li>
	<li><code>1 &lt;= wordlist[i].length, queries[i].length &lt;= 7</code></li>
	<li><code>wordlist[i]</code> and <code>queries[i]</code> consist only of only English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String lower = toLower(w);
            String devowel = deVowel(lower);
            caseMap.putIfAbsent(lower, w);
            vowelMap.putIfAbsent(devowel, w);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                result[i] = q;
            } else {
                String lower = toLower(q);
                String devowel = deVowel(lower);
                if (caseMap.containsKey(lower)) result[i] = caseMap.get(lower);
                else if (vowelMap.containsKey(devowel)) result[i] = vowelMap.get(devowel);
                else result[i] = "";
            }
        }
        return result;
    }
    private String toLower(String s) {
        return s.toLowerCase();
    }
    private String deVowel(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (isVowel(ch[i])) ch[i] = '*';
        }
        return new String(ch);
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) >= 0;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<pre><strong>Input:</strong> wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
<strong>Output:</strong> ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
</pre><p><strong class="example">


