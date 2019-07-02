package com.rick.easy;

/**
 * 226. 翻转二叉树
 *
 * @author : Rick Ma at 2019/7/1 16:34
 */
public class InvertTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        if (root.left != null) {
//            invertTree(root.left);
//        }
//        if (root.right != null) {
//            invertTree(root.left);
//        }
        return null;
    }


    public static void iterator(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) {
            iterator(node.left);
        }
        if (node.right != null) {
            iterator(node.right);
        }
    }


    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        node4.left=node2;
        node4.right=node7;

        node2.left=node1;
        node2.right=node3;

        node7.left=node6;
        node7.right=node9;

        iterator(node4);
        System.out.println(node4);
    }
}
