import java.util.PriorityQueue;

public class KLargestSum {
  public static int kthLargest(int[] arr, int k) {
        if(arr.length==1 && k==1) return arr[0];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                pq.add(sum);
            }
        }
        while(k>1){
            pq.remove();
            k--;
        } 
        return pq.remove();
    }
}
