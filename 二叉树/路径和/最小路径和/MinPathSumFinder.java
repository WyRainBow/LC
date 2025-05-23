package 二叉树.路径和.最小路径和;

public class MinPathSumFinder {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int minPathSum(TreeNode root) {
        if (root == null) return 0;

        // 如果是叶子节点，返回它的值
        if (root.left == null && root.right == null) {
            return root.val;
        }

        // 左右子树的最小路径和，如果某一边为空，不能算它
        int leftMin = root.left != null ? minPathSum(root.left) : Integer.MAX_VALUE;
        int rightMin = root.right != null ? minPathSum(root.right) : Integer.MAX_VALUE;

        // 当前节点加上左右子树中较小的那个路径和
        return root.val + Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        int minPath = minPathSum(root);
        System.out.println("最小根到叶子路径和为：" + minPath);
    }
}