class Solution {
    private long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n=nums.length;
        Stack<Long> st=new Stack<>();
        st.push(1l*nums[0]);
        for(int i=1;i<n;i++){
            long gcd=gcd(st.peek(),1l*nums[i]);
            if(gcd==1) st.push(1l*nums[i]);
            else{
                long lcm=(st.pop()*nums[i])/gcd;
                if(!st.isEmpty()) gcd=gcd(st.peek(),lcm);
                while(!st.isEmpty()&&gcd!=1){
                    lcm=(st.pop()*lcm)/gcd;
                    if(!st.isEmpty()) gcd=gcd(st.peek(),lcm);
                }
                st.push(lcm);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            long a=st.pop();
            ans.add(0,(int)a);
        }
        return ans;
    }
} 
