package day250514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-14
 * 풀이방법
 **/


public class Main_1446 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int D;
    private static int[] dp;
    private static Integer[][] input;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        //dp[N] = N에 도착할떄의 최소 운전거리
        for(int i = 0 ; i <=D ;i++){
            dp[i] =i;
        }



        Arrays.sort(input,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            };
            return Integer.compare(a[0],b[0]);
        });
        for(int i  = 0 ; i <N ; i++ ){
            int start = input[i][0];
            int end = input[i][1];
            int dist = input[i][2];
            if (end > D ) continue;

            dp[end] = Math.min(dp[end], dp[start]+dist);
            dp[D] = Math.min(dp[D],dp[end] + D - end);

            for(int d = end ; d<= D ; d++){
                dp[d] = Math.min(dp[d],dp[end]+d-end);
            }




        }




        sb.append(dp[D]);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dp = new int[D+1];
        input = new Integer[N][3];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            input[i][0] = start;
            input[i][1] = end;
            input[i][2] = dist;
        }

    }
}
