package day250519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-19
 * 풀이방법
 **/


public class Main_15988 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int T;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        initSolution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {


        for(int i = 3 ; i <=1_000_000;i++){
            for(int j= 1; j<=3;j++){
                dp[i]+= (dp[i-j]) % 1_000_000_009;
            }
        }
    }

    private static void initSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());
        dp = new long[1_000_000+3];
        dp[0] =1L;
        dp[1]=1L;
        dp[2]=2L;
        solution();
        for(int i = 0 ; i <T ; i++){
           N =  Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

    }

}
