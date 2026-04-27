/**class BinaryTreeCreate {
 static class Node {
 int data;
 Node left, right;

 Node(int data) {
 this.data = data;
 }
 }

 static Node insert(Node root, int value) {
 if (root == null) {
 return new Node(value);
 }

 if (value < root.data) {
 root.left = insert(root.left, value);
 } else {
 root.right = insert(root.right, value);
 }

 return root;
 }

 static void printTree(Node root) {
 if (root != null) {
 printTree(root.left);
 System.out.print(root.data + " ");
 printTree(root.right);
 }
 }

 public static void main(String[] args) {
 Node root = null;

 root = insert(root, 50);
 root = insert(root, 30);
 root = insert(root, 70);
 root = insert(root, 20);
 root = insert(root, 40);

 System.out.println("Created binary tree:");
 printTree(root);
 }
 }*/