class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int sizeOfBiggestPile = Arrays.stream(piles).max().getAsInt();
        
        int left = 1;
        int right = sizeOfBiggestPile;
        int k = sizeOfBiggestPile;

        while(left <= right) {

            int mid = (left + right)/2;

            long hoursTaken = 0;
            for(int i = 0; i < n; i ++) {
                hoursTaken += Math.ceilDiv(piles[i], mid);
            }

            if(hoursTaken > h) {
                left = mid + 1;
                continue;
            }

            k = mid;
            right = mid - 1;
        }

        return k;
    }
}
