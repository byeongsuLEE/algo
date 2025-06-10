package day250319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-19
 * 풀이방법
 **/


public class Main_2169 {
  private static StringBuilder sb= new StringBuilder();
    private static int N,M;
    private static int[][] map;
    private static int[][] dp;
    private static int []dr = {0,0,-1};
    private static int []dc = {1,-1,0};
    public static void main(String[] args) throws IOException {
      init();
      solution();
      print();
  }

  private static void print(){
      System.out.println(sb.toString());
  }
  private static void solution() {

  }

  private static void init() throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N =Integer.parseInt(st.nextToken());
      M =Integer.parseInt(st.nextToken());

      map = new int [N+1][M+1];
      dp = new int [N+1][M+1];
      for (int i = 1; i < N+1; i++) {
          st= new StringTokenizer(br.readLine());
          for (int j = 1; j < M+1; j++) {
              map[i][j] = Integer.parseInt(st.nextToken());
              dp[i][j] = map[i][j];
          }
      }


//      for (int i = 0; i < N+1; i++) {
//          Arrays.fill(dp[i],-111);
//      }

      for (int i = 1; i <=M; i++) {
          dp[1][i]= dp[1][i-1] +map[1][i];
      }

      for(int i = 2 ; i<=N; i++){
          int left[] = new int[M +2 ] ;
          int right[] = new int[M +2 ] ;
          left[1] = map[i][1] + dp[i-1][1];
          for(int j = 2 ; j <=M ; j++){
              left[j] =  Math.max(left[j-1] ,  dp[i-1][j]) + map[i][j];
          }

          right[M] = map[i][M] + dp[i-1][M];
          for(int j = M-1 ; j >=1 ; j--){
              right[j] = Math.max(right[j+1], dp[i-1][j]) +map[i][j];
          }

          for(int j = 1 ; j<=M ;j++){
              dp[i][j] = Math.max(left[j],right[j]);
          }


          //왼쪽



      }
      System.out.println(dp[N][M]);
  }



}
