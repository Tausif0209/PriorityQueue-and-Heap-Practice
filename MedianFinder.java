class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int len;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>((a,b)->b-a);
        minHeap=new PriorityQueue<>();
        len=0;
    }
    
    public void addNum(int num) {
        int el;
        if(len%2==0) {
            if(maxHeap.size()==0 || num<=minHeap.peek()) maxHeap.add(num);
            else{
                el=minHeap.remove();
                maxHeap.add(el);
                minHeap.add(num);
            }
            len++;
            return ;
        }
        if(num>=maxHeap.peek()) minHeap.add(num);
        else{
            el=maxHeap.remove();
            minHeap.add(el);
            maxHeap.add(num);
        }
        len++;
    }
    
    public double findMedian() {
        if(len%2==0) return ((double)(minHeap.peek()+maxHeap.peek()))/2;
        return (double)(maxHeap.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */