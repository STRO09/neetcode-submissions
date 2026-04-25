/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bst = new ArrayList<>();

        fillList(root, bst, 0);
        return bst;
    }

    public void fillList(TreeNode node, List<List<Integer>> bst, int level) { 
        if(node!=null) { 
            if(bst.size() < level+1) bst.add(new ArrayList<Integer>());
            bst.get(level).add(node.val);

            fillList(node.left, bst, level+1);
            fillList(node.right, bst, level+1);
        }
    }
}
