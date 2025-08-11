package LC141;

public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 判断链表是否有环（快慢指针法）
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // 慢指针走一步
            fast = fast.next.next;    // 快指针走两步

            if (slow == fast) {
                return true;          // 相遇则有环
            }
        }

        return false; // fast走到null 说明无环
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        n6.next = n3;


        Solution s = new Solution();
        System.out.println(s.hasCycle(n1));
    }
}
