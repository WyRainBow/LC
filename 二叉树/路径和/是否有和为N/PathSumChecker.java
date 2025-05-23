package 二叉树.路径和.是否有和为N;

public class PathSumChecker {

    // 定义二叉树节点结构
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    // 检查是否存在路径和为 targetSum
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 如果是叶子节点
        if (root.left == null && root.right == null) {
            if(root.val==targetSum){
                return true;
            }
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        // 构造一个简单的二叉树
        /*
               5
              / \
             4   8
            /   / \
           11  13  4
          /  \
         7    2
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        int targetSum = 22;

        System.out.println("是否存在路径和为 " + targetSum + "？ " + hasPathSum(root, targetSum));
    }
}