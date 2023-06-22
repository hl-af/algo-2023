package tree;

import com.sun.source.tree.ArrayAccessTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
