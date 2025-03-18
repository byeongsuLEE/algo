package day250317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-17
 * 풀이방법
 **/


public class Main_2747 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        System.out.println(fibo(N));
    }

    private static int fibo(int n) {
        if(n ==0 ) return 0;
        else if(n==1 ) {
            return  dp[n]=1;
        }
        else if(dp[n]!=0) return dp[n];
        return  dp[n] = (fibo (n-1) + fibo(n-2));
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         dp = new int[N+1];

    }
}
