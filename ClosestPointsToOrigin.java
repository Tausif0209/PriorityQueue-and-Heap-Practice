class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points.length==1||(k==points.length)) return points;
        int[][] ans=new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int distance,i;
        for( i=0;i<points.length;i++)
        {
            int[] arr=points[i];
            distance=(int)(Math.pow(arr[0],2)+Math.pow(arr[1],2));
            pq.add(new int[]{i,distance});
        }
        i=0;
        while(i<k)
        {
            ans[i++]=points[pq.remove()[0]];
        }
        return ans;
    }
}