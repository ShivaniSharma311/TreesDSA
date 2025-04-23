import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BinaryTreeOperations {

    // 1. Find Height
    static int findHeight(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    // 2. Count Nodes
    static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 3. Search a Value
    static boolean search(Node root, int target) {
        if (root == null) return false;
        if (root.value == target) return true;
        return search(root.left, target) || search(root.right, target);
    }

    // 4. Count Leaf Nodes
    static int countLeafNodes(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    // 5. Sum of All Nodes
    static int sumOfNodes(Node root) {
        if (root == null) return 0;
        return root.value + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    // 6. Print Nodes at a Level
    static void printNodesAtLevel(Node root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.value + " ");
        } else {
            printNodesAtLevel(root.left, level - 1);
            printNodesAtLevel(root.right, level - 1);
        }
    }

    // 7. Insert a Node (Level Order)
    static Node insertNode(Node root, int value) {
        Node newNode = new Node(value);
        if (root == null) return newNode;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                break;
            } else queue.add(current.left);

            if (current.right == null) {
                current.right = newNode;
                break;
            } else queue.add(current.right);
        }

        return root;
    }

    // Main method to test
    public static void main(String[] args) {
        Node root = new Node(10);
        root = insertNode(root, 20);
        root = insertNode(root, 30);
        root = insertNode(root, 40);
        root = insertNode(root, 50);

        System.out.println("Height of tree: " + findHeight(root));
        System.out.println("Total nodes: " + countNodes(root));
        System.out.println("Leaf nodes: " + countLeafNodes(root));
        System.out.println("Sum of all nodes: " + sumOfNodes(root));
        System.out.println("Is 30 present? " + search(root, 30));
        System.out.println("Nodes at level 2: ");
        printNodesAtLevel(root, 2);  // level starts from 1
    }
}
