package day250509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-09
 * 풀이방법
 **/


public class Main_2293 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int K;
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
        int dp [] = new int[K+1];

        dp[0] = 1;

        for(int i = 0 ; i < N ;i++){
            for(int j = input[i] ; j <= K ; j++){
                    dp[j] +=dp[j-input[i]];
            }
        }
        sb.append(dp[K]);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        input = new int [N];
        for(int i = 0 ; i < N ; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
    }

}

