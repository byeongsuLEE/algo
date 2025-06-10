package day250517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-17
 * 풀이방법
 **/


public class Main_10844 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[][] dp;
    private static int mod =1_000_000_000;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        for(int i = 2 ; i <=N ; i++){
            for(int j = 0 ; j <=9 ; j++){
                if(0 <= j-1){
                    dp[i][j] = (dp[i][j]+ dp[i-1][j-1]) % mod;
                }
                if(9 >= j+1) {
                    dp[i][j] = (dp[i][j]+dp[i-1][j+1])% mod;
                }
            }
        }

        int result = 0 ;
        for(int i = 0 ; i<=9;i++){
            result = (result + dp[N][i]) % mod;
        }
        sb.append(result);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp= new int[N+1][10];
        for(int i = 1 ; i <= 9;i++){
            dp[1][i] = 1;
        }


    }
}
