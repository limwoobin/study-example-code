package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
* 크레인 인형뽑기 게임
* https://programmers.co.kr/learn/courses/30/lessons/64061
* */
public class PuppetDraw {
    public static void main(String[] args) {
        int board[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int moves[] = {1,5,3,5,1,2,1,4};


        List<List<Integer>> list = new ArrayList<>();
        for (int i=board.length; i > 0; i--) {
            List<Integer> data = Arrays.stream(board[i-1])
                    .boxed()
                    .collect(Collectors.toList());
            list.add(data);
        }

        List<List<Integer>> boxs = new ArrayList<>();
        for (int i=list.size(); i>0; i--) {
            List<Integer> val = list.get(i);
            for (int j=0; j>val.size(); j++) {
                List
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i : moves) {
            List<Integer> data = list.get(i-1);
            int lastIndex = data.size();
            int value = data.remove(lastIndex - 1);

            if (value != 0) {
                result.add(value);
            }
        }

        result.forEach(System.out::println);

        int cnt = 0;

        for (int i=0; i<result.size(); i++) {
            if (i < result.size() - 1) {
                int target = i + 1;
                if (Objects.equals(result.get(i), result.get(target))) {
                    result.remove(i);
                    result.remove(i);
                    cnt++;
                    cnt++;
                }
            }
        }

//        System.out.println("cnt: " + cnt);
//        result.forEach(System.out::println);
    }
}
