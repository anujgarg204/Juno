import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    Node root;

    public Tree(Node node) {
        root = node;
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    static class BTNode{
        int val;
        Node left;
        Node right;

        public BTNode(int val){
            this.val = val;
        }
        public BTNode(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public void displayRecursive(Node root) {
        // for (Node child : root.children) {
        //     displayRecursive(child);
        // }

        // print self
        System.out.print(root.val + " -> ");
        // print children
        for (Node child : root.children) {
            System.out.print(child.val + " ");
        }
        System.out.println();
        for (Node child : root.children) {
            displayRecursive(child);
        }
        System.out.println();
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

    // Assuming child will not be parent of 'Node parent'
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
        
        if(!isPartOfTree){
            System.out.println("We added the node...but parent is not a part of tree");
        }

        return;
    }

    public int findSize(Node root){
        if(root == null){return 0;}

        int size = 0;
        for(Node child: root.children){
            size += findSize(child);
        }
        return size + 1;
    }

    public int findSizeIterative(Node root){
        int size = 0;
        Queue<Node> queue = new LinkedList<>();

        if(root == null)return size;

        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            size++;

            for(Node child: node.children){
                queue.add(child);
            }
        }
        return size;
    }


    // tree -> delete Node
    // tree -> isEmpty
    // tree -> Depth
    // tree -> equals
    // tree -> Remove at position
    // tree -> NodeWithMaxChildren
    // tree -> Number of leaves
    // tree -> Level of a node
    
    // tree -> Ancestor of Node
    // tree -> Path of node
    // tree -> check parent/are Siblings (Do 2 nodes have same parents)
    // tree -> Swap Nodes
    // tree -> population at a level


    // print post/pre in 1 iterative solution
    // levelOrder zigZag

    // Class -> Int val: Tree (TreeIterator)

    private boolean isPartOfTree(Node node, Node root) {
        if(root == null)return false;

        if(node.equals(root)){
            return true;
        }

        boolean check = false;
        
        for(Node child : root.children){
            if(isPartOfTree(node, child)){
                return true;
            }
        }
        return check;
    }

    public void levelOrderUsingNull(Node root){
        Queue<Node> queue = new LinkedList<>();

        if(root == null)return;

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node currNode = queue.poll();

            if(currNode == null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }else{
                System.out.print(currNode.val+" ");
                // add child to queue
                for(Node child: currNode.children){
                    queue.add(child);
                }
            }
        }
    }

    

    public static void main(String[] args) {

        Node root = new Node(10);
        Tree tree = new Tree(root);

        Node c1 = new Node(20);
        Node c2 = new Node(30);
        Node c1c1 = new Node(25);
        Node c1c2 = new Node(35);
        Node c2c1 = new Node(15);
        Node c2c2 = new Node(45);
        Node c2c2c1 = new Node(75);

        tree.addChild(root, c1);
        tree.addChild(root, c2);
        tree.addChild(c1,c1c1 );
        tree.addChild(c1, c1c2);
        tree.addChild(c2, c2c1);
        tree.addChild(c2, c2c2);
        tree.addChild(c2c2, c2c2c1);

        // tree.displayRecursive(root);
        // tree.displayIterative(root);
        // System.out.println(tree.findSize(root));
        // System.out.println(tree.findSizeIterative(root));

        tree.levelOrderUsingNull(root);
    }
}
