package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

/*
* 크레인 인형뽑기 게임
* https://programmers.co.kr/learn/courses/30/lessons/64061
* */
public class PuppetDraw {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};


        List<List<Integer>> list = new ArrayList<>();
        for (int i=board.length; i > 0; i--) {
            List<Integer> data = Arrays.stream(board[i-1])
                    .boxed()
                    .collect(Collectors.toList());
            list.add(data);
        }

        List<List<Integer>> boxes = new ArrayList<>();

        for (int j=0; j<list.size(); j++) {
            List<Integer> newList = new ArrayList<>();

            for (int i=list.size(); i > 0; i--) {
                List<Integer> val = list.get(i-1);

                if (val.get(j) != 0)
                    newList.add(val.get(j));
            }

            boxes.add(newList);
        }

        List<Integer> result = new ArrayList<>();

        int cnt = 0;

        for (int i : moves) {
            List<Integer> data = boxes.get(i-1);
            Optional<Integer> value = data.stream().findFirst();
            if (value.isEmpty()) {
                continue;
            }

            data.remove(value.get());

            int lastIndex = result.size() == 0 ? 0 : result.get(result.size() - 1);

            if (lastIndex == value.get()) {
                result.remove(Integer.valueOf(lastIndex));
                cnt += 2;
            } else {
                result.add(value.get());
            }
        }


        result.forEach(System.out::println);
        System.out.println("cnt: " + cnt);
    }
}
