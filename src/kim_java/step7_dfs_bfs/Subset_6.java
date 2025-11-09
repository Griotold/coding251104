package kim_java.step7_dfs_bfs;

public class Subset_6 {

    static int N;
    static int[] ch;

    public void DFS(int n) {
        if(n > N) {
            for(int i = 1; i <= N; i++) {
                if(ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            ch[n] = 1;
            DFS(n+1);

            ch[n] = 0;
            DFS(n+1);
        }
    }

    void solution(int n) {
        N = n;
        ch = new int[N + 1];
        DFS(1);
    }

    public static void main(String[] args) {
        Subset_6 T = new Subset_6();
        T.solution(3);  // 출력: 부분집합들
    }
}