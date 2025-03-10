package day250216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-02-16
 * 풀이방법
 * dp + 비트마스킹
 * dp[현재 자리수][현재 숫자][비트마스킹]
 *
 **/


public class Main_1562_계단수 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int mod = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        int dp[][][] =  new int [N+1][10][1<<10];


        for(int i = 1 ; i <=9;i++ ){
            dp[1][i][1<<i] = 1;
        }

        for (int i = 1; i <N; i++) {
            for(int j =0;  j <= 9; j++ ){
                for(int mask = 0 ; mask < (1<<10) ;mask++){
                    
                    if(dp[i][j][mask]==0) continue;
                    
                    if(init(j-1)){
                        int currentMask = mask | (1 << (j-1));
                        
                        dp[i+1][j-1][currentMask] = (dp[i+1][j-1][currentMask]+dp[i][j][mask]) %mod;
             
                    }
                    if(init(j+1)){
                        int currentMask = mask | (1 << (j+1));
                        dp[i+1][j+1][currentMask] = (dp[i+1][j+1][currentMask]+dp[i][j][mask])  % mod;
                    }

                }

               
            }

        }

        int answer = 0;
        int fullMask = (1 << 10) - 1;
        for (int j = 0; j <= 9; j++) {
            answer = (answer + dp[N][j][fullMask]) % mod;
        }

        System.out.println(answer);




    }

    private static boolean init(int x) {

        return x >=0 && x <=9 ;
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

    }
}
