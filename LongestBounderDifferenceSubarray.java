class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        ArrayList<Integer> list=new ArrayList<>();
        if(arr.length==1) {
            list.add(arr[0]) ;
            return list;
        }
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[1]-a[1]);
        int[] ansIndex=new int[2];
        minHeap.add(new int[]{0,arr[0]});
        maxHeap.add(new int[]{0,arr[0]});
        int i=0,j=1;
        while(j<arr.length){
            if(minHeap.isEmpty() || (Math.abs(maxHeap.peek()[1]-arr[j])<=x && Math.abs(minHeap.peek()[1]-arr[j])<=x))
            {
                minHeap.add(new int[]{j,arr[j]});
                maxHeap.add(new int[]{j,arr[j++]});
            }
            else{
                if(j-i>ansIndex[1]-ansIndex[0]+1){
                    ansIndex[0]=i;
                    ansIndex[1]=j-1;
                }
                i++;
                while(!maxHeap.isEmpty() && maxHeap.peek()[0]<i) maxHeap.remove();
                while(!minHeap.isEmpty() && minHeap.peek()[0]<i) minHeap.remove();
            }
        }
         if(j-i>ansIndex[1]-ansIndex[0]+1){
                    ansIndex[0]=i;
                    ansIndex[1]=j-1;
                }
        for(i=ansIndex[0];i<=ansIndex[1];i++){
            list.add(arr[i]);
        }
        return list;
    }
}