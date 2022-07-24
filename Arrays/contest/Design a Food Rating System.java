2353. Design a Food Rating System
https://leetcode.com/problems/design-a-food-rating-system/

/*
->map stores the cuisine as the key and TreeSet of foods belongs to that cuisine as a value
->map2 stores the food as the key and rating as the value
->mfoodm stores food as the key and cuisines as the value
->Declare Comparator to the TreeSet according to the given condition
->While changeRating, remove it from the map, change the rating and re-insert it in map
*/
class FoodRatings {
    HashMap<String, TreeSet<String>> map;
    HashMap<String, Integer> map2;
    HashMap<String, String> foodm;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        map2 = new HashMap<>();
        foodm = new HashMap<>();
        
        for(int i = 0; i<foods.length; i++) {
            map2.put(foods[i], ratings[i]);
        }
        
        for(String s : cuisines) {
            if(!map.containsKey(s)) {
                TreeSet<String> set = new TreeSet<>(new Comparator<>() {
                    @Override
                    public int compare(String a, String b) {
                        int i = map2.get(a);
                        int j = map2.get(b);
                        
                        if(i==j) {
                            return a.compareTo(b);
                        }
                        
                        return map2.get(b)-map2.get(a);
                    }
                });
                map.put(s, set);
            }
            
        }
        
        for(int i = 0; i<foods.length; i++) {
            foodm.put(foods[i], cuisines[i]);
        }
        
        for(int i = 0; i<foods.length; i++) {
            map.get(cuisines[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String c = foodm.get(food);
        map.get(c).remove(food);
        map2.put(food, newRating);
        map.get(c).add(food); 
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).first();
    }
}
