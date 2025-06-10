package day250605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-05
 * 풀이방법
 **/


public class Main_1699 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        dp = new int [100_001];
        Arrays.fill(dp,123456789);
        dp[0]=0;
        dp[1]=1;

        for(int i = 1 ;  i*i <=N; i++){
            for(int j = i*i ; j<=N ; j++){
                dp[j] = Math.min(dp[j],dp[j-(i*i)]+1);
                dp[N] = Math.min(dp[N],dp[N-j] + dp[j]);
            }
        }
        sb.append(dp[N]);

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

    }

}
