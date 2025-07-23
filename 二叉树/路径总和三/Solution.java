

class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        // 从当前节点开始计算所有符合条件的路径
        result += path(root, targetSum);
        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);

        return result;
    }

    public static int path(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val == targetSum) {
            count++;
        }

        // 继续递归左子树和右子树，目标值要减去当前节点值
        count += path(root.left, targetSum - root.val);
        count += path(root.right, targetSum - root.val);

        return count;
    }

    public static void main(String[] args) {
        // 手动创建二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution solution = new Solution();
        int result = solution.pathSum(root, 22);

        // 输出结果
        System.out.println("Number of paths: " + result);
    }
}
