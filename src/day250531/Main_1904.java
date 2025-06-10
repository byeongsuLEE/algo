package day250531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-31
 * 풀이방법
 **/


public class Main_1904 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int mod;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        int dp[] = new int [N+3];

        dp[1]= 1;
        dp[2]=2;

        for(int i = 3 ; i <=N ; i++){
            dp[i] = (dp[i-1]+dp[i-2]) % mod;
        }
        sb.append(dp[N]);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mod = 15746 ;

        System.out.println(String.valueOf(true));
    }
}
