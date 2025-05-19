package LC23;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入链表的个数
        int k = sc.nextInt();
        sc.nextLine(); // 处理换行符

        ListNode[] lists = new ListNode[k];

        // 输入每个链表的数据
        for (int i = 0; i < k; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            // 使用传统方法转换字符串数组为整数数组
            int[] nums = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                nums[j] = Integer.parseInt(parts[j]);
            }
            lists[i] = createLinkedList(nums);
        }

        // 创建 Solution 对象并调用 mergeKLists 方法
        Solution solution = new Solution();
        ListNode mergedList = solution.mergeKLists(lists);

        // 输出合并后的链表
        printList(mergedList);
    }

    // 创建链表的公共方法
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

    // 合并多个链表的方法
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    // 合并两个部分的递归方法
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftMerged = merge(lists, left, mid);
        ListNode rightMerged = merge(lists, mid + 1, right);
        return mergeTwoLists(leftMerged, rightMerged);
    }

    // 合并两个链表的方法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }

    // 输出链表的辅助函数
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}