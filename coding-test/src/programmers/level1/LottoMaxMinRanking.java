package programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* 로또의 최고 순위와 최저 순위
* https://programmers.co.kr/learn/courses/30/lessons/77484
* */
public class LottoMaxMinRanking {
    static int MAX_NUM = 6;

    public static void main(String[] args) {
        int[] lottos = {44,1,0,0,31,25};
        int[] win_nums = {31,10,45,1,7,19};

//        int[] lottos = {0, 0, 0, 0, 0, 0};
//        int[] win_nums = {38, 19, 20, 40, 15, 25};

//        int[] lottos = {45, 4, 35, 20, 3, 9};
//        int[] win_nums = {20, 9, 3, 45, 4, 35};

        int[] result = func(lottos , win_nums);
        System.out.println(result[0] + "," + result[1]);
    }

    static int[] func(int[] lottos , int[] win_nums) {
        int cnt = 0;
        int zero_cnt = 0;

        List<Integer> winNums = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        for (int lotto : lottos) {
            if (winNums.contains(lotto)) {
                cnt++;
            } else if (lotto == 0) {
                zero_cnt++;
            }
        }


        int val1 = cnt + zero_cnt;
        int val2 = cnt;

        val1 = (MAX_NUM - val1 == 6) ? MAX_NUM - val1 : MAX_NUM - val1 + 1;
        val2 = (MAX_NUM - val2 == 6) ? MAX_NUM - val2 : MAX_NUM - val2 + 1;

        int[] result = {val1 , val2};
        return result;
    }
}
