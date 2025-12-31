# 📌 Day 23: 1717. Maximum Score From Removing Substrings 🎯

**🔗 LeetCode Link:** [1717. Maximum Score From Removing Substrings](http://leetcode.com/problems/maximum-score-from-removing-substrings/)

---

## 🧩 Problem Description

<p>You are given a string <code>s</code> and two integers <code>x</code> and <code>y</code>. You can perform two types of operations any number of times.</p>

<ul>
	<li>Remove substring <code>&quot;ab&quot;</code> and gain <code>x</code> points.

	<ul>
		<li>For example, when removing <code>&quot;ab&quot;</code> from <code>&quot;c<u>ab</u>xbae&quot;</code> it becomes <code>&quot;cxbae&quot;</code>.</li>
	</ul>
	</li>
	<li>Remove substring <code>&quot;ba&quot;</code> and gain <code>y</code> points.
	<ul>
		<li>For example, when removing <code>&quot;ba&quot;</code> from <code>&quot;cabx<u>ba</u>e&quot;</code> it becomes <code>&quot;cabxe&quot;</code>.</li>
	</ul>
	</li>
</ul>

<p>Return <em>the maximum points you can gain after applying the above operations on</em> <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
- Stack
- Greedy
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cdbcbbaaabab&quot;, x = 4, y = 5
<strong>Output:</strong> 19
<strong>Explanation:</strong>
- Remove the &quot;ba&quot; underlined in &quot;cdbcbbaaa<u>ba</u>b&quot;. Now, s = &quot;cdbcbbaaab&quot; and 5 points are added to the score.
- Remove the &quot;ab&quot; underlined in &quot;cdbcbbaa<u>ab</u>&quot;. Now, s = &quot;cdbcbbaa&quot; and 4 points are added to the score.
- Remove the &quot;ba&quot; underlined in &quot;cdbcb<u>ba</u>a&quot;. Now, s = &quot;cdbcba&quot; and 5 points are added to the score.
- Remove the &quot;ba&quot; underlined in &quot;cdbc<u>ba</u>&quot;. Now, s = &quot;cdbc&quot; and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aabbaaxybbaabb&quot;, x = 5, y = 4
<strong>Output:</strong> 20
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= x, y &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        char ch1 = 'a', ch2 = 'b';
        int cnt1 = 0, cnt2 = 0;

        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            ch1 = 'b';
            ch2 = 'a';
        }

        for (int i = 0; i < len; i++) {
            if (chars[i] == ch1) {
                cnt1++;
            } else if (chars[i] == ch2) {
                if (cnt1 > 0) {
                    cnt1--;
                    score += x;
                } else {
                    cnt2++;
                }
            } else {
                score += Math.min(cnt1, cnt2) * y;
                cnt1 = 0;
                cnt2 = 0;
            }
        }

        if (cnt1 != 0)
            score += Math.min(cnt1, cnt2) * y;

        return score;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cdbcbbaaabab&quot;, x = 4, y = 5
<strong>Output:</strong> 19
</pre>
<p><strong class="example">


