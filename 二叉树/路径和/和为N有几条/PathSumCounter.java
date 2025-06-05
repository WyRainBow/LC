package 二叉树.路径和.和为N有几条;

import java.util.ArrayList;
import java.util.List;


//从根节点开始到叶子节点结束->路径总和2
public class PathSumCounter {

    // 定义二叉树节点结构
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 主函数：查找所有路径并打印
    public static void main(String[] args) {
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

        List<List<Integer>> allPaths = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), allPaths);

        System.out.println("共有路径数： " + allPaths.size());
        for (List<Integer> path : allPaths) {
            System.out.println("路径：" + path);
        }
    }

    // 回溯法查找所有路径
    public static void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> resultPaths) {
        if (node == null) return;


        currentPath.add(node.val);

        // 如果是叶子节点且路径和刚好等于 targetSum
        if (node.left == null && node.right == null && targetSum == node.val) {
            resultPaths.add(new ArrayList<>(currentPath));
        } else {
            // 继续递归左右子树
            findPaths(node.left, targetSum - node.val, currentPath, resultPaths);
            findPaths(node.right, targetSum - node.val, currentPath, resultPaths);
        }

        // 回溯：移除当前节点以便尝试其他路径
        currentPath.remove(currentPath.size() - 1);
    }
}