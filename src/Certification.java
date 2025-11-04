import java.util.Arrays;

public class Certification {

    // 65 ~ 90 : A ~ Z // 97 ~ 122 : a ~ z
    public static String solution(String[] input) {
        StringBuilder result = new StringBuilder();

        for(String str : input) {
            StringBuilder sb = new StringBuilder();

            // 문자 하나씩 순회 (공백은 무시)
            for(char c : str.toCharArray()) {
                if(c == '+') {
                    sb.append("1");
                } else if(c == '-') {
                    sb.append("0");
                }
                // 공백은 그냥 스킵
            }

            int num = Integer.parseInt(sb.toString(), 2);
            result.append((char) num);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] test1 = {" + - - + - + - ", " + + + - + - + ", " + + - + + + - "};
        System.out.println("입력: " + Arrays.toString(test1));
        System.out.println("출력: " + solution(test1));
        System.out.println("예상: Jun\n");

        String[] test2 = {" + + + - - + + ", " + + + - + - - ", "++----+", "+++ --+ -", "+++-+ - -"};
        System.out.println("입력: " + Arrays.toString(test2));
        System.out.println("출력: " + solution(test2));
        System.out.println("예상: start\n");

        String[] test3 = {" + + - - - - + ", " + + - + + - - ", "+ +-- +++ ", " ++- ++++"};
        System.out.println("입력: " + Arrays.toString(test3));
        System.out.println("출력: " + solution(test3));
        System.out.println("예상: algo");
    }
}