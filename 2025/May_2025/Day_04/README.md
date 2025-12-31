# 📌 Day 4: 1128. Number of Equivalent Domino Pairs

**LeetCode Link:** [1128. Number of Equivalent Domino Pairs](https://leetcode.com/problems/number-of-equivalent-domino-pairs/description)

---

## 🧩 Problem

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

### Example:

<img src="https://assets.leetcode.com/uploads/2021/05/14/domino.png" alt ="image">

```
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
```

---

## 🧠 Topics


- Array
- Hash Table
- Counting

---

## ✅ Code (Java)

```Java
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            int key = a * 10 + b;
            count += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}
```

---

## 🧪 Sample Test Case

```Java
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
```

---


