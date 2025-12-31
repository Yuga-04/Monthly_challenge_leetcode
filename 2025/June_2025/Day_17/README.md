# 📌 Day 17: 3405. Count the Number of Arrays with K Matching Adjacent Elements 🎯

**🔗 LeetCode Link:** [3405. Count the Number of Arrays with K Matching Adjacent Elements](https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/)

---

## 🧩 Problem Description

<p>You are given three integers <code>n</code>, <code>m</code>, <code>k</code>. A <strong>good array</strong> <code>arr</code> of size <code>n</code> is defined as follows:</p>

<ul>
	<li>Each element in <code>arr</code> is in the <strong>inclusive</strong> range <code>[1, m]</code>.</li>
	<li><em>Exactly</em> <code>k</code> indices <code>i</code> (where <code>1 &lt;= i &lt; n</code>) satisfy the condition <code>arr[i - 1] == arr[i]</code>.</li>
</ul>

<p>Return the number of <strong>good arrays</strong> that can be formed.</p>

<p>Since the answer may be very large, return it <strong>modulo </strong><code>10<sup>9 </sup>+ 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Math
- Combinatorics
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, m = 2, k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There are 4 good arrays. They are <code>[1, 1, 2]</code>, <code>[1, 2, 2]</code>, <code>[2, 1, 1]</code> and <code>[2, 2, 1]</code>.</li>
	<li>Hence, the answer is 4.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 4, m = 2, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The good arrays are <code>[1, 1, 1, 2]</code>, <code>[1, 1, 2, 2]</code>, <code>[1, 2, 2, 2]</code>, <code>[2, 1, 1, 1]</code>, <code>[2, 2, 1, 1]</code> and <code>[2, 2, 2, 1]</code>.</li>
	<li>Hence, the answer is 6.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5, m = 2, k = 0</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The good arrays are <code>[1, 2, 1, 2, 1]</code> and <code>[2, 1, 2, 1, 2]</code>. Hence, the answer is 2.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= m &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= k &lt;= n - 1</code></li>
</ul>

---

## ✅ Code (Java)

```java
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
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, m = 2, k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

</div>

<p><strong class="example">


