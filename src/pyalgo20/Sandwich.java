package pyalgo20;

import java.util.*;

// 5. 샌드위치 포장 : 스택 | 큐
public class Sandwich {

    /**
     * 큐 방식으로 풀이
     * */
    private static boolean isValidSandwich(Deque<Integer> queue) {
        if (queue.size() < 5) return false;

        List<Integer> temp = new ArrayList<>(queue);
        int size = temp.size();

        return temp.get(size-5) == 1 &&
                temp.get(size-4) == 2 &&
                temp.get(size-3) == 3 &&
                temp.get(size-2) == 4 &&
                temp.get(size-1) == 1;
    }

    private static void removeSandwich(Deque<Integer> queue) {
        for(int i = 0; i < 5; i++) {
            queue.pollLast();
        }
    }

    public static int solutionByQueue(int[] ingredients) {
        // 큐 방식으로 구현
        // 패턴: 1, 2, 3, 4, 1
        Deque<Integer> queue = new ArrayDeque<>();
        int sandwichCount = 0;

        // 매번 마지막 5개가 [1, 2, 3, 4, 1]이면 제거하고 카운트 증가
        for(int i : ingredients) {
            queue.offer(i);

            // 큐의 크기가 5 이상이면 마지막 5개 확인
            if(isValidSandwich(queue)) {
                removeSandwich(queue);
                sandwichCount++;
            }
        }

        return sandwichCount;
    }

    /**
     * 스택으로 풀이
     * */
    private static boolean isValidSandwichStack(Deque<Integer> stack) {
        if(stack.size() < 5) return false;

        List<Integer> temp = new ArrayList<>(stack);
        int size = temp.size();

        // 스택은 LIFO이므로 패턴이 역순으로 확인!
        // 위에서부터: [1, 4, 3, 2, 1]
        return temp.get(0) == 1 &&    // 위(top)
                temp.get(1) == 4 &&
                temp.get(2) == 3 &&
                temp.get(3) == 2 &&
                temp.get(4) == 1;      // 아래
    }

    private static void removeSandwichStack(Deque<Integer> stack) {
        for(int i = 0; i < 5; i++) {
            stack.pop();  // 위에서 5개 제거
        }
    }

    public static int solutionByStack(int[] ingredients) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sandwichCount = 0;

        for(int i : ingredients) {
            stack.push(i);  // 위(앞)에 추가

            if(isValidSandwichStack(stack)) {
                removeSandwichStack(stack);
                sandwichCount++;
            }
        }

        return sandwichCount;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 1, 1, 2, 3, 4};
        System.out.println("입력: " + Arrays.toString(test1));
        System.out.println("출력(큐): " + solutionByQueue(test1));
        System.out.println("출력(스택): " + solutionByStack(test1));
        System.out.println("예상: 1\n");

        int[] test2 = {1, 1, 1, 2, 3, 4, 1, 2, 3, 4, 1};
        System.out.println("입력: " + Arrays.toString(test2));
        System.out.println("출력(큐): " + solutionByQueue(test2));
        System.out.println("출력(스택): " + solutionByStack(test2));
        System.out.println("예상: 2\n");

        int[] test3 = {1, 2, 3, 4, 2, 3, 4, 1};
        System.out.println("입력: " + Arrays.toString(test3));
        System.out.println("출력(큐): " + solutionByQueue(test3));
        System.out.println("출력(스택): " + solutionByStack(test3));
        System.out.println("예상: 0");
    }
}