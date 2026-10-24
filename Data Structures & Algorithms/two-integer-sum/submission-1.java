class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indicesByDifferences = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            indicesByDifferences.put(difference, i);
        }

        for (int i=0; i < nums.length; i++) {
            int num = nums[i];
            
            if(indicesByDifferences.containsKey(num)) {
                int j = indicesByDifferences.get(num);
                if(i != j) {
                    return new int[] {i, j};
                }                
            }
        }

        return new int[] {};
    }
}
