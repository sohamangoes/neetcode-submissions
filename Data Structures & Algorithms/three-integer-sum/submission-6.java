class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = n - 1; i > 0; i--) {
            if (i < n-1 && nums[i] == nums[i + 1])
                continue;

            int j = 0, k = i - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                    continue;
                } else if (sum < 0) {
                    j++;
                    continue;
                }

                results.add(Arrays.stream(new int[] {nums[i], nums[j], nums[k]}).boxed().toList());
                while (j < k && nums[j] == nums[j + 1]) {
                    j++;
                }
                while (j < k && nums[k] == nums[k - 1]) {
                    k--;
                }

                j++;
                k--;
            }
        }

        return results;
    }
}
