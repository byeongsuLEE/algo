package day1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자   : 이병수
 * 작성날짜 : 2024-11-28
 * 설명    :
 */
public class Main_11053 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N =  Integer.parseInt(br.readLine());
        int A[] = new int [N] ;
        int dp[] = new int [N];

        Arrays.fill(dp,1);
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
          int num = Integer.parseInt(st.nextToken());
          A[i] = num;
          for(int j = 0 ; j < i; j++){
              if(A[i] > A[j]){
                  dp[i] = Math.max(dp[i], dp[j] + 1);

              }
          }
          answer = Math.max(answer, dp[i]);

        }

        System.out.println(answer);



    }
}
