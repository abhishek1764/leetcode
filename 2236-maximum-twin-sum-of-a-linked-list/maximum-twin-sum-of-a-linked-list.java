/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }
         ListNode secondhalf = reverse(slow);
         int maxsum = 0;
          ListNode firsthalf = head;

          while(secondhalf != null){
            maxsum = Math.max(maxsum , firsthalf.val+secondhalf.val);
            firsthalf = firsthalf.next;
            secondhalf = secondhalf.next;

          }
          return maxsum;

    }
    private  ListNode reverse( ListNode head){
         ListNode prev = null;
          ListNode curr = head;
          while(curr!=null){
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;

          }
          return prev;
    }
}