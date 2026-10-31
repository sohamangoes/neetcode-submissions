class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = m-1, mid = 0;

        while(start <= end) {

            mid = start + (end - start)/2 ;

            if(target >= matrix[mid][0] && target <= matrix[mid][n-1]) {
                break;
            }

            if(target < matrix[mid][0]) {
                end = mid - 1;
                continue;
            }

            if(target > matrix[mid][n-1]) {
                start = mid + 1;
                continue;
            }
        }

        int row = mid;
        start = 0; end = n-1; mid = 0;

        while(start <= end) {

            mid = start + (end - start)/2;

            if(matrix[row][mid] == target) return true;

            if(matrix[row][mid] > target) {
                end = mid - 1;
                continue;
            }

            if(matrix[row][mid] < target) {
                start = mid + 1;
                continue;
            }
        }

        return false;
    }
}
