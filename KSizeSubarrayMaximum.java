class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(k==1) {
            for(int num:arr){
                list.add(num);
            }
            return list;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        int i=1,j;
        for(j=0;j<k;j++){
            pq.add(new int[]{j,arr[j]});
        }
        list.add(pq.peek()[1]);
        while(j<arr.length){
            int[] a=pq.peek();
            while(a[0]<i){
                pq.remove();
                a=pq.peek();
            }
            i++;
            list.add(Math.max(a[1],arr[j]));
            pq.add(new int[]{j,arr[j++]});
        }
        return list;
    }
}