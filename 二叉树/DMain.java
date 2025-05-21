package 二叉树;

import java.util.*;


public class DMain {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode buildTree(Integer[] nums) {

        if (nums == null || nums.length == 0 || nums[0] == null) {
            return null;
        }


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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入二叉树（用,分隔，null表示空节点）：");
        String s = sc.nextLine();
        String[] str = s.split(",");
        Integer[] nums = new Integer[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("null")) {
                nums[i] = null;
            } else {
                nums[i] = Integer.parseInt(str[i]);
            }
        }


        TreeNode root = buildTree(nums);


        List<List<Integer>> result = levelOrder(root);

        System.out.println("层序遍历结果：");
        for (List<Integer> level : result) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}