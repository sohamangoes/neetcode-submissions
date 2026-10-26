class Solution {
    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea(heights, 0, heights.length);
    }

    private int largestRectangleArea(int[] heights, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int min = heights[left];
        int minIndex = left;

        for(int i = left + 1; i < right; i++) {
            if(heights[i] < min) {
                min = heights[i];
                minIndex = i;
            }
        }

        int areaForMinHeightAcrossRange = (right - left) * min;
        int largestAreaOnTheLeftSegment = largestRectangleArea(heights, left, minIndex);
        int largestAreaOnTheRightSegment = largestRectangleArea(heights, minIndex + 1, right);

        return Math.max(Math.max(largestAreaOnTheLeftSegment, largestAreaOnTheRightSegment), areaForMinHeightAcrossRange);
    }
}
