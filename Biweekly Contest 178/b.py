from math import gcd 
class Solution:
    def gcdSum(self, a: list[int]) -> int:
        b=[]
        mx=-1
        for i in a:
            mx=max(i,mx)
            b.append(gcd(mx,i))
        b.sort()
        left=0
        ans=0
        right=len(a)-1
        while (left<right):
            ans+=gcd(b[left],b[right])
            left+=1
            right-=1
        return ans 

        