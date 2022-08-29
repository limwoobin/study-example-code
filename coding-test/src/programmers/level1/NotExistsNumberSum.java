package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/*
* 없는 숫자 누르기
* https://programmers.co.kr/learn/courses/30/lessons/86051
* */
public class NotExistsNumberSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list.add(i);
        }

        int[] numbers = {1,2,3,4,6,7,8,0};
        for (int num : numbers) {
            list.remove(Integer.valueOf(num));
        }

        int sum = list.stream()
                        .mapToInt(x -> x)
                        .sum();

        System.out.println(sum);
    }
}
