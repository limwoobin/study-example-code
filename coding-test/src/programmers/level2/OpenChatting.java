package programmers.level2;

import java.util.*;

/*
* 오픈채팅방
* https://programmers.co.kr/learn/courses/30/lessons/42888
* */
public class OpenChatting {
    public static void main(String[] args) {
        String[] answer = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        String[] result = func(answer);
        for (String data : result) {
            System.out.println(data);
        }
    }

    static String[] func(String[] answer) {
        List<String> list = new ArrayList<>();

        Map<String , String> map = new HashMap<>();
        for (String data : answer) {
            String[] val = data.split(" ");
            if (val[0].equals("Enter") || val[0].equals("Change")) {
                map.put(val[1] , val[2]);
            }
        }

        for (String data : answer) {
            String[] val = data.split(" ");
            String actionMessage = "";
            if ("Enter".equals(val[0])) {
                actionMessage = "들어왔습니다.";
            } else if ("Leave".equals(val[0])) {
                actionMessage = "나갔습니다.";
            } else {
                continue;
            }

            list.add(map.get(val[1]) + "님이 " + actionMessage);
        }

        String[] result = list.toArray(new String[list.size()]);
        return result;
    }
}
