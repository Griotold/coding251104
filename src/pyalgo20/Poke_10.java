package pyalgo20;

import java.util.*;

// 10. 알리는 포케가 좋아 : 조합
public class Poke_10 {

    static String[] allToppings = {"연어", "참치", "닭가슴살", "베이컨", "버섯"};
    static List<String> current;
    static List<String> required;
    static List<List<String>> result;

    public static Object solution(String[] input) {
        // 입력이 비어있으면 특수 메시지 반환
        if(input.length == 0) {
            return "기본 포케가 제공됩니다.";
        }

        int toppingCount = Integer.parseInt(input[0]);
        String requiredTopping = input[1];

        // 토핑 수가 0이면 특수 메시지 반환
        if(toppingCount == 0) {
            return "기본 포케가 제공됩니다.";
        }

        // 필수 토핑 리스트 만들기 (쉼표로 구분)
        required = new ArrayList<>();
        if(!requiredTopping.isEmpty()) {
            String[] parts = requiredTopping.split(", ");
            required.addAll(Arrays.asList(parts));
        }

        // 조합 구하기
        current = new ArrayList<>();
        result = new ArrayList<>();
        generateCombinations(0, toppingCount);

        return result;
    }

    // 조합 생성 메서드 (재귀)
    private static void generateCombinations(int start, int targetCount) {
        // 현재 조합의 크기가 원하는 크기에 도달했으면
        if(current.size() == targetCount) {
            // 필수 토핑이 모두 포함되는지 확인
            if(current.containsAll(required)) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // start부터 allToppings의 끝까지 순회
        for(int i = start; i < allToppings.length; i++) {
            current.add(allToppings[i]);  // 토핑 추가
            generateCombinations(i + 1, targetCount);  // 재귀
            current.remove(current.size() - 1);  // 백트래킹
        }
    }

    // 출력 형식을 맞추는 메서드
    private static String formatResult(List<List<String>> resultList) {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < resultList.size(); i++) {
            sb.append("[");
            List<String> combo = resultList.get(i);
            for(int j = 0; j < combo.size(); j++) {
                sb.append("\"").append(combo.get(j)).append("\"");
                if(j < combo.size() - 1) sb.append(", ");
            }
            sb.append("]");
            if(i < resultList.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] test1 = {};
        System.out.println("입력: []");
        System.out.println("출력: " + solution(test1));
        System.out.println("예상: 기본 포케가 제공됩니다.\n");

        String[] test2 = {"2", "연어"};
        System.out.println("입력: [2, \"연어\"]");
        Object result2 = solution(test2);
        System.out.println("출력: " + formatResult((List<List<String>>) result2));
        System.out.println("예상: [[\"연어\", \"참치\"], [\"연어\", \"닭가슴살\"], [\"연어\", \"베이컨\"], [\"연어\", \"버섯\"]]\n");

        String[] test3 = {"3", "연어, 참치"};
        System.out.println("입력: [3, \"연어, 참치\"]");
        Object result3 = solution(test3);
        System.out.println("출력: " + formatResult((List<List<String>>) result3));
        System.out.println("예상: [[\"연어\", \"참치\", \"닭가슴살\"], [\"연어\", \"참치\", \"베이컨\"], [\"연어\", \"참치\", \"버섯\"]]\n");

        String[] test4 = {"3", ""};
        System.out.println("입력: [3, \"\"]");
        Object result4 = solution(test4);
        System.out.println("출력: " + formatResult((List<List<String>>) result4));
        System.out.println("예상: 10가지 조합");
    }
}