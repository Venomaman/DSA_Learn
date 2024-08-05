package BottomViewOfBinaryTree;

import java.util.*;

// Solution class containing the bottomView method
public class Solution {
    // Class to store the node and its horizontal distance
    class Pair {
        Node n;
        int hd;

        public Pair(Node n, int hd) {
            this.n = n;
            this.hd = hd;
        }
    }

    // Method to return a list containing the bottom view of the given tree
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = 0, max = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Pair curr = q.poll();
                min = Math.min(min, curr.hd);
                max = Math.max(max, curr.hd);
                map.put(curr.hd, curr.n.data);
                if (curr.n.left != null)
                    q.add(new Pair(curr.n.left, curr.hd - 1));
                if (curr.n.right != null)
                    q.add(new Pair(curr.n.right, curr.hd + 1));
                size--;
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}
