package LC141;


public class Solution {


    static class ListNode {
        int val;

        ListNode next;


        ListNode(int val) {
            this.val = val;
        }

    }

    public boolean hasCycle(ListNode head) {
        // 3 4 2 1 5 6

//        3 3
//        4 2
//        2 5
//        1 3
//        5 2
//        6 5
//        3 3


        ListNode slow = head;

        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;

    }
}