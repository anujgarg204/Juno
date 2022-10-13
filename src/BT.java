public class BT {
    Node root;

    public BT(Node node) {
        this.root = node;
    }

    // Binary tree node
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }



    public static void main(String[] args) {
        Node root = new Node(10);

        BT bt = new BT(root);

        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);
        Node d = new Node(50);
        Node e = new Node(60);
        Node f = new Node(70);
        Node g = new Node(80);

        bt.addNode(a, b);
        bt.addNode(c, d);
        bt.addNode(e, f);
        bt.addNode(a, c);
        bt.addNode(root, a);

        

        // bt.printTree(root);

    }

    private void addNode(Node parent, Node child) {
        if (parent.left == null) {
            parent.left = child;
            System.out.println("Added to the left side of the node");
            return;
        }

        if (parent.right == null) {
            parent.right = child;
            System.out.println("Added to the right side of the node");
            return;
        }

        System.out.println("Cannot add to the node. Both positions already occupied.");
    }

    private void printTree(Node root){
        if(root == null)return;

        System.out.print(root.val + "-> ");
        if(root.left != null){
            System.out.print(root.left.val+" ");
        }

        if(root.right != null){
            System.out.print(root.right.val+" ");
        }

        System.out.println();

        if(root.left != null){
            printTree(root.left);
        }

        if(root.right != null){
            printTree(root.right);
        }
    }
}
