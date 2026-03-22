class Solution {
    int inf=1000000000;
    int dp[][];
    public int rec(int i,int cur,int a[],int target){
        int n=a.length;
        if (i==n){
            return cur==target?0:inf;
        }
        if (dp[i][cur]!=-1)return dp[i][cur];
        int pick=rec(i+1,cur^a[i],a,target);
        int notpick=1+rec(i+1,cur,a,target);
        return dp[i][cur]=Math.min(pick,notpick);
    }
    public int minRemovals(int[] a, int t) {
        int n=a.length;
        
        dp=new int [n][100000+10];
        for (int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        int ans =rec(0,0,a,t);
        return ans==inf?-1:ans ;
    }
}