package LC23;

public class Main {

    // 链表节点定义
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        // 直接写死链表的数据
        ListNode[] lists = new ListNode[3];

        // 创建每个链表
        lists[0] = createLinkedList(new int[] {1, 4, 5});
        lists[1] = createLinkedList(new int[] {1, 3, 4});
        lists[2] = createLinkedList(new int[] {2, 6});

        ListNode mergedList = mergeKLists(lists);

        // 输出合并后的链表
        printList(mergedList);
    }

    // 创建链表的公共方法
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

    // 输出链表的辅助函数
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // 合并K个链表的方法
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    // 递归合并的方法
    public static ListNode merge(ListNode[] lists, int left, int right) {
        // 如果只有一个链表，直接返回
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode leftMerged = merge(lists, left, mid);  // 递归合并左边部分
        ListNode rightMerged = merge(lists, mid + 1, right);  // 递归合并右边部分

        return mergeTwoLists(leftMerged, rightMerged);  // 合并两个部分
    }

    // 合并两个链表的方法
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);  // 创建一个虚拟头节点，简化边界条件处理
        ListNode current = dummy;

        // 合并两个链表
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

        // 处理剩余的节点
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;  // 返回合并后的链表，去除虚拟头节点
    }
}