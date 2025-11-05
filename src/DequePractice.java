import java.util.*;

// Deque 메서드 기능 확인
public class DequePractice {

    /**
     * // 큐 방식
     * queue.offer(i);    // 뒤에 추가
     * queue.poll();      // 앞에서 제거 (FIFO)
     *
     * // 스택 방식
     * stack.push(i);     // 앞에 추가
     * stack.pop();       // 앞에서 제거 (LIFO)
     * */
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println("=== Deque 메서드 기능 확인 ===\n");

        // 추가 메서드
        System.out.println("--- 추가 메서드 ---");
        deque.addFirst(1);
        System.out.println("addFirst(1): " + deque);

        deque.addLast(2);
        System.out.println("addLast(2): " + deque);

        deque.addFirst(0);
        System.out.println("addFirst(0): " + deque);

        deque.addLast(3);
        System.out.println("addLast(3): " + deque + "\n");

        // 조회 메서드
        System.out.println("--- 조회 메서드 (제거 X) ---");
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());
        System.out.println("현재 상태: " + deque + "\n");

        // 제거 메서드
        System.out.println("--- 제거 메서드 ---");
        System.out.println("removeFirst(): " + deque.removeFirst());
        System.out.println("현재 상태: " + deque);

        System.out.println("removeLast(): " + deque.removeLast());
        System.out.println("현재 상태: " + deque + "\n");

        // 큐 메서드
        System.out.println("--- 큐 메서드 (FIFO) ---");
        deque.clear();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println("offer(1, 2, 3): " + deque);
        System.out.println("peek(): " + deque.peek() + " (제거 X)");
        System.out.println("poll(): " + deque.poll() + " (제거 O)");
        System.out.println("현재 상태: " + deque + "\n");

        // 스택 메서드
        System.out.println("--- 스택 메서드 (LIFO) ---");
        deque.clear();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println("push(1, 2, 3): " + deque);
        System.out.println("peek(): " + deque.peek() + " (제거 X)");
        System.out.println("pop(): " + deque.pop() + " (제거 O)");
        System.out.println("현재 상태: " + deque + "\n");

        // 메서드 동치 확인
        System.out.println("=== 메서드 동치 확인 ===");
        deque.clear();

        System.out.println("\n[추가]");
        System.out.println("addFirst(x) == offerFirst(x) == push(x) ? 모두 앞에 추가");
        System.out.println("addLast(x) == offerLast(x) == offer(x) ? 모두 뒤에 추가");

        System.out.println("\n[제거]");
        System.out.println("removeFirst() == pollFirst() ? 모두 앞에서 제거");
        System.out.println("removeLast() == pollLast() ? 모두 뒤에서 제거");
        System.out.println("poll() == pollFirst() ? 모두 앞에서 제거 (큐 방식)");
        System.out.println("pop() == removeFirst() ? 모두 앞에서 제거 (스택 방식)");

        System.out.println("\n[조회]");
        System.out.println("getFirst() == peekFirst() == peek() ? 앞 조회");
        System.out.println("getLast() == peekLast() == peek(스택) ? 뒤 조회");
    }

    /**
     * === Deque 메서드 기능 확인 ===
     *
     * --- 추가 메서드 ---
     * addFirst(1): [1]
     * addLast(2): [1, 2]
     * addFirst(0): [0, 1, 2]
     * addLast(3): [0, 1, 2, 3]
     *
     * --- 조회 메서드 (제거 X) ---
     * getFirst(): 0
     * getLast(): 3
     * 현재 상태: [0, 1, 2, 3]
     *
     * --- 제거 메서드 ---
     * removeFirst(): 0
     * 현재 상태: [1, 2, 3]
     * removeLast(): 3
     * 현재 상태: [1, 2]
     *
     * --- 큐 메서드 (FIFO) ---
     * offer(1, 2, 3): [1, 2, 3]
     * peek(): 1 (제거 X)
     * poll(): 1 (제거 O)
     * 현재 상태: [2, 3]
     *
     * --- 스택 메서드 (LIFO) ---
     * push(1, 2, 3): [3, 2, 1]
     * peek(): 3 (제거 X)
     * pop(): 3 (제거 O)
     * 현재 상태: [2, 1]
     *
     * === 메서드 동치 확인 ===
     *
     * [추가]
     * addFirst(x) == offerFirst(x) == push(x) ? 모두 앞에 추가
     * addLast(x) == offerLast(x) == offer(x) ? 모두 뒤에 추가
     *
     * [제거]
     * removeFirst() == pollFirst() ? 모두 앞에서 제거
     * removeLast() == pollLast() ? 모두 뒤에서 제거
     * poll() == pollFirst() ? 모두 앞에서 제거 (큐 방식)
     * pop() == removeFirst() ? 모두 앞에서 제거 (스택 방식)
     *
     * [조회]
     * getFirst() == peekFirst() == peek() ? 앞 조회
     * getLast() == peekLast() == peek(스택) ? 뒤 조회
     * */
}