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
    int maxd = 0; 
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left==null && root.right==null))
            return 0;

        int left = height(root.left); 
        int right = height(root.right);
        maxd = Math.max(maxd, left + right);
        return maxd;    
        
    }

    // public int calculateMaxDiameter(TreeNode node) { 
    //     return height(node.left) + height(node.right);
    // }

    public int height(TreeNode node) { 
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);

        maxd = Math.max(maxd, left + right );
        return Math.max(left, right) + 1;
    }
}
