package LC141;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        ListNode listNode = createLinkedList(nums);

        createCycle(listNode, 1);

        boolean result = hasCycle(listNode);

        System.out.println(result);
    }

    public static ListNode createLinkedList(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    // 方法：在链表中创建环
    public static void createCycle(ListNode head, int pos) {
        if (head == null || pos < 0) {
            return;
        }

        // 找到链表尾部节点
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // 找到环的入口节点
        ListNode cycleEntry = head;
        for (int i = 0; i < pos && cycleEntry != null; i++) {
            cycleEntry = cycleEntry.next;
        }

        // 创建环：将尾节点指向环的入口
        if (cycleEntry != null) {
            tail.next = cycleEntry;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}