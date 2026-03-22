class Solution {
    public boolean uniformArray(int[] a) {
        int n=a.length;
        TreeSet<Integer>e=new TreeSet<>();
        TreeSet<Integer>o=new TreeSet<>();
        int mn=Arrays.stream(a).min().getAsInt();
        for (int i:a){
            if (i%2==0)e.add(i);
            else o.add(i);
        }
        int f=0;
        for (int i=0;i<n;++i){
            if (a[i]%2==0)continue;
            else {
                if (a[i]!=o.first())continue;
                else {
                    f=1;
                    break;
                }
            }
        }
        if (f==1){
            f=0;
            for (int i=0;i<n;++i){
                if (a[i]%2==1)continue;
                else {
                    if (a[i]!=mn)continue;
                    else {
                        f=1;
                        break;
                    }
                }
            }
        }
        return f==1?false:true;
        
    }
}