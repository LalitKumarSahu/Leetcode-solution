import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
  // m-1 level order traversal
  class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = root.val; // initialize with root

        while (!q.isEmpty()) {
            int size = q.size();
            ans = q.peek().val; // har level ka leftmost node

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return ans; // last level ka leftmost value
    }
}

}
