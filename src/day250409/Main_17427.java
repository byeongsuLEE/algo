package day250409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-09
 * 풀이방법
 * 1. 완탐이 아닌 dp로 i*j의 약수의 합을 저장한다.
 * dp[x] = x를 이루는 배수들의 합을 저장한다.
 * 시작은 i = 1~n  ,  j = 1 ~ i*j<=N &&  j<i
 * dp[1*3] =  1+3
 * dp[3*1] = 3+1 중복된 수를 더할 수 있기 떄문에
 * j<i 조건 써주자
 **/


public class Main_17427 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        // N의 약수를 구하는 완탐 시 시간초과가 난다
        //for i =1 ; i*i <= N; i++ ;{
//        for (int i = 1 ; i <=N ;i++){
//            int sum= 0;
//            for(int j = 1 ; j*j<=i ; j++){
//                if(i % j == 0 ){
//                    sum += (j == i/j ? j : j + i/ j);
//                }
//
//            }
//            dp[i] = sum;

        // n 보다 작은 배수들의 모든 합들을 dp로 저장해주는 방식을 생각했다.
        // dp[x] = x를 이루는 배수들의 합을 저장한다.
        // 1*x  = dp[1*x]가 될떄 1+x를 더해주는 식으로 저장을해보자.
        // 1 * x  = x * 1 가 중복으로 들어가기 떄문에 j < i 를 해주자.
        for (int i = 1; i <=N; i++) {
            for(int j =1 ; j *i <=N  && j<i  ;j++){
                //이렇게하면 2 x 3 = 3 x 2 두가지경우가 둘다들어감
                dp[i*j] += (i==j ? i : j+i);
            }

        }




        long sum = 0;
        for (int i = 1; i <=N; i++) {
            sum += dp[i];
        }
        sb.append(sum);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        dp = new long[N+1];
    }

}
