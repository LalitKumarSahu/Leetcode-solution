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
   
// m-2 by using dfs
class Solution2{
    int maxDepth = -1;
    int ans = -1;
    public int findBottomLeftValue2(TreeNode root) {
      dfs(root, 0);
      return ans;
    }
    public void dfs2(TreeNode root, int depth){
        //postorder
        if(root == null){
            return;
        }
        // root
        if(depth > maxDepth){
            maxDepth = depth;
            ans = root.val;
        }
        //left,right
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);

    }
}
}
