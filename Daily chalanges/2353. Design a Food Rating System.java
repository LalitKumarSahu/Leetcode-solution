import java.util.*;

class FoodRatings {
    class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;   
            this.rating = rating;
        }
    }

    Map<String, PriorityQueue<Food>> cuisinePq = new HashMap<>();
    Map<String, String> foodToCuisines = new HashMap<>();
    Map<String, Integer> foodToRating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisines.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisinePq.computeIfAbsent(cuisine, k -> new PriorityQueue<>(
                (a, b) -> a.rating != b.rating ? b.rating - a.rating : a.name.compareTo(b.name)
            )).offer(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisines.get(food);
        foodToRating.put(food, newRating);
        cuisinePq.get(cuisine).offer(new Food(food, newRating)); 
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisinePq.get(cuisine);

        while (true) {
            Food food = pq.peek();
            if (food.rating == foodToRating.get(food.name)) {  
                return food.name;
            }
            pq.poll(); // remove outdated entry
        }
    }
}
