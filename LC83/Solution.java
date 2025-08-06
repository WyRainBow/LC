package LC83;

class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        // 创建虚拟头节点 简化边界情况处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev指向虚拟头节点 用于连接非重复的节点
        ListNode prev = dummy;
        // curr指向当前处理的节点
        ListNode curr = head;

        while (curr != null) {
            // 检查当前节点是否有重复
            if (curr.next != null && curr.val == curr.next.val) {
                // 找到重复值
                int duplicateVal = curr.val;

                // 跳过所有具有相同值的节点
                while (curr != null && curr.val == duplicateVal) {
                    curr = curr.next;
                }

                // 将prev连接到跳过重复节点后的位置
                prev.next = curr;
            } else {
                // 当前节点没有重复 移动prev指针
                prev = curr;
                curr = curr.next;
            }
        }

        // 返回虚拟头节点的下一个节点 即新的头节点
        return dummy.next;
    }

    // 创建链表
    public static ListNode createList(int[] nums) {
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

    // 打印链表
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // 测试入口
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 3, 3, 4, 4, 5};

        ListNode node = createList(nums);
        System.out.print("原始链表：");
        printList(node);

        ListNode result = solution.deleteDuplicates(node);
        System.out.print("去重后链表：");
        printList(result);
    }
}
