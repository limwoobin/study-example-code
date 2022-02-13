package programmers.level2;

/*
* 문자열 압축
* https://programmers.co.kr/learn/courses/30/lessons/60057
* */
public class StringCompression {
    public static void main(String[] args) {
        String ex1 = "aabbaccc";
        String ex2 = "ababcdcdababcdcd";

        int result_1 = func(ex1);
        System.out.println("result_1: " + result_1);

        int result_2 = func(ex2);
        System.out.println("result_2: " + result_2);
    }

    public static int func(String s) {
        int result = s.length();

        for (int i=1; i<=s.length()/2; i++) {
            int pos = 0;
            int len = s.length();

            for (; pos + i <= s.length();) {
                String unit = s.substring(pos , pos+i);
                pos += i;

                int cnt = 0;
                for (; pos+i <= s.length();) {
                    if (unit.equals(s.substring(pos, pos+i))) {
                        ++cnt;
                        pos += i;
                    } else {
                        break;
                    }
                }

                if (cnt > 0) {
                    len -= i * cnt;

                    if (cnt < 9) {
                        len += 1;
                    } else if (cnt < 99) {
                        len += 2;
                    } else if (cnt < 999) {
                        len += 3;
                    } else {
                        len += 4;
                    }
                }
            }

            result = Math.min(result, len);
        }

        return result;
    }
}
