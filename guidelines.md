# Coding Test Study Guidelines

## 1. 클래스명 규칙

클래스명 뒤에 **언더스코어 + 번호**를 붙인다.

```java
public class BinaryOutput_2 { }
public class Factorial_1 { }
```

---

## 2. 커밋 메시지 스타일

```
기초부터 - step X - Y. 주제명

* 주요 사항 1
* 주요 사항 2
* 주요 사항 3
```

**예시:**
```
기초부터 - step 7 - 1. 팩토리얼

* 재귀 함수로 팩토리얼 계산
* n * factorial(n-1) 형태
```

---

## 3. 재귀함수 구조 (김태원 스타일)

**항상 if-else 구조로 작성, 함수명은 DFS로 통일**

```java
public 반환타입 DFS(int n) {
    if(조건) return 값;        // 베이스 케이스
    else {
        // 재귀 로직
        return DFS(...);
    }
}

반환타입 solution(int n) {
    return DFS(n);
}

public static void main(String[] args) {
    클래스명 T = new 클래스명();
    System.out.println(T.solution(5));
}
```

**특징:**
- static 키워드 사용 X (인스턴스 메서드)
- 함수명은 항상 DFS로 통일
- solution()으로 DFS를 감싸서 호출
- main에서 인스턴스 T 생성 후 T.solution() 호출

---

## 4. 좌표 표현 (큰돌 스타일)

**행을 y, 열을 x로 표현**

```java
static int[] dy = {-1, 0, 1, 0};
static int[] dx = {0, 1, 0, -1};
// 상, 우, 하, 좌
```

---

## 5. 상하좌우 이동 패턴 (큰돌 스타일 예시)

```java
package kundol.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2-D: 영역 구하기 - 백준 2583
 * https://www.acmicpc.net/problem/2583
 * DFS, BFS - int 반환 DFS
 * */
public class CalculateArea2583 {
    static int N, M, K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][] visited;
    static List<Integer> result;

    static int dfs(int y, int x) {
        if(visited[y][x] == 1) return 0;
        else {
            visited[y][x] = 1;
            int ret = 1;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >= 0 && ny < M && nx >= 0 && nx < N && map[ny][nx] != 1) {
                    ret += dfs(ny, nx);
                }
            }

            return ret;
        }
    }

//    static int dfs(int y, int x) {
//        visited[y][x] = 1;
//        int ret = 1;
//        for (int i = 0; i < 4; i++) {
//            int ny = y + dy[i];
//            int nx = x + dx[i];
//            if (ny < 0 || ny >= M || nx < 0 || nx >= N || visited[ny][nx] == 1) continue;
//            if (map[ny][nx] == 1) continue;
//            ret += dfs(ny, nx);
//        }
//        return ret;
//    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        visited = new int[M][N];
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[y][x] = 1;
                }
            }
        }
        
        result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1 && visited[i][j] == 0) {
                    result.add(dfs(i, j));
                }
            }
        }
        
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
```

**주요 포인트:**
- (y, x) 좌표로 2D 배열 접근
- dy, dx 배열로 상하좌우 이동
- 범위 체크 → 방문 체크 → 추가 조건 체크 순서
- dfs에서 int 반환으로 영역 크기 계산

---

## 6. Deque 사용 방법 (스택/큐)

**Import 규칙**
```java
import java.util.*;
```

**ArrayDeque 사용 (LinkedList보다 성능 우수)**

### 큐 (FIFO - First In First Out)
```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> queue = new ArrayDeque<>();
queue.offer(1);      // 뒤에 추가
queue.offer(2);      // 뒤에 추가
queue.offer(3);      // 뒤에 추가
// 결과: 1 2 3

int first = queue.poll();  // 1 (앞에서 제거)
// 남은 것: 2 3
```

### 스택 (LIFO - Last In First Out)
```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);       // 앞에 추가
stack.push(2);       // 앞에 추가
stack.push(3);       // 앞에 추가
// 결과: 3 2 1

int top = stack.pop();  // 3 (앞에서 제거)
// 남은 것: 2 1
```

**메서드 정리:**
- 큐: `offer()` (뒤에 추가) + `poll()` (앞에서 제거)
- 스택: `push()` (앞에 추가) + `pop()` (앞에서 제거)
- `isEmpty()`: 비었는지 확인

**변수명 규칙:**
- 큐 변수명: `queue`
- 스택 변수명: `stack`
---

## 7. 학습 방향

### 기초 학습 - 현재 학습중
- **김태원** 강사: 기초 개념, if-else 재귀 구조, DFS 패턴
- **큰돌** 강사: DFS/BFS, 2D 배열 탐색, (y, x) 좌표

### 실전 학습 - 예정
- **pyalgo.co.kr**: 카테고리별 알고리즘 문제 (정렬, 스택/큐, 투포인터, 해시맵 등)
- **삼성 SW 역량**: 기출 문제 (15년도부터 최신까지)
    - 15~18년도: 기초 단원 다지기
    - 19~21년도: 중급 문제 풀이
    - 22년도~현재: 최신 스타일 문제

### 혼합 스타일 - 예정
- 기초 개념 + 실전 패턴

---

**마지막 업데이트:** 2025-11-08