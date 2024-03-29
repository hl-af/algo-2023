package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {

    /**
     * 普通二叉树 1，2，3，4，5，6，7，8
     * @return
     */
    public static TreeNode getTreeDemo() {
        TreeNode root = new TreeNode(1);
        int num = 2;
        root.left = new TreeNode(num++);
        root.right = new TreeNode(num++);
        root.left.left = new TreeNode(num++);
        root.left.right = new TreeNode(num++);
        root.right.left = new TreeNode(num++);
        root.right.right = new TreeNode(num++);
        return root;
    }

    /**
     * 只有右边的二叉树
     * @return
     */
    public static TreeNode getTreeDemo2() {
        TreeNode root = new TreeNode(1);
        int num = 2;
        root.right = new TreeNode(num++);
        root.right.left = new TreeNode(num++);
        root.right.right = new TreeNode(num++);
        root.right.right.left = new TreeNode(num++);
        root.right.right.right = new TreeNode(num++);
        return root;
    }

    /**
     * 对称二叉树
     * @return
     */
    public static TreeNode getTreeDemo3() {
        TreeNode root = new TreeNode(1);
        int num = 2;
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        return root;
    }
    /**
     * 方法1：比较粗糙的创建二叉树关系
     */
    public static TreeNode buildBinaryTree() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);
        return node;
    }

    /**
     * 与1对称的新二叉树
     *
     * @return
     */
    public static TreeNode buildBinaryTree2() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(20);
        node.right = new TreeNode(9);
        node.left.right = new TreeNode(15);
        node.left.left = new TreeNode(7);
        return node;

    }

    public static void printTree(List<Integer> res) {
        res.stream().forEach(num -> System.out.print(num + ","));
    }

    public static MultiNodes getNnodeTreeDemo(int n) {
        int num = 1;
        MultiNodes multiNodes = new MultiNodes(num++);
        List<MultiNodes> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new MultiNodes(num++));
        }
        multiNodes.children = children;
        MultiNodes multiNodes1 = children.get(0);
        List<MultiNodes> children1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children1.add(new MultiNodes(num++));
        }
        multiNodes1.children = children1;
        return multiNodes;
    }
}
