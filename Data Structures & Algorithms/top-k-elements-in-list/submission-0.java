
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= 1)
            return nums;

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) frequencies.merge(num, 1, Integer::sum);

        List<List<Integer>> buckets = IntStream.range(0, nums.length + 1)
                                          .mapToObj(i -> (List<Integer>) null)
                                          .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int frequency = entry.getValue();
            if (buckets.get(frequency) == null) {
                buckets.set(frequency, new ArrayList<>());
            }
            buckets.get(frequency).add(entry.getKey());
        }

        int[] result = new int[k];
        int r = 0;

        for (int f = buckets.size() - 1; f >= 0 && r < k; f--) {
            if (buckets.get(f) == null)
                continue;

            for (int num : buckets.get(f)) {
                if (r == k)
                    break;
                result[r++] = num;
            }
        }

        return result;
    }
}
