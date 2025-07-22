package LCsss.二叉树.构造二叉树.方法一最简单;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {

    public static void main(String[] args) {
        // 手动构造二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        // 打印层序遍历结果（带null补位）
        printLevelOrder(root);
    }

    public static void printLevelOrder(TreeNode root) {
        
        //null就打印星号
        if (root == null) {
            System.out.println("*");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasNonNull = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    System.out.print(node.val + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                    if (node.left != null || node.right != null) {
                        hasNonNull = true;
                    }
                } else {
                    System.out.print("* ");
                    queue.offer(null);
                    queue.offer(null);
                }
            }
            System.out.println();

            if (!hasNonNull) break;
        }
    }
}