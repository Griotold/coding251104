package kim_java.step7_dfs_bfs;

import java.util.*;

public class FindCalf_8 {

    static final int MAX = 10001;
    static boolean[] visited;
    final static int[] dx = {1, -1, 5};

    public int BFS(int s, int e) {
        visited = new boolean[MAX];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        visited[s] = true;
        int L = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();  // 현재 레벨의 크기
            for(int i = 0; i < len; i++) {  // 이 레벨의 모든 노드만 처리
                int cur = queue.poll();
                for(int j = 0; j < 3; j++) {
                    int nx = cur + dx[j];
                    if(nx == e) {
                        return L + 1;  // 찾으면 바로 반환
                    }
                    if(nx >= 1 && nx <= 10000 && !visited[nx]) {
                        visited[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            L++;  // 레벨 증가
        }

        return 0;
    }

    void solution(int s, int e) {
        System.out.println(BFS(s, e));
    }

    public static void main(String[] args) {
        FindCalf_8 T = new FindCalf_8();

        // 테스트 예제 1
        T.solution(5, 14);  // 출력: 3

        // 테스트 예제 2
        T.solution(8, 3);   // 출력: 5
    }
}