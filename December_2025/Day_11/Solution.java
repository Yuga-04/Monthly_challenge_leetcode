class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> colMap = new HashMap<>();
        for(int[] building : buildings) {
            int x=building[0],y=building[1];
            if(!rowMap.containsKey(x))
                rowMap.put(x, new TreeSet<>());
            rowMap.get(x).add(y);
            if(!colMap.containsKey(y))
                colMap.put(y, new TreeSet<>());
            colMap.get(y).add(x);
        }
        int ans=0;
        for(int[] building : buildings) {
            int x=building[0],y=building[1];
            TreeSet<Integer> row = colMap.get(y);
            TreeSet<Integer> col = rowMap.get(x);
            Integer top = col.higher(y);
            Integer down = col.lower(y);
            Integer left = row.lower(x);
            Integer right = row.higher(x);
            if(top!=null && down!=null && left!=null && right!=null)
                ans++;
        }
        return ans;
    }
} 
