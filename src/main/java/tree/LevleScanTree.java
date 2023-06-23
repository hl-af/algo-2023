package tree;

import com.sun.source.tree.ArrayAccessTree;
import org.junit.Test;

import java.util.*;

public class LevleScanTree {


    /**
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    List<Integer> simpleLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode temp = queue.remove();
            res.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return res;

    }



    @Test
    public void testSimpleLevelOrder() {
        TreeNode root = TreeUtils.getTreeDemo();
        List<Integer> res = simpleLevelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + ",");
        }
    }


    /**
     * LeetCode 107.给定⼀个⼆叉树，返回其节点值⾃底向上的层序遍历。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // 使用queue，不是LinkedList
        List<List<Integer>> res = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) { // 使用 isEmpty 判断，不是size

            List<Integer> level = new LinkedList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                level.add(temp.val);
            }
            res.add(0, level);

        }
        return res;

    }

    @Test
    public void testLevelOrderBottom() {

        TreeNode root = TreeUtils.getTreeDemo();
        List<List<Integer>> res = levelOrderBottom(root);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> level = res.get(i);
            for (int j = 0; j < level.size(); j++) {
                System.out.print(level.get(j) + ",");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // 测试 LinkedList 特性
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.remove());
        }
    }

}
