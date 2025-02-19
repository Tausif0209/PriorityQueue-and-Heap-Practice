class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists)
        {
            while(node!=null)
            {
                pq.add(node);
                node=node.next;
            }
        }
        ListNode head=new ListNode();
        ListNode dummyHead=head;
        while(!pq.isEmpty())
        {
            dummyHead.next=pq.remove();
            dummyHead=dummyHead.next;
        }
        dummyHead.next=null;
        return head.next;
    }
}