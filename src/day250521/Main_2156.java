package day250521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-21
 * 풀이방법
 **/


public class Main_2156 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] input;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        //연속된 상태 체크는 어떻게?
        //dp[n][j] = n번째 잔까지 고려했을 때, 연속으로 j개의 잔을 마셨을 때의 최대 값
        //dp[n][0] = 현재 n 번을 마시지않는 선택지
        //dp[n][1]= 현재 n번잔을 마신거,연속x
        //dp[n][2]= 현재 n번잔을 마시고 , 이전에도 마신거
        int [][]dp = new int[N+1][3];
        dp[1][1]=input[1];
        for(int i = 2 ; i<=N; i++){
            // i번째 잔을 마시지 않는 경우
            dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);

            // i번째 잔을 마시고, 이전 잔은 마시지 않은 경우
            dp[i][1] = dp[i-1][0] + input[i];

            // i번째 잔을 마시고, 이전 잔도 마신 경우
            dp[i][2] = dp[i-1][1] + input[i];



        }

        sb.append(Math.max(Math.max(dp[N][0],dp[N][1]),dp[N][2]));
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        input = new int[t+1];
        N =t;
        for(int i =  1 ; i<=t; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

    }

}
