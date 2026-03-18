class Solution {
    public int minCost(int[] a, int[] b) {
        int n=a.length;
        Map<Integer,Integer>mp=new  HashMap<>();
        Map<Integer,Integer>mp1=new HashMap<>();
        Map<Integer,Integer>mp2=new HashMap<>();
        for (int i=0;i<n;++i){
            mp.put(a[i],mp.getOrDefault(a[i],0)+1);
        }
        for (int i=0;i<n;++i){
            mp1.put(b[i],mp1.getOrDefault(b[i],0)+1);
        }
        for (var x:mp.entrySet())mp2.put(x.getKey(),x.getValue());
        for (var x:mp1.entrySet())mp2.put(x.getKey(),x.getValue()+mp2.getOrDefault(x.getKey(),0));
        for (var x:mp2.entrySet())if (x.getValue()%2==1)return -1;
        int ans=0;
        
        for(var x :mp2.entrySet())ans+= Math.max(0,x.getValue()/2-mp.getOrDefault(x.getKey(),0));
       
        return ans;
    }
}