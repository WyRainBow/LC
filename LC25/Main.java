package LC25;

class  ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }

    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class Main{
    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        if (head == null || k == 1)
            return head;

        ListNode pre = dummy;
        dummy.next = head;
        int len = getLen(head);
        ListNode current;
        while (len - k >= 0) {
            current = pre.next;
            ListNode temp;
            for (int j = 1; j < k; j++) {
                temp = current.next;
                current.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = current;
            len = len - k;
        }

        return dummy.next;
    }

    public static int getLen(ListNode head) {
        ListNode current = head;
        int len = 0;
        while (current != null) {
            current = current.next;
            len++;
        }
        return len;
    }

}