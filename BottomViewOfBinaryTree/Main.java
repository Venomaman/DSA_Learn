package BottomViewOfBinaryTree;

import java.util.*;

// Main class to run the example
public class Main {
    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        // Create an instance of Solution
        Solution solution = new Solution();

        // Get the bottom view of the binary tree
        ArrayList<Integer> bottomView = solution.bottomView(root);

        // Print the bottom view
        System.out.println("Bottom view of the binary tree:");
        for (int value : bottomView) {
            System.out.print(value + " ");
        }
    }
}
