package day250122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-01-22
 * 풀이방법
 **/


public class Main_11055 {

    private static int N;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        int dp[] = new int[N];
        int answer= 0 ;
        for(int i = 0 ; i < N ; i++){
            dp[i] = numbers[i];
            for(int j= 0 ; j<i; j++){
                if(numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+numbers[i]);
                }
            }
            answer = Math.max(answer,dp[i]);

        }

        System.out.println(answer);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}
