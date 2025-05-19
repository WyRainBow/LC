package LC124;

/**
 * 0519
 */
class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }


        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxSum = 0;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }

    private static int maxPath(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));

        maxSum = Math.max(maxSum, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}