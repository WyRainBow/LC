package 二叉树.云智;

import java.util.*;

class TreeNode {
    Integer val; // 使用 Integer 以便支持 null 值
    TreeNode left;
    TreeNode right;

    TreeNode(Integer val) {
        this.val = val;
    }
}

public class DMain {

    // 层序打印（null 打印为 *）
    public static void printLevelOrderWithNulls(TreeNode root) {
        if (root == null) {
            System.out.println("*");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // 计算当前层的节点数

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // 取出当前层的一个节点

                if (node == null) {
                    System.out.print("* ");
                } else {
                    System.out.print(node.val + " ");
                    // 将左右子节点加入队列（即使为 null 也加入）
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            System.out.println(); // 换行，表示一层结束
        }
    }

    public static void main(String[] args) {
        // 构造二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = null; // 直接赋值为 null
        root.left.right = new TreeNode(5);

        root.right.left = null; // 直接赋值为 null
        root.right.right = new TreeNode(4);

        // 层序打印（null 打印为 *）
        printLevelOrderWithNulls(root);
    }
}