class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for(int i = 0; i < nums.length ; i++) {            
            int j = nums.length - 1 - i;
            if(i == 0) {
                prefix[i] = 1;
                suffix[j] = 1;
            }
            else {
                prefix[i] = prefix[i-1] * nums[i-1];
                suffix[j] = suffix[j+1] * nums[j+1];
            }
        }

        int[] res = new int[nums.length];
        for(int i =0; i< nums.length; i ++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}  
