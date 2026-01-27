package Tree;

import javax.swing.tree.TreeNode;

public class SameTree {
  class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both null
        if (p == null && q == null) return true;

        // Case 2: one null
        if (p == null || q == null) return false;

        // Case 3: values not equal
        if (p.val != q.val) return false;

        // Check left and right subtree
        return isSameTree(p.left, q.left) && 
               isSameTree(p.right, q.right);
    }
}

}
