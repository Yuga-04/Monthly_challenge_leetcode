class Solution {
  public static final int mod=1000000007;
    public static final int mx=100000;
  public static long[] f=new long[mx+1];
    public static long[] comb=new long[mx+1];
static{
  f[0]=1L;
for(int i=1;i<=mx;i++){
f[i]=f[i-1]*i%mod;}
    comb[mx]=modExp(f[mx],mod-2,mod);
  for(int i=mx-1;i>=0;i--){
comb[i]=comb[i+1]*(i+1)%mod;}
}
  public static long modExp(long base,int exp,int m){
long res=1L;
    while(exp>0){
if((exp&1)==1){
res=(res*base)%m;}
  base=(base*base)%m;
exp>>=1;}
      return res;}
public static long nCr(int n,int r){
if(r<0||r>n)return 0;
  return f[n]*comb[r]%mod*comb[n-r]%mod;}
    public int countGoodArrays(int n,int m,int k){
if(n==1){
  return(k==0)?m:0;}
long pick=nCr(n-1,k);
    long count=pick%mod;
count=(count*m)%mod;
  count=(count*modExp(m-1,n-k-1,mod))%mod;
    return(int)count;}
} 
