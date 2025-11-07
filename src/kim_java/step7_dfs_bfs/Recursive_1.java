package kim_java.step7_dfs_bfs;

import java.util.*;

public class Recursive_1 {

    public void DFS(int n) {
        if(n==0) return;
        else {
            DFS(n-1);
            System.out.print(n + " ");
        }
    }

    public void solution(int n) {
        DFS(n);
    }

    public static void main(String[] args) {
        Recursive_1 T = new Recursive_1();
        T.solution(3);
    }
}
