package com.rick.easy;

/**
 * 104. 二叉树的最大深度
 *
 * @author : Rick Ma at 2019/7/2 15:48
 */
public class MaxDepth {
    public static class TreeNode {
        int val;
        int path;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;

        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        System.out.println(new MaxDepth().maxDepth(treeNode3));
    }
//    private void itoretor(TreeNode node) {
//        TreeNode left = node.left;
//        if (left != null) {
//            left.path++;
//            itoretor(left);
//        }
//        TreeNode right = node.right;
//        if (right != null) {
//            right.path++;
//            itoretor(right);
//        }
//    }
}
