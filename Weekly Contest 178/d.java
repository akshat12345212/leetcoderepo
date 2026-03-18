class Solution {
    class DSU{
        int par[];
        int size[];
        public DSU(int n){
            par=new int [n];
            size=new int [n];
            for (int i=0;i<n;++i){
                par[i]=i;
            }
            Arrays.fill(size,1);
        }
        public int findpar(int x){
    if (par[x] != x){
        par[x] = findpar(par[x]);
    }
    return par[x];
}
        public void merge(int x,int y){
            int p1=findpar(x);
            int p2=findpar(y);
            if (p1!=p2){
                if (p2>p1){
                    int t=p1;
                    p1=p2;
                    p2=t;
                }
                size[p1]+=size[p2];
                par[p2]=p1;
            }
        }

    }
    public int maxActivated(int[][] a) {
        int n=a.length;
        DSU d=new DSU(n);
        Map<Integer,ArrayList<Integer>>mp=new  HashMap<>();
        Map<Integer,ArrayList<Integer>>mp1=new HashMap<>();
        for (int i=0;i<n;++i){
            int x=a[i][0];
            if (!mp.containsKey(x))mp.put(x,new ArrayList<>());
            mp.get(x).add(i);
        }
        for (int i=0;i<n;++i){
            int x=a[i][1];
            if (!mp1.containsKey(x))mp1.put(x,new ArrayList<>());
            mp1.get(x).add(i);
        }
        for (var x:mp.entrySet()){
            var   k=x.getValue();
            for (int i=0;i<k.size()-1;++i){
                d.merge(k.get(i),k.get(i+1));
            }

        }
        for (var x:mp1.entrySet()){
            var  k=x.getValue();
            for (int i=0;i<k.size()-1;++i){
                d.merge(k.get(i),k.get(i+1));
            }

        }
    Set<Integer>s=new HashSet<>();
    PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
    for (int i=0;i<n;++i)s.add(d.findpar(i));
    for (int i:s){
        pq.add(d.size[i]);
    }
    int ans =0;
    for (int i=0;i<2;++i){
        if (pq.isEmpty())break;
        ans+=pq.poll();

    }
    return ans +1;
    }
}