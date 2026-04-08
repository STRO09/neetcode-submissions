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
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left== null && root.right == null)) 
            return root;
        
        invertNode(root);
        return root;

    }

    public int invertNode(TreeNode node) { 
        if(node== null) return 0;
        TreeNode curr = node;
        if(curr.left == null && curr.right == null) return 0;  
        swapNodes(curr);
        invertNode(curr.left);
        invertNode(curr.right);
        return 0;
    }

    public void swapNodes(TreeNode curr) { 
        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;
    }
}
