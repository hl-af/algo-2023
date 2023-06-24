package tree;

import org.junit.Test;

public class TreeHeight {

    // 104题最⼤深度:给定⼀个⼆叉树，找出其最⼤深度。⼆
    public int maxDepth(TreeNode root) {

        if (root.left == null && root.right == null) {
            return 1;
        }
        int rightHeight = 0;
        if (root.right != null) {
            rightHeight = maxDepth(root.right);
        }

        int leftHeight = 0;
        if (root.left != null) {
            leftHeight = maxDepth(root.left);
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }

    @Test
    public void testMaxDepth() {
        TreeNode root = TreeUtils.getTreeDemo();
        int depth = maxDepth(root);
        System.out.println(depth);

    }

    /**
     * LeetCode110 判断平衡⼆叉树：给定⼀个⼆叉树，判断它是否是⾼度平衡的⼆叉树:⼀个⼆叉树每个节点 的左右两个⼦树的⾼度差的绝对值不超过 1 。
     * @param root
     * @return
     */
    public int isAvlTree(TreeNode root) {

        if (root.left == null && root.right == null) {
            return 1;
        }

        int rightDeepth = 0;
        if (root.left != null) {
            rightDeepth = isAvlTree(root.left);
        }

        int leftDeepth = 0;
        if (root.right != null) {
            leftDeepth = isAvlTree(root.right);
        }

        if (Math.abs(leftDeepth - rightDeepth) > 1) {
            return -1;
        }else {
            return Math.max(leftDeepth, rightDeepth) + 1;
        }

    }

    @Test
    public void testIsAvlTree() {
        TreeNode root = TreeUtils.getTreeDemo2();
        int depth = isAvlTree(root);
        System.out.println(depth);
    }


    // LeetCode111就是：给定⼀个⼆叉树，找出其最⼩深度。
    public int minDepth(TreeNode root) {

        if (root.right == null && root.left == null) {
            return 1;
        }

        int leftDeepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDeepth = minDepth(root.left);
        }

        int rightDeepth = Integer.MAX_VALUE;
        if (root.right != null) {
            rightDeepth = minDepth(root.right);
        }

        return Math.min(rightDeepth, leftDeepth) + 1;

    }

    @Test
    public void testMinDepth() {
        TreeNode root = TreeUtils.getTreeDemo2();
        int depth = minDepth(root);
        System.out.println(depth);
    }



}
