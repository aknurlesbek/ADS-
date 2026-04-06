class BinaryTreeTask3 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int evenCount = 0;
    static int oddCount = 0;

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

    static void countEvenOdd(Node root) {
        if (root != null) {
            countEvenOdd(root.left);

            if (root.data % 2 == 0) evenCount++;
            else oddCount++;

            countEvenOdd(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 10);
        root = insert(root, 5);
        root = insert(root, 15);
        root = insert(root, 2);
        root = insert(root, 7);
        root = insert(root, 12);
        root = insert(root, 20);

        System.out.println("Created binary tree:");
        printTree(root);

        countEvenOdd(root);
        System.out.println("\nEven count: " + evenCount);
        System.out.println("Odd count: " + oddCount);
    }
}