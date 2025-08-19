class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         List<Integer> list = new ArrayList<>();
        
        for (int a : asteroids) {
            boolean destroyed = false;

            while (!list.isEmpty() && a < 0 && list.get(list.size() - 1) > 0) {
                int last = list.get(list.size() - 1);
                
                if (last < -a) {
                    list.remove(list.size() - 1);
                    continue;
                } else if (last == -a) {
                    list.remove(list.size() - 1); // both destroyed
                }
                
                destroyed = true; // current asteroid destroyed
                break;
            }
            
            if (!destroyed) {
                list.add(a); // current asteroid survives
            }
        }
        
        // convert list to array
        return list.stream().mapToInt(i -> i).toArray();
    }
}