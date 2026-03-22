import java.util.*;

class Solution {
    public long countGoodSubarrays(int[] nums) {
        
        Map<Long, Long> prev = new HashMap<>();
        long ans = 0;
        
        for (int num : nums) {
            Map<Long, Long> curr = new HashMap<>();
            
            long key = ((long) num << 32) | num;
            curr.put(key, 1L);
            
            for (Map.Entry<Long, Long> entry : prev.entrySet()) {
                long k = entry.getKey();
                long cnt = entry.getValue();
                
                int orVal = (int) (k >> 32);
                int mx = (int) (k & 0xffffffffL);
                
                int newOr = orVal | num;
                int newMx = Math.max(mx, num);
                
                long newKey = ((long) newOr << 32) | newMx;
                curr.put(newKey, curr.getOrDefault(newKey, 0L) + cnt);
            }
            
            for (Map.Entry<Long, Long> entry : curr.entrySet()) {
                long k = entry.getKey();
                long cnt = entry.getValue();
                
                int orVal = (int) (k >> 32);
                int mx = (int) (k & 0xffffffffL);
                
                if (orVal == mx) ans += cnt;
            }
            
            prev = curr;
        }
        
        return ans;
    }
}