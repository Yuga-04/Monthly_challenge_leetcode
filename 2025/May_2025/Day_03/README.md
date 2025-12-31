# 📌 Day 3: 1007. Minimum Domino Rotations For Equal Row

**LeetCode Link:** [1007. Minimum Domino Rotations For Equal Row](https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/)

---

## 🧩 Problem

In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.

### Example:

<img src="https://assets.leetcode.com/uploads/2021/05/14/domino.png" alt="img">

```
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
```

---

## 🧠 Topics

- Array
- Greedy

---

## ✅ Code (Java)

```Java
class Solution {
    private int check(int target,int[] tops,int[] bottoms)
    {
        int rotateTop=0;
        int rotateBottom=0;

        int len=tops.length;
        for(int i=0;i<len;i++)
        {
            if(tops[i]!=target && bottoms[i]!=target)
               return -1;
            else if(tops[i]!=target)
              rotateTop++;
            else if(bottoms[i]!=target)
               rotateBottom++;
        }
        return rotateTop<rotateBottom ? rotateTop : rotateBottom;
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int no_rotations=-1;
        //1 <= tops[i], bottoms[i] <= 6
        for(int i=1;i<7;i++)
        {
            int n_r=check(i,tops,bottoms);
            if(n_r!=-1 && (no_rotations==-1 || n_r<no_rotations))
               no_rotations=n_r;
        }
        return no_rotations;
        
    }
}
```

---

## 🧪 Sample Test Case

```Java
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
```

---


