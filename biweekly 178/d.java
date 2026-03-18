class Solution {
    public boolean good(int sum){
        int a,b,c;
        if (sum<10)return true;
        if (sum>=10 &&sum<100){
            a=sum%10;
            sum/=10;
            b=sum%10;
            sum/=10;
            return a>b||b>a;
        }
         a=sum%10;
            sum/=10;
            b=sum%10;
            sum/=10;
        c=sum;
        return c>b && b>a || ( c<b && b<a);

    }
    public long rec(String s,int n  ,int i ,int st ,int tight ,int last ,int iod,int sum){
        if (i==n){
            return iod==1||iod==2||good(sum)?1:0;
        }
        if (dp[i][st][tight][last][iod][sum]!=null)return dp[i][st][tight][last][iod][sum];
        long ans =0;
        int ub=tight==1?s.charAt(i)-'0':9;
        for(int dig=0;dig<=ub;dig++ ){
            if (st==0 && dig==0){
                ans+=rec(s,n,i+1,0,0,0,0,0);
            }
            else if (st==0){
                ans+=rec(s,n,i+1,1,(tight==1&& dig==ub?1:0),dig,0,dig);
            }
            else {
            int ntight =(tight==1&& dig==ub?1:0);
            int nst=st==0 && dig==0?0:1;
            int nlast=dig;
            int nsum=sum+dig;
            int niod=iod==0?dig>last?1:dig<last?2:3:iod==3?iod:iod==1&&dig>last?1:iod==2 &&dig<last?2:3;
            ans+=rec(s,n,i+1,nst,ntight,nlast,niod,nsum);
            }

        }
        
        return dp[i][st][tight][last][iod][sum]=ans ;
    }
    Long dp[][][][][][];
    public long countFancy(long l, long r) {
        String l1=String.valueOf(l-1);
        String r1=String.valueOf(r);
        dp=new Long [16][2][2][10][4][136];
        long ans =rec(r1,r1.length(),0,0,1,0,0,0);
        dp=new Long [16][2][2][10][4][136];
        return ans -rec(l1,l1.length(),0,0,1,0,0,0);
        

        
    }
}