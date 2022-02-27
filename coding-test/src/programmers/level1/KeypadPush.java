package programmers.level1;

import java.util.Set;

/*
* 키패드 누르기
* https://programmers.co.kr/learn/courses/30/lessons/67256
* */
public class KeypadPush {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hands = "right";

        int[] array2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hands2 = "left";

        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hands3 = "right";

        StringBuilder result = keyPadResult(array, hands);
        System.out.println(result);

        StringBuilder result2 = keyPadResult(array2, hands2);
        System.out.println(result2);

        StringBuilder result3 = keyPadResult(array3, hands3);
        System.out.println(result3);
    }

    static StringBuilder keyPadResult(int[] array, String hands) {
        Set<Integer> left = Set.of(1,4,7);
        Set<Integer> right = Set.of(3,6,9);
        Set<Integer> middle = Set.of(2,5,8,11);

        int now_left = 10;
        int now_right = 12;

        StringBuilder result = new StringBuilder();

        for (int i : array) {
            if (i == 0) i = 11;

            if (left.contains(i)) {
                result.append("L");
                now_left = i;
            } else if (right.contains(i)) {
                result.append("R");
                now_right = i;
            } else {
                int left_gap;
                int right_gap;

                if (middle.contains(now_left)) {
                    left_gap = Math.abs(i - now_left) / 3;
                } else {
//                    now_left += 2;
                    left_gap = Math.abs(i - now_left);
//                    now_left -= 2;
                }

                if (middle.contains(now_right)) {
                    right_gap = Math.abs(i - now_right) / 3;
                } else {
                    right_gap = Math.abs(i - now_right);
                    left_gap = Math.abs(i - (now_left + 2));
                }

                if (left_gap > right_gap) {
                    result.append("R");
                    now_right = i;
                } else if (right_gap > left_gap) {
                    result.append("L");
                    now_left = i;
                } else {
                    if ("right".equals(hands)) {
                        result.append("R");
                        now_right = i;
                    } else {
                        result.append("L");
                        now_left = i;
                    }
                }
            }
        }

        return result;
    }
}
