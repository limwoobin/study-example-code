package programmers.level1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
* 신고 결과 받기
* https://programmers.co.kr/learn/courses/30/lessons/92334
* */
public class ReportResult {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;

        int[] result = func(id_list , report , k);
        for (int i : result) {
            System.out.print(i);
        }
    }

    static int[] func(String[] id_list, String[] report, int k) {
        Map<String, Integer> countMap = new LinkedHashMap<>();
        Map<String , List<String>> listMap = new LinkedHashMap<>();

        for (String id : id_list) {
            countMap.put(id, 0);
            listMap.put(id, new ArrayList<>());
        }

        for (String data : report) {
            String[] line = data.split(" ");
            String val1 = line[0];
            String val2 = line[1];

            List<String> list = listMap.get(val1);
            if (list.contains(val2)) {
                continue;
            }

            int cnt = countMap.get(val2);
            countMap.put(val2, ++cnt);

            List<String> list2 = listMap.get(val1);
            list2.add(val2);
            listMap.put(val1, list2);
        }

        List<Integer> data = new ArrayList<>();

        for (Map.Entry<String , List<String>> elem : listMap.entrySet()) {
            int cnt = 0;

            for (String target : elem.getValue()) {
                if (countMap.get(target) >= k) {
                    cnt++;
                }
            }

            data.add(cnt);
        }

        return data.stream().mapToInt(Integer::intValue).toArray();
    }
}
