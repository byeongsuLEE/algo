package day250125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-01-25
 * 풀이방법
 * 1. bfs + visited[time][x]
 * k에 도착할 떄 flag =true;
 * 같은 시간의 큐 안의 x 값이 k일떄 개수 체크
 **/


public class Main_12851 {
    private static int N, K, answerTime, answerCount;
    private static boolean arriveFlag;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();


    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(answerTime).append("\n");
        sb.append(answerCount);


        System.out.println(sb.toString());
    }


    private static void solution() {

        Queue<int[]> q = new ArrayDeque<>();   // [1] = x좌표 ,  [2] 시간
        q.offer(new int[]{N, 0});
        int[] visited = new int[100001]; // 어처피 k가 큰 x좌표를 방문할경우 절떄 더 빨리 도착안됨 버리자.
        Arrays.fill(visited, -1);
        visited[N] = 0;  // 방문처리
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int time = cur[1];

            // 도착 이후의 큐 처리 방지
            if (arriveFlag && time > answerTime) break;

            // 동생 위치에 도달한 경우
            if (x == K) {
                if (!arriveFlag) { // 최초 도착 시
                    arriveFlag = true;
                    answerTime = time;
                }
                answerCount++; // 같은 시간에 도달한 경우 카운트 증가
                continue; // 다음 탐색
            }
            int[] dx = {x - 1, x + 1, 2 * x};
            for (int i = 0; i < 3; i++) {
                int nx = dx[i];
                if (nx < 0 || nx > 100000) continue;

                if (visited[nx] == -1 || visited[nx] == time + 1) { // 방문하지않거나 || 같은 시간 방문 시 q에 넣기
                    visited[nx] = time + 1;
                    q.offer(new int[]{nx, time + 1});

                }
            }

        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


    }
}
