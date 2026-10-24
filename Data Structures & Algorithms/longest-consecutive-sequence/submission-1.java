class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> sequenceStarters =
            numsSet.stream().filter(num -> !numsSet.contains(num - 1)).collect(Collectors.toSet());

        int maxSequence = 1;

        for (Integer starter : sequenceStarters) {
            int currentSequence = 1;
            while (numsSet.contains(starter + currentSequence)) {
                currentSequence++;
            }

            if (currentSequence > maxSequence)
                maxSequence = currentSequence;
        }

        return maxSequence;
    }
}
