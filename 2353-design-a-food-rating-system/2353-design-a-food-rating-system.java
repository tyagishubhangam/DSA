class FoodRatings {
    HashMap<String, TreeSet<Food>> hs;
    HashMap<String, Food> food_cuisine;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        hs = new HashMap<>();
        food_cuisine = new HashMap<>();
        for(int i=0;i<n;i++){
            String cuisine = cuisines[i];
            String food = foods[i];
            int rating = ratings[i];
            if(!hs.containsKey(cuisine)){
                hs.put(cuisine, new TreeSet<>(new SortTheTreeSet()));
            }
            Food fd = new Food(food, rating, cuisine);
            hs.get(cuisine).add(fd);
            food_cuisine.put(food, fd);
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        Food fd = food_cuisine.get(food);
        
        TreeSet<Food> set = hs.get(fd.cuisine);
        set.remove(fd);
        fd.rating = newRating;
        set.add(fd);
        
    }
    
    public String highestRated(String cuisine) {
        
        return hs.get(cuisine).first().name;
    }
}

class Food{
    String name;
    int rating;
    String cuisine;
    Food(String name, int rating, String cuisine){
        this.name = name;
        this.rating = rating;
        this.cuisine = cuisine;
    }
}

class SortTheTreeSet implements Comparator<Food>{
    public int compare(Food a, Food b){
        if(a.rating == b.rating){
            return a.name.compareTo(b.name);
        }

        return b.rating - a.rating;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */