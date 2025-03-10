package day250303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-03
 * 풀이방법
 * 1. 플로이드 워샬 + DFS (실패)
 * 2. **DP + 비트마스킹** (성공)
 *    - `dp[visited][cur]`: 현재 `cur` 위치에서 `visited` 상태일 때, 남은 모든 도시를 방문하고 출발점으로 돌아가는 최소 비용을 저장
 *    - `visited`: 비트마스킹을 활용하여 현재까지 방문한 도시 상태를 저장 (예: `0001`, `0011`, `0111` ...)
 *    - **DFS(재귀)로 모든 경우 탐색 + DP로 중복 연산 방지**
 */

public class Main_2099_외판원순회 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[][] map;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }


    private static void solution() {

        int answer =dfs(1, 0);
        System.out.println(answer);
    }

    private static int dfs(int visited, int cur) {

        if(( visited == (1 <<N)-1)){
            return map[cur][0] > 0 ? map[cur][0] : 16_000_000; // 갈 수 없는 경우 큰 값 반환
        }

        if(dp[visited][cur]!=-1){
            return dp[visited][cur];
        }

       int minDistance = 16_000_000;
        for(int next = 0 ; next <N; next++ ){
             if(cur == next ) continue;
             //방문하지않고, 갈수 있으면
             if((visited & (1 << next))==0  && map[cur][next]>0){
                 int distance = map[cur][next] + dfs(visited | (1 << next),next);
                 minDistance= Math.min(distance, minDistance);
            }
        }

        return dp[visited][cur]= minDistance;

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int [1<<N][N];

        for(int i = 0 ; i < N ; i++){
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());


            }
        }

        for (int i = 0; i < (1 << N); i++) {
            Arrays.fill(dp[i], -1);
        }

    }

}
