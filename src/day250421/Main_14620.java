package day250421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-21
 * 풀이방법
 * 조합 + 4방향 탐색
 * 1. 조합 nC3  범위 1~ n-2
 * 2. 4방향 하면서 방문되었으면 boolean false
 * 3. 겹치는게 없으면 최소값 비교
 **/


public class Main_14620 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[][] map;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[][] visited;
    private static int[][] selected;
    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};
    private static int cost;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        sb.append(answer);
        System.out.println(sb.toString());
    }

    private static void solution() {
        combination(0, 1, 1, 0);
    }

    private static void combination(int cnt, int start, int startj, int sum) {
        if (answer < sum) {
            return;
        }

        if (cnt == 3) {
            cost = sum;
            if (isPutFlower()) {
                answer = Math.min(answer, cost);
            }
            return;
        }

        //테두리 부분은 제외하고 1~N-2 범위만 선택하자
        for (int i = start; i < N - 1; i++) {
            for (int j = (i==start?startj : 1 ) ; j < N - 1; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                selected[cnt][0] = i;
                selected[cnt][1] = j;

                if (j + 1 == N - 1) {
                    combination(cnt + 1, i + 1, 1, sum + map[i][j]);
                } else {
                    combination(cnt + 1, i, j + 1, sum + map[i][j]);
                }
                visited[i][j] = false;
            }
        }
    }

    private static boolean isPutFlower() {
        boolean visited2[][] = new boolean[N][N];
        int tempcost = 0;
        for (int[] loc : selected) {
            int r = loc[0];
            int c = loc[1];

            if(visited2[r][c]) return false;
            visited2[r][c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) return false;

                if (visited2[nr][nc]) {
                    return false;
                }
                visited2[nr][nc] = true;
                tempcost += map[nr][nc];
            }
        }
        cost+= tempcost;
        return true;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        selected = new int[3][2];
    }
}
