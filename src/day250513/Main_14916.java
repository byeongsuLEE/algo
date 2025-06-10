package day250513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-13
 * 풀이방법
 **/


public class Main_14916 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        //  dp[n] = 거스름돈이 N 일떄의 최소의 동전 개수
        int dp [] = new int [N+5];
        Arrays.fill(dp, 123456789);
        dp[0] =0;
        dp[2]=1;
        dp[4]=2;

        for(int i = 5; i <= N; i++){
            dp[i] = Integer.min(dp[i-2]+1,dp[i-5]+1);
        }
        if(dp[N]>=123456789){
            sb.append(-1);
        }else{
            sb.append(dp[N]);
        }

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


    }
}
