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

    int currIndex = 0; 
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i= 0; i < inorder.length ; i++) { 
            inOrderMap.put(inorder[i],i);
        }
        TreeNode root = build(preorder, 0, inorder.length-1);
        return root;
    }

    public TreeNode build(int[] preorder, int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[currIndex++]);
        root.left = build(preorder, start, inOrderMap.get(root.val) -1);
        root.right = build(preorder, inOrderMap.get(root.val)+1, end);
        return root;

    }

}
