class MovieRentingSystem {
    Map<String, Integer> priceMap;
    Map<Integer, TreeSet<int[]>> available;
    TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "#" + movie, price);
            available.computeIfAbsent(movie, k -> new TreeSet<>((x, y) -> {
                if (x[2] != y[2]) return x[2] - y[2];
                return x[0] - y[0];
            }));
            available.get(movie).add(new int[]{shop, movie, price});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        Iterator<int[]> it = available.get(movie).iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            res.add(it.next()[0]);
            count++;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        int[] entry = new int[]{shop, movie, price};
        available.get(movie).remove(entry);
        rented.add(entry);
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        int[] entry = new int[]{shop, movie, price};
        rented.remove(entry);
        available.get(movie).add(entry);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<int[]> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            int[] e = it.next();
            res.add(Arrays.asList(e[0], e[1]));
            count++;
        }
        return res;
    }
}
