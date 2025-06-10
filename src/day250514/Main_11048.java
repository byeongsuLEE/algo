package day250514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-14
 * 풀이방법
 **/


public class Main_11048 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                dp[i][j] = Integer.max(dp[i-1][j]+map[i][j] , dp[i-1][j-1]+map[i][j]);
                dp[i][j] = Integer.max(dp[i][j], dp[i][j-1]+map[i][j]);
            }

        }
        sb.append(dp[N][M]);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N+1][M+1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int [N+1][M+1];

    }

}
