package programmers.level1;

import java.util.Arrays;

/*
* 내적
* https://programmers.co.kr/learn/courses/30/lessons/70128
* */
public class DotProduct {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};

        int sum = 0;

        for (int i=0; i<a.length; i++) {
            sum += a[i] * b[i];
        }

        System.out.println(sum);
    }
}
