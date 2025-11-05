import java.util.*;

// 스택 동작 확인 연습
public class StackPractice {

    public static void main(String[] args) {
        int[] ingredients = {1, 2, 3, 4, 1, 1, 2, 3, 4};

        Deque<Integer> stack = new ArrayDeque<>();

        System.out.println("=== 스택 동작 확인 ===\n");

        for(int i = 0; i < ingredients.length; i++) {
            stack.push(ingredients[i]);

            System.out.println("Step " + (i+1) + ": push(" + ingredients[i] + ")");
            System.out.println("스택 상태: " + stack);
            System.out.println("크기: " + stack.size());

            // 크기가 5 이상일 때 위의 5개 출력
            if(stack.size() >= 5) {
                List<Integer> temp = new ArrayList<>(stack);
                int size = temp.size();
                System.out.print("위에서부터 5개: [");
                System.out.print(temp.get(size-1) + ", ");
                System.out.print(temp.get(size-2) + ", ");
                System.out.print(temp.get(size-3) + ", ");
                System.out.print(temp.get(size-4) + ", ");
                System.out.print(temp.get(size-5));
                System.out.println("]");
            }

            System.out.println();
        }
    }
}