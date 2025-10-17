class Solution {

    static final int ALPHABET_SIZE = 'z' - 'a' + 1;

    public int maxPartitionsAfterOperations(String s, int k) {
        if (k == ALPHABET_SIZE) {
            return 1;
        }
        int n = s.length();

        int[] ansr = new int[n];
        int[] usedr = new int[n];
        int used = 0;
        int cntUsed = 0;
        int ans = 1;
        for (int i = n - 1; i >= 0; --i) {
            int ch = s.charAt(i) - 'a';
            if ((used & (1 << ch)) == 0) {
                if (cntUsed == k) {
                    cntUsed = 0;
                    used = 0;
                    ans++;
                }
                used |= (1 << ch);
                cntUsed++;
            }
            ansr[i] = ans;
            usedr[i] = used;
        }

        int ansl = 0;
        ans = ansr[0];
        for (int l = 0; l < n;) {
            used = 0;
            cntUsed = 0;
            int usedBeforeLast = 0;
            int usedTwiceBeforeLast = 0;
            int last = -1;
            int r = l;
            while (r < n) {
                int ch = s.charAt(r) - 'a';
                if ((used & (1 << ch)) == 0) {
                    if (cntUsed == k) {
                        break;
                    }
                    usedBeforeLast = used;
                    last = r;
                    used |= (1 << ch);
                    cntUsed++;
                } else if (cntUsed < k) {
                    usedTwiceBeforeLast |= (1 << ch);
                }
                r++;
            }

            if (cntUsed == k) {
                if (last - l > Integer.bitCount(usedBeforeLast)) {
                    // we can change one letter in s[l..last), so new partition will start at last
                    ans = Math.max(ans, ansl + 1 + ansr[last]);
                }
                if (last + 1 < r) {
                    // we can change s[last+1] to a letter to maximize the number of partitions
                    // s[l..last] is one partition, so new partition starts from s[last + 1]
                    if (last + 2 >= n) {
                        ans = Math.max(ans, ansl + 1 + 1);
                    } else {
                        if (Integer.bitCount(usedr[last + 2]) == k) {
                            int canUse = ((1 << ALPHABET_SIZE) - 1) & ~used & ~usedr[last + 2];
                            if (canUse > 0) {
                                ans = Math.max(ans, ansl + 1 + 1 + ansr[last + 2]);
                            } else {
                                ans = Math.max(ans, ansl + 1 + ansr[last + 2]);
                            }
                            int l1 = s.charAt(last + 1) - 'a';
                            if ((usedTwiceBeforeLast & (1 << l1)) == 0) {
                                ans = Math.max(ans, ansl + 1 + ansr[last + 1]);
                            }
                        } else {
                            ans = Math.max(ans, ansl + 1 + ansr[last + 2]);
                        }
                    }
                }
            }

            l = r;
            ansl++;
        }

        return ans;
    }
}