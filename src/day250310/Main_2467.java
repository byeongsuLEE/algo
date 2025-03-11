package day250310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-10
 * 풀이방법
 **/


public class Main_2467 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] num;
    private static int minValue = Integer.MAX_VALUE;
    private static int leftValue, rightVlaue;
    private static int start, end;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        int startEnd = 0;

        while (start < end) {


            int half = start+end /2 ;
             int sum = num[start] + num[end];


            if (minValue >= Math.abs(sum)) {
                minValue = Math.abs(sum);
                leftValue = num[start];
                rightVlaue = num[end];
            }

            if (sum < 0) {
                int i1 = num[start] + num[half];
                int i = num[half] + num[end];



            } else {
                end--;
            }


        }

        sb.append(leftValue).append(" ").append(rightVlaue);
        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        end = N-1;


    }
}
