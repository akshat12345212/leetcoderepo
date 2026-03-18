class Solution {
    public long countCommas(long n) {
        long mn=1000;
        long ans =0;
        while (n>=mn){
            ans+=n-mn+1;
            mn=mn*1L*1000L;
        }
        return ans;
    }
}