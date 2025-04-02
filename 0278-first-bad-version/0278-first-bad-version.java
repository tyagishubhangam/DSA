/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int ans = 0;
        while(l<=r){
            int mid = (r-l) / 2 + l;
            if(!isBadVersion(mid)){
                l = mid + 1;
            }else{
                if(mid == 0){
                    ans = mid;
                    break;
                }else{
                    if(!isBadVersion(mid-1)){
                    ans = mid;
                    break;
                }else{
                    r = mid - 1;
                }
                
            }
        }
        }return ans;
    }
}