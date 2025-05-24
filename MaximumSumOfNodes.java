import java.util.PriorityQueue;

public class MaximumSumOfNodes {
   public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        int pc=0;//positive change
        for(int n:nums) {
            sum+=n;
            pq.add((n^k)-n);
            if((n^k)-n>0) pc++;
        }
        boolean even = pc%2==0;
        if(pc==0) return sum;
        while(pc-->1) sum+=pq.poll();
        int x=pq.poll();
        if(even) sum+=x;
        else if(!pq.isEmpty()){
            int y=pq.poll();
            sum+=Math.max(x+y,0);
        } return sum;
    }
  
}
