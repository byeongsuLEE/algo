package day0611;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-11
 * 풀이방법
 **/


public class Main_4483 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[][] map;
    private static int index;


    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        int dp[][] = new int [N+3][4];
        for(int i = 1 ; i <=N ;i++){
            Arrays.fill(dp[i], 1_000_000);
        }

        dp[1][2] = map[1][2];
        dp[1][3] = map[1][2]+map[1][3];
        for(int i =2 ; i <=N ; i++){
            for(int j =1 ; j <=3 ; j++){
                //맨왼쪽
                if(i==2 && j ==1){
                    dp[2][1] = dp[1][2] + map[2][1];
                    continue;
                }
                if(j==1){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) +map[i][j];
                }else if(j==2){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j+1]),Math.min(dp[i-1][j-1],dp[i][j-1]))+map[i][j];
                }else{
                    dp[i][j] = Math.max( Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) +map[i][j];
                }

            }
        }

        sb.append(index).append(". ").append(dp[N][2]).append("\n");

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        index =1;
        while(true){

            N= Integer.parseInt(br.readLine());
            if(N==0) break;

            map = new int[N+1][3+1];
            for(int i = 1; i < N+1; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1 ; j <=3; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solution();
            index++;

        }

    }

}
