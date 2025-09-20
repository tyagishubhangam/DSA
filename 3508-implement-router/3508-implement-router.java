class Router {
    Queue<int[]> queue;
    Set<List<Integer>> st;
    int limit;
    HashMap<Integer, List<Integer>> hm; // destination -> sorted timestamps

    public Router(int memoryLimit) {
        queue = new LinkedList<>();
        st = new HashSet<>();
        this.limit = memoryLimit;
        hm = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        List<Integer> key = Arrays.asList(source, destination, timestamp);
        if (st.contains(key)) return false; // duplicate

        if (queue.size() == limit) {
            int[] rem = queue.poll();
            st.remove(Arrays.asList(rem[0], rem[1], rem[2]));
            removeTimestamp(rem[1], rem[2]);
        }

        queue.offer(new int[]{source, destination, timestamp});
        st.add(key);
        insertTimestamp(destination, timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            st.remove(Arrays.asList(tmp[0], tmp[1], tmp[2]));
            removeTimestamp(tmp[1], tmp[2]);
            return tmp;
        }
        return new int[0];
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = hm.get(destination);
        if (list == null || list.isEmpty()) return 0;

        int low = lowerBound(list, startTime);     // first index >= startTime
        int high = upperBound(list, endTime);      // last index <= endTime

        if (low > high) return 0;
        return high - low + 1;
    }

    // ---------- Helpers ----------
    private void insertTimestamp(int dest, int ts) {
        List<Integer> list = hm.computeIfAbsent(dest, k -> new ArrayList<>());
        int pos = Collections.binarySearch(list, ts);
        if (pos < 0) pos = -(pos + 1);
        list.add(pos, ts); // keep sorted
    }

    private void removeTimestamp(int dest, int ts) {
        List<Integer> list = hm.get(dest);
        if (list == null) return;
        int pos = Collections.binarySearch(list, ts);
        if (pos >= 0) list.remove(pos);
    }

    private int lowerBound(List<Integer> list, int x) {
        int l = 0, r = list.size() - 1, ans = list.size();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= x) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }

    private int upperBound(List<Integer> list, int x) {
        int l = 0, r = list.size() - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= x) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
}
