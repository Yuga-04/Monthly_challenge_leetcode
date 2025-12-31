# 📌 Day 14: 1290. Convert Binary Number in a Linked List to Integer 🎯

**🔗 LeetCode Link:** [1290. Convert Binary Number in a Linked List to Integer](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/)

---

## 🧩 Problem Description

<p>Given <code>head</code> which is a reference node to a singly-linked list. The value of each node in the linked list is either <code>0</code> or <code>1</code>. The linked list holds the binary representation of a number.</p>

<p>Return the <em>decimal value</em> of the number in the linked list.</p>

<p>The <strong>most significant bit</strong> is at the head of the linked list.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Linked List
- Math
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/12/05/graph-1.png" style="width: 426px; height: 108px;" />
<pre>
<strong>Input:</strong> head = [1,0,1]
<strong>Output:</strong> 5
<strong>Explanation:</strong> (101) in base 2 = (5) in base 10
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [0]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The Linked List is not empty.</li>
	<li>Number of nodes will not exceed <code>30</code>.</li>
	<li>Each node&#39;s value is either <code>0</code> or <code>1</code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int getDecimalValue(ListNode head) {
        int count = 1; // Initialize power multiplier
        int num = 0;   // Final decimal value
        ListNode cur = head;

        // First pass: find the length of the list to determine the initial power of 2
        while (cur != null) {
            cur = cur.next;
            count *= 2; // Double count for each node to simulate shifting left
        }

        count /= 2; // Adjust count (it will be one step too far after last iteration)

        cur = head; // Reset pointer to head

        // Second pass: compute decimal value
        while (cur != null) {
            num += cur.val * count; // Add the current bit's decimal contribution
            count /= 2;             // Move to the next lower power of 2
            cur = cur.next;
        }

        return num; // Return the final decimal number
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/12/05/graph-1.png" style="width: 426px; height: 108px;" />
<pre>
<strong>Input:</strong> head = [1,0,1]
<strong>Output:</strong> 5
</pre>

<p><strong class="example">


