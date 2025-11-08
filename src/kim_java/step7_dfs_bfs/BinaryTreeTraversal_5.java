package kim_java.step7_dfs_bfs;

public class BinaryTreeTraversal_5 {

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

    public void preOrder(Node node) {
        if(node == null) return;        // 베이스 케이스
        else {
            System.out.print(node.val + " ");  // 전위: 출력 먼저
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if(node == null) return;        // 베이스 케이스
        else {
            inOrder(node.left);
            System.out.print(node.val + " ");  // 중위: 중간에 출력
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if(node == null) return;        // 베이스 케이스
        else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + " ");  // 후위: 마지막에 출력
        }
    }

    void solution() {
        // 트리 구성 (구현)
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

        preOrder(node1);
        System.out.println();
        inOrder(node1);
        System.out.println();
        postOrder(node1);

    }

    public static void main(String[] args) {
        BinaryTreeTraversal_5 T = new BinaryTreeTraversal_5();
        T.solution();
    }
}