import javax.swing.tree.TreeNode;

public class BSTSearch {
    public boolean exist(TreeNode root, int target) {

        if (root != null) {
            if (root.value == target) {
                return true;
            }
            if (target < root.value) {
                return exist(root.left, target);
            }
            if (target > root.value) {
                return exist(root.right, target);
            }
        }      return false;

    }
}
