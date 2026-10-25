class MinStack {
    private ArrayList<Integer> items;
    private int top;
    private HashMap<Integer, Integer> minimaAtIndex;

    public MinStack() {
        items = new ArrayList<>(0);
        top = -1;
        minimaAtIndex = new HashMap<>();
    }

    public void push(int val) {
        Integer currMin = minimaAtIndex.get(top);

        ++top;
        items.add(val);

        if (currMin == null) {
            minimaAtIndex.put(top, val);
        } else {
            minimaAtIndex.put(top, minimum(currMin, val));
        }
    }

    public void pop() {
        items.remove(top);
        minimaAtIndex.remove(top);
        top--;
    }

    public int top() {
        return items.get(top);
    }

    public int getMin() {
        return minimaAtIndex.get(top);
    }

    private int minimum(int a, int b) {
        if (a > b)
            return b;
        return a;
    }
}
