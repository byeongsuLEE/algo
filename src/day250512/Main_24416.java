package day250512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-12
 * 풀이방법
 **/


public class Main_24416 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static long[] dp;
    private static int count1;
    private static int count2;


    public static void main(String[] args) throws IOException {
        init();
        solution1();
        solution2();
        print();
    }

    private static void print(){
        sb.append(count1).append(" ").append(count2).append("\n");
        System.out.println(sb.toString());
    }

    private static void solution1() {
        fibo(N);

    }

    private static int fibo(int n ) {

        if(n==1 || n==2){

            return 1;
        }else{
            count1++;

            return fibo(n-1) + fibo(n-2);
        }

    }

    private static void solution2() {
        dp[2] = dp[1] = 1;

        for(int i= 3 ; i <=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
            count2++;
        }

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long [N+1];
    }
}
