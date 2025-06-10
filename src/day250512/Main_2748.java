package day250512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-12
 * 풀이방법
 **/


public class Main_2748 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static long[] dp;



    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }


    private static void solution() {
        if(N ==1){
            sb.append(1);
            return;
        }
        dp[2] = dp[1] = 1;

        for(int i= 3 ; i <=N;i++){
            dp[i] = dp[i-1] + dp[i-2];

        }
        sb.append(dp[N]);

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long [N+1];
    }
}
