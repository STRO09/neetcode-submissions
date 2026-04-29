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
    int k = 0; 
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        this.k = k;
        inOrderTraversal(root, list);
        return (list.size() > 0 ? list.get(list.size() -1) : -1);
            
    }
    public void inOrderTraversal(TreeNode node, List<Integer> list) { 
        if(node == null) return; 
        inOrderTraversal(node.left, list); 
        if(list.size() == this.k ) return; 
        list.add(node.val);
        if(list.size() == this.k ) return; 
        inOrderTraversal(node.right, list);
    }
}
