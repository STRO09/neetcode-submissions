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
    int count = 1;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0; 
        checkNode(root.left, root.val);
        checkNode(root.right, root.val); 
        return this.count;      
    }

    public void checkNode(TreeNode node, int currMax) { 
        if(node != null) { 
            if(node.val >= currMax) { 
                currMax = node.val;
                this.count++;
            }
            checkNode(node.left, currMax);
            checkNode(node.right, currMax);
        }
    }
}
