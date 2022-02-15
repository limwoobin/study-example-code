package programmers.level1;

/*
* 숫자 문자열과 영단어
* https://programmers.co.kr/learn/courses/30/lessons/81301
* */
public class NumberArrayAndWord {
    public static void main(String[] args) {
        String param = "one4seveneight";
        String result = func(param);
        System.out.println(result);
    }

    static String func(String s) {
        for (DATA data : DATA.values()) {
            if (s.contains(data.name())) {
                s = s.replace(data.name() , data.getValue());
            }
        }

        return s;
    }
}

enum DATA {
    one("1"),
    two("2"),
    three("3"),
    four("4"),
    five("5"),
    six("6"),
    seven("7"),
    eight("8"),
    nine("9"),
    zero("0");

    private String value;

    public String getValue() {
        return value;
    }

    DATA(String value) {
        this.value = value;
    }
}
