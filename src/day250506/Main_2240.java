package day250506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-06
 * 풀이방법
 **/


public class Main_2240 {
    private static StringBuilder sb= new StringBuilder();
    private static int T,W;
    private static int[] input;
    private static int answer = 0 ;
    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        sb.append(answer);
        System.out.println(sb.toString());
    }
    private static void solution() {
//        dfs(0,0,W,1); 실패

        //dp 로 풀어보자.
        //dp[w][t]
        //dp[w][t]는 t초에 자두의 개수가 가장 큰 수
        //변경점 w = 1 ~ 30
        // t= 1~ 1000
        // 현재의 위치 1~2
        // 기존에 작성하신 dp 배열 선언 활용
        // dp[이동횟수][시간][위치]
        int[][][] dp = new int[W+1][T][3];

        // 초기값 설정 - 처음 시작 위치는 항상 1번 나무
        dp[0][0][1] = input[0] == 1 ? 1 : 0;

        // 첫 시간에 바로 2번 나무로 이동한 경우
        if (W >= 1) {
            dp[1][0][2] = input[0] == 2 ? 1 : 0;
        }

        // DP 테이블 채우기
        for (int t = 0; t < T-1; t++) {
            for (int w = 0; w <= W; w++) {
                // 1번 위치에 있는 경우
                if (dp[w][t][1] >= 0) {
                    // 1번에 그대로 머무르는 경우
                    dp[w][t+1][1] = Math.max(dp[w][t+1][1], dp[w][t][1] + (input[t+1] == 1 ? 1 : 0));

                    // 2번으로 이동하는 경우 (이동 횟수가 남아있을 때)
                    if (w < W) {
                        dp[w+1][t+1][2] = Math.max(dp[w+1][t+1][2], dp[w][t][1] + (input[t+1] == 2 ? 1 : 0));
                    }
                }

                // 2번 위치에 있는 경우
                if (dp[w][t][2] >= 0) {
                    // 2번에 그대로 머무르는 경우
                    dp[w][t+1][2] = Math.max(dp[w][t+1][2], dp[w][t][2] + (input[t+1] == 2 ? 1 : 0));

                    // 1번으로 이동하는 경우 (이동 횟수가 남아있을 때)
                    if (w < W) {
                        dp[w+1][t+1][1] = Math.max(dp[w+1][t+1][1], dp[w][t][2] + (input[t+1] == 1 ? 1 : 0));
                    }
                }
            }
        }

        // 최종 결과 계산
        int maxJadu = 0;
        for (int w = 0; w <= W; w++) {
            maxJadu = Math.max(maxJadu, Math.max(dp[w][T-1][1], dp[w][T-1][2]));
        }

        answer = maxJadu;


    }

    private static void dfs(int cnt, int foodCount, int moveCount, int curLoc) {
        if(moveCount==0){
            for(int i = cnt ; i<T ;i++){
                if(input[i]  == curLoc){
                    foodCount++;
                }
            }
            answer = Math.max(answer,foodCount);
            return;
        }

        if(cnt ==T){
            answer = Math.max(answer,foodCount);
            return;
        }


        if(curLoc == input[cnt]){
            dfs(cnt+1,foodCount+1,moveCount,curLoc);
        }else{
            // 이동을 해서 얻을것인가
            dfs(cnt+1,foodCount+1,moveCount-1,curLoc == 1? 2 :1 );

            dfs(cnt+1,foodCount,moveCount,curLoc );


        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        input= new int[T] ;
        for(int t = 0 ; t < T ; t++){
            int treeNum = Integer.parseInt(br.readLine());
            input[t]=treeNum;
        }

    }



}
