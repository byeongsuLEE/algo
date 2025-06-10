package day250515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-15
 * 풀이방법
 **/


public class Main_11052 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] cost;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        //dp[N] = n이 되기위한 최소 비용
        for(int i = 1 ; i <= N ; i++){
           int weight = 0;
            for(int j = 0 ; j <= N ; j+=i){
                weight+=cost[i];
                dp[j]= Math.max(dp[j],weight);

            }

            //I =3
            // N= 6
            //
        }

    // 1
        


        for(int i = 1 ; i <= N ; i++){
            for(int j = i ; j <= N ; j+=i){
                dp[N] = Math.max(dp[N],dp[j] + dp[N-j]);
            }
        }

        sb.append(dp[N]);
    }


    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        cost = new int[N+1] ;
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <=N ; i++){

            cost[i] = Integer.parseInt(st.nextToken());
        }
    }
}
