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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        iterateNode(root, list);  
        int prev = Integer.MIN_VALUE;
        for( int num : list ) { 
            if(num <=prev) return false;
            prev = num;
        } 
        return true; 
    }
    public void iterateNode(TreeNode node, List<Integer> list) { 
        if(node == null) return;
        iterateNode(node.left, list);
        list.add(node.val);
        iterateNode(node.right, list);
    }
}
