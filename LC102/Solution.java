package LC102;

import java.util.*;

public class Solution {

    // TreeNode 内部类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 正确的层序遍历实现（使用队列而不是栈）
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // 入队根节点

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // 当前层节点数
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();  // 出队
                level.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(level);
        }

        return result;
    }

    // 构建二叉树（层序遍历方式）
    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null) return null;

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < nums.length) {
            TreeNode node = queue.poll();

            if (nums[index] != null) {
                node.left = new TreeNode(nums[index]);
                queue.offer(node.left);
            }
            index++;

            if (index < nums.length && nums[index] != null) {
                node.right = new TreeNode(nums[index]);
                queue.offer(node.right);
            }
            index++;
        }

        return root;
    }


    public static void main(String[] args) {
        Solution.TreeNode root = Solution.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Solution sol = new Solution();
        List<List<Integer>> result = sol.levelOrder(root);
        System.out.println(result);  // 输出 [[3], [9, 20], [15, 7]]
    }


}