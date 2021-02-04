package com.jarvi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTree105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            int val = inorder[i];
            map.put(val, i);
        }

        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight, Map<Integer, Integer> map) {
        //终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        //处理当前逻辑
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);

        //递归到下一层
        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, inLeft, pIndex - 1, map);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, pIndex + 1, inRight, map);

        return root;
    }

}
