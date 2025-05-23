package 二叉树.路径和.最大路径和;

public class MaxPathSumFinder {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // 重置全局最大值
        maxGain(root);
        return maxSum;
    }

    // 计算从当前节点出发，向左右子树能获得的最大路径和
    private static int maxGain(TreeNode node) {
        if (node == null) return 0;

        // 左右子树最大路径和，负数就不走
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 当前节点最大路径和 = 当前节点值 + 左最大 + 右最大
        int currentMaxPath = node.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxSum = Math.max(maxSum, currentMaxPath);

        // 返回当前节点能给父节点的最大贡献（只能选左或右）
        return node.val + Math.max(leftGain, rightGain);
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

        int maxPath = maxPathSum(root);
        System.out.println("最大路径和为：" + maxPath);
    }
}