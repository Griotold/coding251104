package pyalgo20;

// 8. 무기 생산 : 수학
public class WeaponProduction {

    public static int solution(int budget) {
        // 여기에 로직 작성
        // 검 1자루: 3000원
        // 날 세우기: 300원
        // 10자루당 무료 검 1자루 (날 없음)
        // 100자루당 무료 날 선 검 1자루

        int maxSwords = 0;

        // x자루를 구매했을 때 총 비용 계산
        for(int x = 1; x <= budget / 3000 + 100; x++) {
            // 기본 검 x자루 비용
            int basicCost = x * 3000;

            // 10자루당 추가되는 무료 검 (날 없음, 날 세우기 필요)
            int freeWordsWithoutSharp = x / 10;

            // 100자루당 추가되는 무료 검 (날 선 상태)
            int freeWordsWithSharp = x / 100;

            // 날을 세워야 할 검: 기본 검 + 10자루 서비스 검
            int sharpeningCost = (x + freeWordsWithoutSharp) * 300;

            // 총 비용
            int totalCost = basicCost + sharpeningCost;

            // 예산을 초과하면 멈추기
            if(totalCost > budget) {
                break;
            }

            // 이 경우가 가능하면 날 선 검 개수 업데이트
            maxSwords = x + freeWordsWithoutSharp + freeWordsWithSharp;
        }

        return maxSwords;
    }

    public static void main(String[] args) {
        System.out.println("입력: 100");
        System.out.println("출력: " + solution(100));
        System.out.println("예상: 0\n");

        System.out.println("입력: 36600");
        System.out.println("출력: " + solution(36600));
        System.out.println("예상: 12\n");

        System.out.println("입력: 66600");
        System.out.println("출력: " + solution(66600));
        System.out.println("예상: 22");
    }
}