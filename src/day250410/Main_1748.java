package day250410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-10
 * 풀이방법
 * n= 1억  완탐 금지
 * 자리 수를 판별를 어떻게 하는 지?
 * 직접 써보고 수학적인 패턴을 찾아보자
 * 1 ~ 9  = 1
 * 10 ~ 99 = 2
 * 1~ 10-1 = 1
 * 10~ 100-1
 * start는 이전 end가 되고 end는 x10씩 늘어난다.
 *
 **/


public class Main_1748 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        //1  10-1
        //10 100-1
        //100 1000-1
        int startNum = 1;
        int endNum = 10;
        int size = 1;
        int sum = 0;
        while (true) {
            int count =0;
            if (N > endNum - 1) {
                count = endNum-startNum;
                sum += (count * size);
            } else {
                count = N - startNum+1;
                sum += (count * size);
                break;
            }
            startNum=endNum;
            endNum *= 10;
            size++;
        }
        sb.append(sum);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

}
