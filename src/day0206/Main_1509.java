package day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-02-06
 * 풀이방법
 **/


public class Main_1509 {
    private static StringBuilder sb= new StringBuilder();
    private static boolean [][] isPalindrome;
    private static String str ;
    private static int size;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        checkPalidrome();

        for(int i = 1 ; i <= size;i++){
            for(int j = 1 ; j<= i ; j++){
                if(isPalindrome[j][i]){
                    dp[i] = Math.min(dp[i] , dp[j-1]+1);
                }
            }
        }

        System.out.println(dp[size]);
    }

    private static void checkPalidrome() {
        for (int i = 1; i <= size; i++) {
            for (int j = i; j <= size; j++) {

                int start= i-1;
                int end = j-1 ;
                boolean flag = false;

                while(start<=end){
                    if(str.charAt(start++)!=str.charAt(end--)){
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    isPalindrome[i][j] = true;
                }


            }
        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        size = str.length();
        isPalindrome = new boolean[size+1][size+1];

        dp = new int[size+1];

        for(int i = 1 ; i <= size ; i++){
            dp[i] = Integer.MAX_VALUE;
        }


    }
}
