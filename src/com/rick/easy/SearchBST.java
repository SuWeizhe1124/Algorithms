package com.rick.easy;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @author : Rick Ma at 2019/7/2 15:11
 */
public class SearchBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root.left != null) {
            if (root.left.val == val) {
                return root.left;
            } else {
                return searchBST(root.left, val);
            }
        }
        if (root.right != null) {
            if (root.right.val == val) {
                return root.right;
            } else {
                return searchBST(root.right, val);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;

        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;


        TreeNode result = new SearchBST().searchBST(treeNode4, 2);
        System.out.println(JSONObject.toJSONString(result));


    }
}
