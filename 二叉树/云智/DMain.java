package 二叉树.云智;

import java.util.*;

class TreeNode {
    Integer val; // 改成 Integer 以支持 null
    TreeNode left;
    TreeNode right;

    TreeNode(Integer val) {
        this.val = val;
    }
}

public class DMain {
    public static void main(String[] args) {
        // 写死输入
        String[] str = {"1", "2", "3", "4", "null", "5", "null"};
        Integer[] nums = new Integer[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = str[i].equals("null") ? null : Integer.parseInt(str[i]);
        }

        TreeNode root = buildTreeWithNulls(nums);

        System.out.println("层序遍历结果：");
        printLevelOrderWithNulls(root);
    }

    // 构造保留 null 的二叉树（用于完整结构）
    public static TreeNode buildTreeWithNulls(Integer[] nums) {
        if (nums.length == 0 || nums[0] == null) return null;

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < nums.length) {
            TreeNode parent = queue.poll();
            if (parent != null) {
                // 构造左子节点
                if (i < nums.length) {
                    if (nums[i] != null) {
                        TreeNode leftChild = new TreeNode(nums[i]);
                        parent.left = leftChild;
                        queue.offer(leftChild);
                    } else {
                        parent.left = null;
                        queue.offer(null);
                    }
                    i++;
                }

                // 构造右子节点
                if (i < nums.length) {
                    if (nums[i] != null) {
                        TreeNode rightChild = new TreeNode(nums[i]);
                        parent.right = rightChild;
                        queue.offer(rightChild);
                    } else {
                        parent.right = null;
                        queue.offer(null);
                    }
                    i++;
                }
            }
        }
        return root;
    }

    // 层序打印（null 打印为 *）
    public static void printLevelOrderWithNulls(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    System.out.print("* ");
                    queue.offer(null); // 占位
                    queue.offer(null);
                } else {
                    System.out.print(node.val + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            System.out.println();

            // 如果队列全是 null，提前结束
            boolean allNull = true;
            for (TreeNode n : queue) {
                if (n != null) {
                    allNull = false;
                    break;
                }
            }
            if (allNull) break;
        }
    }
}