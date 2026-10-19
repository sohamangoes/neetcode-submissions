class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    hasDuplicate(nums) {

        const elementMap = {};
        for(let i =0; i < nums.length; i++) {
            if(elementMap[nums[i]]!== undefined) {
                return true;
            }
            elementMap[nums[i]] = i;
        }
        return false;
    }
}
