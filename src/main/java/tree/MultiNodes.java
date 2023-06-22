package tree;

import java.util.List;

/**
 * 多叉树
 */
public class MultiNodes {
    public int val;
    public List<MultiNodes> children;
    public MultiNodes() {}
    public MultiNodes(int _val) {
        val = _val;
    }
    public MultiNodes(int _val, List<MultiNodes> _children) {
        val = _val;
        children = _children;
    }
}
