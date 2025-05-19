package LC141.CodeFun;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {

    // 创建基本链表
    public static ListNode createLinkedList(int[] nums) {
        if (nums == null || nums.length == 0) {
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

    // 在指定位置创建环
    public static void createCycle(ListNode head, int pos) {
        if (head == null || pos < 0) {
            return;
        }

        // 找到尾节点和目标节点
        ListNode tail = head;
        ListNode target = head;

        // 先找到尾节点
        while (tail.next != null) {
            tail = tail.next;
        }

        // 再找到目标位置的节点
        for (int i = 0; i < pos && target != null; i++) {
            target = target.next;
        }

        // 将尾节点连接到目标节点，形成环
        if (target != null) {
            tail.next = target;
        }
    }

    // 使用快慢指针判断链表是否存在环
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        ListNode listNode = createLinkedList(nums);

        // 假设第二行输入是环的位置（-1表示无环）

        int pos = Integer.parseInt(scanner.nextLine());
        if (pos >= 0) {
            createCycle(listNode, pos);
        }

        boolean result = hasCycle(listNode);
        System.out.println(result);

        scanner.close();
    }
}