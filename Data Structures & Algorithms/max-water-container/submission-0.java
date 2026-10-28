class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n -1;

        int max = 0;
        while(left < right) {

            int area = (right - left) * Math.min(heights[left], heights[right]);
            if( area > max ) max = area;

            if(heights[left] < heights[right]) {
                left++;
            }else {
                right --;
            }
        }

        return max;
    }
}
