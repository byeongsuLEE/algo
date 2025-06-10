package day250501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-01
 * 풀이방법
 **/


public class Main_2468 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[][] map;
    private static int maxHeight;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        // 1~100까지
        // 100 x 10000 = 10^ 6승일듯?
        // 일단 완탐의 시간복잡도를 계산해보자.

        //1~100의 높이 이하의 물에 잠긴 후
        // 영역의 개수를 구해보자.

        //input 중에 최고의 높이까지

        int answer= 0;
        for(int height = 0;  height <=maxHeight; height++){
            visited= new boolean [N][N] ;

            //bfs
            int count = 0;
            for(int i = 0 ; i< N ; i++){
                for(int j = 0 ; j< N ; j++){
                    if(visited[i][j]) continue;
                    if(map[i][j] <= height) continue;
                    if(bfs(i,j,height)){
                        count++;
                    }
                }
            }

            answer= Math.max(answer,count);
        }

        sb.append(answer);

    }

    private static int dr []  = {0,0,1,-1};
    private static int dc []  = {1,-1,0,0};
    private static boolean bfs(int sr, int sc, int height) {

        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {sr,sc});

        while(!q.isEmpty()){
            int [] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d = 0 ; d < 4 ; d++){
                int nr = r+ dr[d];
                int nc = c+ dc[d];

                if(nr < 0 || nr >=N || nc < 0 || nc >=N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] <= height) continue;
                visited[nr][nc] = true;
                q.offer(new int [] {nr,nc});
            }
        }

        return true;
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        maxHeight = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
    }
}
