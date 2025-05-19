package LC92;


import java.util.List;
import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }



}




public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] str = s.split(" ");

        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        ListNode listNode = createListNode(nums);
        ListNode node = reverseBetween(listNode, 2, 4);
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" ");
            node = node.next;
        }

    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode current = pre.next;
        ListNode temp;

        for (int i = 0; i < right - left; i++) {
            temp = current.next;
            current.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }


    public static ListNode createListNode(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }




        return head;
    }

}
