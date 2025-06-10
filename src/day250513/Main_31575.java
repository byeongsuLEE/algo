package day250513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-13
 * 풀이방법
 **/


public class Main_31575 {
    private static StringBuilder sb= new StringBuilder();
    private static int R;
    private static int C;
    private static int[][] dp;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        sb.append(dp[R][C] == 1 ? "Yes" : "No");
        System.out.println(sb.toString());
    }
    private static void solution() {

      dp[1][1]= 1;

        for(int i = 1 ; i <= R; i++){
            for(int j = 1 ; j <= C ; j++){
                if(i ==1 && j ==1 ) continue;
                if(map[i][j] == 1){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dp= new int[R+1][C+1];
        map = new int[R+1][C+1];
        for(int i=1;i<=R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

}
