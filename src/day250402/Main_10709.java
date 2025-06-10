package day250402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-02
 * 풀이방법 2
 * 구름 index 기록하고 구름이 아닌 경우의 index를 뺴준다.
 *
 * 풀이 방법 1
 * 구름 클래스를 만들자.
 * 구름을 q에 넣는다.
 * q를 동쪽으로 옮긴다.
 * 0을 만나면 q에 넣지말자
 * -1 을 만나면 현재 시간을 기록해보자
 **/


public class Main_10709 {
    private static StringBuilder sb = new StringBuilder();
    private static int H, W;
    private static char[][] map;
    private static int[][] timeMap;
    private static Queue<Cloud> cloudQ;

    private static class Cloud {
        int r;
        int c;
        int time;

        public Cloud(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution2();
        print();
    }

    private static void print() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(timeMap[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void solution2(){
        for (int i = 0; i < H; i++) {
            int startCloudIndex = -1;
            for (int j = 0; j < W; j++) {
                if(map[i][j] =='c')
                {
                    startCloudIndex = j;
                    timeMap[i][j] = 0;
                }
                else {
                    if(startCloudIndex >= 0) { // 구름이 앞에 있음녀ㅑ
                       timeMap[i][j] = j-startCloudIndex;
                    }
                }

            }
        }
    }

    private static void solution() {
        // 구름의 위치들을 오른쪽으로 한칸씩옮기면서


        while (!cloudQ.isEmpty()) {
            Cloud curCloud = cloudQ.poll();
            int r = curCloud.r;
            int c = curCloud.c;
            int time = curCloud.time;

            // c >= W 크거나 같으면 q에 넣지마라
            int nc = c + 1;

            if (nc < W) {
                if (timeMap[r][nc] == -1) {
                    timeMap[r][nc] = time + 1;
                } else if (timeMap[r][nc] == 0) { // 오른쪽이 구름이였을 경우 큐에 넣지마
                    continue;
                }
                cloudQ.add(new Cloud(r, nc, time+1));
            }


        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        timeMap = new int[H][W];
        cloudQ = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            Arrays.fill(timeMap[i], -1);
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
//                if (map[i][j] == 'c') {
//                    cloudQ.add(new Cloud(i, j, 0));
//                    timeMap[i][j]=0;
//                }
            }
        }
    }
}
