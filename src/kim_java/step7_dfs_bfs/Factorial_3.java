package kim_java.step7_dfs_bfs;

public class Factorial_3 {

    public int DFS(int n) {
        if(n == 1) return 1;        // 베이스 케이스
        else {
            return n * DFS(n - 1);
        }
    }

    int solution(int n) {
       return DFS(n);
    }

    public static void main(String[] args) {
        Factorial_3 T = new Factorial_3();
        System.out.println(T.solution(5));  // 출력: 120
    }
}
