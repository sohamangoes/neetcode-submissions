class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        if(n == 1) {
            return new int[] { 0 };
        }
        
        int[] results = new int[n];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i ++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] tuple = stack.pop();
                results[tuple[1]] = i - tuple[1];
            }
            stack.push(new int[]{temp, i});
        }

        return results;
    }
}
