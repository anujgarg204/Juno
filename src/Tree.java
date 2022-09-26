import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    public void displayRecursive(Node root) {
        for (Node child : root.children) {
            displayRecursive(child);
        }

        System.out.println();

        // print self
        System.out.print(root.val + " -> ");
        // print children
        for (Node child : root.children) {
            System.out.print(child.val + " ");
        }
        // System.out.println();
        // for (Node child : root.children) {
        //     displayRecursive(child);
        // }
    }

    public void displayIterative(Node root) {
        // queue
        Queue<Node> queue = new LinkedList<>();

        // root -> queue
        if (root != null) {
            queue.add(root);
        }

        // !queue.isEmpty()
        while (!queue.isEmpty()) {
            // pop
            Node node = queue.poll();

            // print self
            System.out.print(node.val + " -> ");
            
            for(Node child: node.children){
            // print child
            System.out.print(child.val+" ");
            // add to queue child
            queue.add(child);
            }
            System.out.println();
        }
    }

    public void addChild(Node parent, Node child){
        // parent null
        if(parent == null){
            System.out.println("Abe pagla gye ho kya???");
            return;
        }
        // chiild null
        if(child == null){
            System.out.println("Kyun thak rhe ho!!");
            return;
        }
        
        parent.children.add(child);

        boolean isPartOfTree = isPartOfTree(parent, root);

        return;
    }

    // tree -> Add node
    // tree -> Find node
    // tree -> delete Node
    // tree -> Add at position
    // tree -> Find size
    // tree -> isEmpty
    // tree -> Depth
    // tree -> equals
    // tree -> Remove at position
    // tree -> NodeWithMaxChildren
    // tree -> Number of leaves
    // tree -> Level of a node
    // tree -> IsNodeLeaf
    // tree -> Ancestor of Node
    // tree -> Path of node
    // tree -> check parent/are Siblings (Do 2 nodes have same parents)
    // tree -> Swap Nodes
    // tree -> population at a level

    // Agenda-> iterative as well as recursive

    // 10 -> 20, 30, 40
    // 20 -> 5, 50
    // 30 -> 60, 100
    // 40 ->
    // 5 ->
    // 50 ->
    // 60 ->
    // 100 ->

    private boolean isPartOfTree(Node node, Node root) {
        if(node == root){
            return true;
        }

        boolean check = false;

        for(Node child: root.children){
          if(child == node){
                return true;
            }
        }
        
        for(Node child : root.children){
            check = check || isPartOfTree(node, child);
        }
        return check;
    }

    public static void main(String[] args) {

        Node node = new Node(10);

        // Node children:
        Node nodec1 = new Node(20);
        Node nodec2 = new Node(30);
        Node nodec3 = new Node(40);

        node.children.add(nodec1);
        node.children.add(nodec2);
        node.children.add(nodec3);

        // node c1 ke child
        Node nodec1c1 = new Node(5);
        Node nodec1c2 = new Node(50);

        // node c2 ke child
        Node nodec2c1 = new Node(60);
        Node nodec2c2 = new Node(100);

        // Add nodec1 ke child

        nodec1.children.add(nodec1c1);
        nodec1.children.add(nodec1c2);

        // Node c2 ke child addition yojna

        nodec2.children.add(nodec2c1);
        nodec2.children.add(nodec2c2);

        Tree tree = new Tree();
        tree.displayRecursive(node);
        // tree.displayIterative(node);
    }
}
