package programmers.level1;

/*
* 신규 아이디 추천
* https://programmers.co.kr/learn/courses/30/lessons/72410
* */
public class NewIdRecommend {
    public static void main(String[] args) {
        String a = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(func(a));
//
        String b = "z-+.^.";
        System.out.println(func(b));

        String c = "=.=";
        System.out.println(func(c));

        String d = "123_.def";
        System.out.println(func(d));

        String e = "abcdefghijklmn.p";
        System.out.println(func(e));
    }

    static String func(String new_id) {
        String pattern = "[^a-z0-9-_.]";

        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll(pattern, "");

        new_id = new_id.replaceAll("\\.{2,}", ".");

        if (new_id.length() > 1) {
            while (".".equals(new_id.substring(0, 1))) {
                new_id = new_id.substring(1);
            }

            while (".".equals(new_id.substring(new_id.length() - 1))) {
                new_id = new_id.substring(0 , new_id.length() - 1);
            }
        } else {
            if (".".equals(new_id)) {
                new_id = "";
            }
        }


        if ("".equals(new_id)) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0 , 15);

            if (".".equals(new_id.substring(new_id.length() - 1))) {
                new_id = new_id.substring(0 , new_id.length() - 1);
            }
        }

        if (new_id.length() <= 2) {
            String lastStr = new_id.substring(new_id.length() - 1);
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while (new_idBuilder.length() < 3) {
                new_idBuilder.append(lastStr);
            }
            new_id = new_idBuilder.toString();

            return new_id;
        }

        return new_id;
    }
}
