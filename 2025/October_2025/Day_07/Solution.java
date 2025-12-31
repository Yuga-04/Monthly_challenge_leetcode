class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(rains[i] == 0) {
                set.add(i);
                ans[i] = 1;
            } else {
                if(map.containsKey(rains[i])) {
                    int lastRain = map.get(rains[i]);
                    Integer free = set.higher(lastRain);
                    if(free == null) return new int[] {};
                    else {
                        ans[free] = rains[i];
                        set.remove(free);
                    }
                }
                map.put(rains[i],i);
            }
        }
        return ans;
    }
} 
