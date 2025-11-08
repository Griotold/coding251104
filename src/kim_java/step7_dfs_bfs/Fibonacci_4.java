package kim_java.step7_dfs_bfs;

public class Fibonacci_4 {

    static int[] arr;

    public int DFS(int n) {
        if(n <= 2) {
            return arr[n] = 1;
        }        // 베이스 케이스
        else {
            // 피보나치 구현
            return arr[n] = DFS(n - 1) + DFS(n - 2);
        }
    }

    void solution(int n) {
        DFS(n);
    }

    public static void main(String[] args) {
        Fibonacci_4 T = new Fibonacci_4();
        int n = 10;
        arr = new int[n + 1];
        T.solution(n);  // 출력: 1 1 2 3 5 8 13 21 34 55
        for(int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}