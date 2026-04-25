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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val;
        int qValue = q.val;
        while(true) { 
            if(root.val == pValue) { 
                return p;
            }
            else if(root.val == qValue) {
                return q; 
            }
            else if(root.val > qValue && root.val > pValue) { 
                root = root.left;
            }
            else if(root.val < qValue && root.val < pValue) { 
                root = root.right;
            }
            else {
                return root;
            }
        }
    }
}
