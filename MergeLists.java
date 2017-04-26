/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.size == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size, new Comparator(){

            public int compare(ListNode l1, Listnode l2){
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(Listnode node:lists){
            if(node!= null){
                queue.add(node);
            }
        }

        while(!queue.empty()){
            p.next = queue.poll();
            p = p.next

            if(p.next != null){
                queue.add(p.next)
            }
        }

        return head.next();

}
