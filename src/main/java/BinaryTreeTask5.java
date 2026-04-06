class BinaryTreeTask5 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.data) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);

        return root;
    }

    static void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    static boolean isEmpty(Node root) {
        return root == null;
    }

    static Node deleteTree(Node root) {
        return null;
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 25);
        root = insert(root, 15);
        root = insert(root, 35);
        root = insert(root, 10);
        root = insert(root, 20);

        System.out.println("Created binary tree:");
        printTree(root);

        System.out.println("\nIs tree empty? " + isEmpty(root));

        root = deleteTree(root);
        System.out.println("After deleting tree:");
        System.out.println("Is tree empty? " + isEmpty(root));
    }
}