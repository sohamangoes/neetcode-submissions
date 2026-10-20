class DynamicArray {

    private int[] arr;
    private int lastSetIndex = -1;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if(lastSetIndex == arr.length - 1) {
            resize();
        }
        lastSetIndex ++;
        arr[lastSetIndex] = n;
    }

    public int popback() {
        int popped = arr[lastSetIndex];
        arr[lastSetIndex] = 0;
        lastSetIndex --;
        return popped;
    }

    private void resize() {
        int[] temp = new int[arr.length * 2];
        for (int i=0; i< arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public int getSize() {
        return lastSetIndex + 1;
    }

    public int getCapacity() {
        return arr.length;
    }
}
