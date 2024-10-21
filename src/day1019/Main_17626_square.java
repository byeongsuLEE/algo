package day1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자   : user
 * 작성날짜 : 2024-10-19
 * 설명    :
 */
public class Main_17626_square {

    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();

    }

    private static void solution() {
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int [50001];
        dp[0]= 0 ;
        dp[1] =1;

        for(int i = 2 ; i <= n;i++){

            int max = (int)Math.sqrt(i);
            int other = i- max;
            dp[i]  = dp[ (int)Math.sqrt(i)] + dp[ (int)Math.sqrt(other)];

        }
        System.out.println(dp[n]);


    }
}
