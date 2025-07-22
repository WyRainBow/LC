package LCsss.二叉树.构造二叉树.方法二;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 根据数组构建二叉树
    public TreeNode buildTree(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        return buildTreeHelper(arr, 0);
    }

    private TreeNode buildTreeHelper(int[] arr, int i) {
        if (i >= arr.length) return null; // 如果索引超出范围返回null

        TreeNode node = new TreeNode(arr[i]); // 当前节点值为arr[i]
        node.left = buildTreeHelper(arr, 2 * i + 1); // 左子节点
        node.right = buildTreeHelper(arr, 2 * i + 2); // 右子节点

        return node;
    }

    // 打印树的层序遍历
    public static void printLevelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    System.out.print(node.val + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = {0, 1, 2, 3, 4, 5, 6};

        TreeNode root = tree.buildTree(arr);
        tree.printLevelOrder(root); // 打印层序遍历
    }
}
