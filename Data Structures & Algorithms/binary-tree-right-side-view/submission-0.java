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
    public List<Integer> rightSideView(TreeNode root) {
        int currLevel = 1; 
        List<Integer> rightSide = new ArrayList<>();
        if(root == null) return rightSide;
        rightSide.add(root.val);
        fillList(root.right, rightSide, currLevel + 1);
        fillList(root.left, rightSide, currLevel + 1);
        return rightSide; 

    }

    public void fillList(TreeNode node, List<Integer> rightSide, int currLevel) { 
        if(node!= null) { 
            if(currLevel>rightSide.size()) {
                rightSide.add(node.val);
            } 
            fillList(node.right, rightSide, currLevel + 1);
            fillList(node.left, rightSide, currLevel + 1);
        }
    }
}
