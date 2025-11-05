package pyalgo20;

import java.util.*;

// 7. 두 수의 합 찾기 : 투포인터 | 슬라이딩 윈도우
public class TwoSum {

    static class Gem implements Comparable<Gem>{
        int value;
        int originalIndex;

        Gem(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }

        int getValue() {
            return value;
        }

        int getOriginalIndex() {
            return originalIndex;
        }

        @Override
        public int compareTo(Gem o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public static int[] solution(int[] gems, int targetWeight) {
        // 각 보석을 Gem 객체로 변환
        List<Gem> gemList = new ArrayList<>();
        for(int i = 0; i < gems.length; i++) {
            gemList.add(new Gem(gems[i], i));
        }

        // value 기준으로 정렬
        Collections.sort(gemList);

        // 투포인터로 합 찾기
        int lt = 0;
        int rt = gemList.size() - 1;

        while(lt < rt) {
            Gem left = gemList.get(lt);
            Gem right = gemList.get(rt);
            int sum = left.getValue() + right.getValue();

            if(sum == targetWeight) {
                // 두 원래 인덱스를 오름차순으로 정렬해서 반환
                int[] result = {left.getOriginalIndex(), right.getOriginalIndex()};
                Arrays.sort(result);
                return result;
            } else if(sum < targetWeight) {
                lt++;
            } else {
                rt--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] test1_gems = {4, 9, 11, 2};
        int test1_target = 6;
        System.out.println("입력: " + Arrays.toString(test1_gems) + ", 광차 중량: " + test1_target);
        System.out.println("출력: " + Arrays.toString(solution(test1_gems, test1_target)));
        System.out.println("예상: [0, 3]\n");

        int[] test2_gems = {2, 2};
        int test2_target = 4;
        System.out.println("입력: " + Arrays.toString(test2_gems) + ", 광차 중량: " + test2_target);
        System.out.println("출력: " + Arrays.toString(solution(test2_gems, test2_target)));
        System.out.println("예상: [0, 1]\n");

        int[] test3_gems = {1, 5, 10, 20, 93};
        int test3_target = 103;
        System.out.println("입력: " + Arrays.toString(test3_gems) + ", 광차 중량: " + test3_target);
        System.out.println("출력: " + Arrays.toString(solution(test3_gems, test3_target)));
        System.out.println("예상: [2, 4]\n");

        int[] test4_gems = {3, 4, 5};
        int test4_target = 9;
        System.out.println("입력: " + Arrays.toString(test4_gems) + ", 광차 중량: " + test4_target);
        System.out.println("출력: " + Arrays.toString(solution(test4_gems, test4_target)));
        System.out.println("예상: [1, 2]");
    }
}