package pyalgo20;

import java.util.*;

// 3. 출정인원 선발 : 정렬
public class Selection {

    static class Hero implements Comparable<Hero>{
        String name;
        int point;

        Hero(String name, int point) {
            this.name = name;
            this.point = point;
        }

        String getName() {
            return name;
        }

        int getPoint() {
            return point;
        }

        @Override
        public int compareTo(Hero o) {
            return Integer.compare(this.point, o.point);  // 오름차순
        }
    }

    // 1. Hero 객체 생성
    private static List<Hero> createHeros(String[][] army) {
        List<Hero> heros = new ArrayList<>();
        for(int i = 0; i < army.length; i++) {
            String name = army[i][0];
            int total = 0;
            for(int j = 1; j < army[i].length; j++) {
                total += Integer.parseInt(army[i][j]);
            }
            heros.add(new Hero(name, total));
        }
        return heros;
    }

    // 2. 점수 기준 내림차순 정렬
    private static void sortByPoint(List<Hero> heros) {
        heros.sort(Collections.reverseOrder());
    }

    // 3. 상위 30% 인원 계산
    private static int calculateTopCount(List<Hero> heros) {
        return (int) (heros.size() * 0.3);
    }

    // 4. 동점자 확인
    private static boolean hasNoTie(List<Hero> heros, int topCount) {
        if(topCount == 0) return false;

        int cutoffPoint = heros.get(topCount - 1).getPoint();
        int nextPoint = heros.get(topCount).getPoint();

        return cutoffPoint != nextPoint;
    }

    // 5. 선발된 기술자 이름 추출
    private static List<String> extractNames(List<Hero> heros, int topCount) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < topCount; i++) {
            result.add(heros.get(i).getName());
        }
        return result;
    }

    // 6. 이름을 알파벳 역순으로 정렬
    private static void sortByNameDescending(List<String> names) {
        names.sort(Collections.reverseOrder());
    }

    public static String[] solution(String[][] army) {
        List<Hero> heros = createHeros(army);
        sortByPoint(heros);

        int topCount = calculateTopCount(heros);

        if(!hasNoTie(heros, topCount)) {
            return new String[]{};
        }

        List<String> result = extractNames(heros, topCount);
        sortByNameDescending(result);

        return result.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String[][] test1 = {{"A", "25", "24", "11", "12"}, {"B", "13", "22", "16", "14"}};
        System.out.println("입력: " + Arrays.deepToString(test1));
        System.out.println("출력: " + Arrays.toString(solution(test1)));
        System.out.println("예상: []\n");

        String[][] test2 = {{"A", "25", "25", "25", "25"}, {"B", "10", "12", "13", "11"}, {"C", "24", "22", "23", "21"}, {"D", "13", "22", "16", "14"}};
        System.out.println("입력: " + Arrays.deepToString(test2));
        System.out.println("출력: " + Arrays.toString(solution(test2)));
        System.out.println("예상: [A]");
    }
}