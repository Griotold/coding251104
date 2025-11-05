package pyalgo20;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 2. 암호문 : 정규표현식
public class Cipher {

    public static String solution(String input) {
        // r, e, v 뒤에 오는 한 자리 숫자를 정규표현식으로 매칭
        Pattern pattern = Pattern.compile("[rev](\\d)");
        Matcher matcher = pattern.matcher(input);

        int sum = 0;

        // 패턴이 매칭되는 모든 경우에 대해 숫자 추출 및 합산
        while(matcher.find()) {
            int num = Integer.parseInt(matcher.group(1));
            sum += num;
        }

        // 십의 자리 = 월, // 일의 자리 = 일
        int month = sum / 10;
        int day = sum % 10;

        return month + "월 " + day + "일";
    }

    public static void main(String[] args) {
        String test1 = "a10b9r1ce33uab8wc918v2cv11v9";
        System.out.println("입력: " + test1);
        System.out.println("출력: " + solution(test1));
        System.out.println("예상: 1월 6일\n");
    }
}
