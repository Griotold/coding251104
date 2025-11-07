package pyalgo20;

import java.util.*;

// 9. 최대 손실액 : 투포인터 | 슬라이딩 윈도우
public class MaxLoss_9 {
    public static int solution(int[] prices) {
        // 시간 순서대로 가면서
        // 현재까지의 최고가를 추적
        // 각 시점에서 최고가 - 현재가 = 손실액
        // 최대 손실액을 찾기

        int maxPrice = prices[0];
        int maxLoss = 0;

        // 1번째부터 끝까지 순회
        for(int i = 1; i < prices.length; i++) {
            // 현재까지의 최고가 갱신
            maxPrice = Math.max(maxPrice, prices[i]);

            // 현재 손실액 계산
            int loss = maxPrice - prices[i];

            // 최대 손실액 갱신
            maxLoss = Math.max(maxLoss, loss);
        }

        return maxLoss;
    }

    public static void main(String[] args) {
        int[] test1 = {58000, 58700, 55300, 54200, 53600, 52700, 57700, 61100};
        System.out.println("입력: " + Arrays.toString(test1));
        System.out.println("출력: " + solution(test1));
        System.out.println("예상: 6000\n");

        int[] test2 = {80000, 58000, 52700, 57700, 61100};
        System.out.println("입력: " + Arrays.toString(test2));
        System.out.println("출력: " + solution(test2));
        System.out.println("예상: 27300");
    }
}
