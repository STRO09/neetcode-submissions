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

public class Codec {
    int currIndex = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeNode(root, sb);
        if(sb.charAt(sb.length()-1)==',') sb.deleteCharAt(sb.length()-1);
        return sb.toString();    
    }

    public void serializeNode(TreeNode node, StringBuilder sb) { 
        if( node == null) { 
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeNode(node.left, sb);
        serializeNode(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        TreeNode root = deserializeNode(nodes);
        return root;
    }

    public TreeNode deserializeNode(String[] nodes) { 
        if(currIndex > nodes.length) return null;
        if(nodes[currIndex].equals("null")) { 
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[currIndex]));
        this.currIndex++;
        node.left = deserializeNode(nodes);
        this.currIndex++;
        node.right = deserializeNode(nodes);
        return node;
    }
}
