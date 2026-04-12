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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootstr = preOrderTraversalString(root);
        String subrootstr = preOrderTraversalString(subRoot);
        return rootstr.contains(subrootstr);

    }


    public String preOrderTraversalString(TreeNode node) { 
        StringBuilder result = new StringBuilder();
        if(node == null) return result.toString();
        traverse(node, result);
        return result.toString();
    }

    public void traverse(TreeNode node, StringBuilder str) { 
        if(node == null) str.append('#');
        else {
            str.append(node.val);
            traverse(node.left, str);
            traverse(node.right, str); 
        }
    }
}
