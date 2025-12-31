# 📌 Day 2: 838. Push Dominoes

**LeetCode Link:** [838. Push Dominoes](https://leetcode.com/problems/push-dominoes/description/)

---

## 🧩 Problem

There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,

dominoes[i] = 'R', if the ith domino has been pushed to the right, and

dominoes[i] = '.', if the ith domino has not been pushed.

Return a string representing the final state.

### Example:

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/05/18/domino.png" alt="image">

```
Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
```

---

## 🧠 Topics

 - Two Pointers
- String
- Dynamic Programming

---

## ✅ Code (Java)

```Java
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        String s = "L" + dominoes + "R";
        char[] arr = s.toCharArray();
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '.') continue;
            if (arr[prev] == arr[i]) {
                for (int k = prev + 1; k < i; k++) arr[k] = arr[i];
            } else if (arr[prev] == 'R' && arr[i] == 'L') {
                int l = prev + 1, r = i - 1;
                while (l < r) {
                    arr[l++] = 'R';
                    arr[r--] = 'L';
                }
            }
            prev = i;
        }
        return new String(arr, 1, n);
    }
}
```

---

## 🧪 Sample Test Case

```Java
Input: dominoes = "RR.L"
Output: "RR.L"
```

---


