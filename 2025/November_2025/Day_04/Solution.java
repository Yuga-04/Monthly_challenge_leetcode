class Solution {
    int compute(int nums[],int start,int end ,int x){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=start;i<end;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) ->{
            int freq = b.getValue() - a.getValue();
            if(freq!=0) return freq;
            return b.getKey()-a.getKey();
        });
        pq.addAll(map.entrySet());
        int sum = 0;
        for(int i=0;i<x;i++){
            if(pq.isEmpty()) return sum;
            Map.Entry<Integer,Integer> entry = pq.poll();
            sum += entry.getKey() * entry.getValue();
        }
        return sum;

    }
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int arr[] = new int[n-k+1];
        for(int i=0;i<(n-k+1);i++){
            int res = compute(nums,i,k+i,x);
            arr[i] = res;
        }
        return arr;
    }
} 
