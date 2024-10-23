package day1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자   : user
 * 작성날짜 : 2024-10-21
 * 설명    :
 */
public class Main_21736 {
    private static int N,M,startR,startC;
    private static char[][] map;

    private static int dr[]  = {1,-1,0,0};
    private static int dc []  = {0,0,1,-1};
    private static int meetCount;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        init();
        solution();

    }

    private static void solution() {
        searchMap();
    }

    private static void searchMap() {
        //bfs 로탐색

        Queue<int []> q =  new LinkedList<>();
        q.offer(new int []{startR,startC});
        visited= new boolean[N][M];

        while(!q.isEmpty()) {
            int [] que = q.poll();
            int r = que[0];
            int c = que[1];
            if(map[r][c] =='P')
                meetCount++;

            for(int d = 0 ; d < 4 ; d++){
                int nr = r+dr[d];
                int nc = c+ dc[d];
                if(nr >=N || nr <0 ||  nc >=M || nc < 0) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]=='X') continue;
                visited[nr][nc] = true;
                q.offer(new int [] {nr,nc});
            }
        }
        if(meetCount ==0 ){
            System.out.println("TT");
            return;
        }
        System.out.println(meetCount);
    }

    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        meetCount = 0 ;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map  = new char[N][M];

        for(int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = charArray[j];
                if(map[i][j] =='I'){
                    startR = i;
                    startC = j;

                }
            }
        }

    }
}
