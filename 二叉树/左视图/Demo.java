package 二叉树.左视图;


import java.util.*;

class TreeNode {
    int val;


    TreeNode left;

    TreeNode right;


    TreeNode(int val) {
        this.val = val;
    }
}

public class Demo {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = null; // ✅ 修正：直接赋值为 null
        root.left.right = new TreeNode(5);

        root.right.left = null; // ✅ 修正：直接赋值为 null
        root.right.right = new TreeNode(4);

        List<Integer> result = leftSide(root);
        System.out.println(result);
    }


    public static List<Integer> leftSide(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

}
