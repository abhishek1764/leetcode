class SmallestInfiniteSet {
    private int curr;  
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> inHeap;

    public SmallestInfiniteSet() {
        curr = 1;  // Start from 1
        minHeap = new PriorityQueue<>();
        inHeap = new HashSet<>();
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            inHeap.remove(smallest);
            return smallest;
        }
        return curr++;
    }

    public void addBack(int num) {
        if (num < curr && !inHeap.contains(num)) {
            minHeap.add(num);
            inHeap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */