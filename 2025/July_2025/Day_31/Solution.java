import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int num : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(num);
            for (int x : cur) {
                next.add(x | num);
            }
            cur = next;
            res.addAll(cur);
        }
        return res.size();
    }
} 
