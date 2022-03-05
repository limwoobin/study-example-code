package programmers.level1;

/*
* 음양 더하기
* https://programmers.co.kr/learn/courses/30/lessons/76501
* */
public class NumberPlus {
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true, false, true};

        int sum = 0;
        for (int i=0; i<absolutes.length; i++) {
            if (signs[i]) {
                sum += absolutes[i];
                continue;
            }

            sum += absolutes[i] * -1;
        }

        System.out.println(sum);
    }
}
