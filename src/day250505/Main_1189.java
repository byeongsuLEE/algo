package day250505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1189 {
    private static StringBuilder sb = new StringBuilder();
    private static int R;
    private static int C;
    private static int K;
    private static char[][] map;
    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        sb.append(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(R-1, 0, 1, new boolean[R][C])); // 시작점: 왼쪽 아래 (R-1, 0)

        // 각 노드마다 별도의 방문 배열을 가짐
        q.peek().visited[R-1][0] = true;

        int count = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 목적지에 도착하고 정확히 K 거리인지 확인
            if (cur.r == 0 && cur.c == C-1 && cur.depth == K) {
                count++;
                continue;
            }

            // 이미 K 거리를 초과했으면 더 이상 탐색하지 않음
            if (cur.depth >= K) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                // 범위 체크
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                // 장애물 체크
                if (map[nr][nc] == 'T') continue;

                // 현재 경로에서 이미 방문한 곳인지 체크
                if (cur.visited[nr][nc]) continue;

                // 새로운 방문 배열을 복사
                boolean[][] newVisited = new boolean[R][C];
                for (int i = 0; i < R; i++) {
                    System.arraycopy(cur.visited[i], 0, newVisited[i], 0, C);
                }
                newVisited[nr][nc] = true;

                q.offer(new Node(nr, nc, cur.depth + 1, newVisited));
            }
        }
        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
            }
        }
    }

    // 현재 위치, 깊이 및 방문 배열을 저장하는 클래스
    static class Node {
        int r, c, depth;
        boolean[][] visited;

        Node(int r, int c, int depth, boolean[][] visited) {
            this.r = r;
            this.c = c;
            this.depth = depth;
            this.visited = visited;
        }
    }
}