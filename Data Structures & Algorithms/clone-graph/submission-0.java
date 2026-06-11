/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> copied; 

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        copied = new HashMap<>();
        return dfs(node);
    }

    public Node dfs(Node currNode) { 
        if(currNode == null) return null;
        if(copied.containsKey(currNode)) { 
            return copied.get(currNode);
        }

        Node copy = new Node(currNode.val);
        copied.put(currNode, copy);
        for(Node neighbor : currNode.neighbors) { 
            copy.neighbors.add(dfs(neighbor));
        }
        return copy;
    }
}