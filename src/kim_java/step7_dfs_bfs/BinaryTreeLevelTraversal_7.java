package kim_java.step7_dfs_bfs;

import java.util.*;

public class BinaryTreeLevelTraversal_7 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }

        void setLeft(Node node) {
            this.left = node;
        }

        void setRight(Node node) {
            this.right = node;
        }
    }

    public void levelOrder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);

        while(!deque.isEmpty()) {
            Node node = deque.poll();
            System.out.print(node.val + " ");

            if(node.left != null) deque.addLast(node.left);
            if(node.right != null) deque.addLast(node.right);
        }
    }

    void solution() {
        // 트리 구성 (1을 루트로)
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.setLeft(node2);
        node1.setRight(node3);

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.setLeft(node4);
        node2.setRight(node5);

        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node3.setLeft(node6);
        node3.setRight(node7);

        // 레벨탐색 출력
        levelOrder(node1);  // 출력: 1 2 3 4 5 6 7
    }

    public static void main(String[] args) {
        BinaryTreeLevelTraversal_7 T = new BinaryTreeLevelTraversal_7();
        T.solution();
    }
}