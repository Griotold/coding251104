package kim_java.step7_dfs_bfs;

public class BinaryOutput_2 {

    public void DFS(int n) {
        if(n == 0) {
            return;
        } else {
            DFS(n/2);
            System.out.print(n % 2);
        }
    }


    public void solution(int n) {
        DFS(n);
    }

    public static void main(String[] args) {
        BinaryOutput_2 T = new BinaryOutput_2();
        T.solution(11);  // 출력: 1011
    }
}