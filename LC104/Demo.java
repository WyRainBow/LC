package LC104;

public class Demo {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }


    public static int maxDepth(TreeNode root) {
        return depth(root);
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = null; // 不创建非法 TreeNode(null)
        node.right.left = null;
        node.right.right = new TreeNode(5);

        System.out.println("Max depth: " + maxDepth(node)); // 测试输出
    }
}
