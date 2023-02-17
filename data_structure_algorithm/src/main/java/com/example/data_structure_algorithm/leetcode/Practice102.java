package com.example.data_structure_algorithm.leetcode;

import java.util.*;

/**
 * @Author: sidao.zhu
 * @Date: 2021/12/24
 */
public class Practice102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>(queue.size());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentTreeNode = queue.poll();
                if (currentTreeNode == null) {
                    continue;
                }
                list.add(currentTreeNode.val);
                if (currentTreeNode.left != null) {
                    TreeNode left = currentTreeNode.left;
                    queue.add(left);
                }
                if (currentTreeNode.right != null) {
                    TreeNode right = currentTreeNode.right;
                    queue.add(right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(4, 5, 6, 7, 8, 3);
        integers.sort(Comparator.comparing(key -> key, Comparator.reverseOrder()));
        System.out.println(integers);

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
