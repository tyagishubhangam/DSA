/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int mid = (r - l)/2 + l;
        while(l<=r){
            mid = (r - l)/2 + l;
            if(!isBadVersion(mid)){
                l = mid + 1;
            }else{
                if(mid == 0){
                    return 0;
                }else{
                    if(!isBadVersion(mid - 1)){
                        return mid;
                    }else{
                        r = mid - 1;
                    }
                }
            }
        }
        return mid;
    }
}