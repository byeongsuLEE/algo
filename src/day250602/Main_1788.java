package day250602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-02
 * 풀이방법
 * 1. 1  -> - 100000 까지 반대방향으로 가면되지않을까?
 * 2. -1 -2 먼저 구하고 하나의 포문으로 양수와 음수 dp[n] dp[-n]를 초기화해버리자
 * 자료형은 double
 **/


public class Main_1788 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static double[][] dp;
    private static final int mod = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        dp[1][0]= 1;
        dp[0][0]=0;
        dp[0][1]=0;
        dp[2][0]=1;
        dp[1][1] = dp[1][0] - dp[0][0];

        for(int i = 2 ; i <=Math.abs(N) ; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-2][0]) % mod;
            dp[i][1] =  (dp[i-2][1] - dp[i-1][1])  % mod;
        }

        double result = N <= 1 ? dp[Math.abs(N)][1] : dp[Math.abs(N)][0];
        if(result >0){
            sb.append(1);
        }else if (result <0){
            sb.append(-1);
        }else{
            sb.append(0);
        }

        sb.append("\n");
        sb.append((int)Math.abs(result));

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new double[Math.abs(N)+3][2];
    }

}
