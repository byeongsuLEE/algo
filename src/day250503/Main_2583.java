package day250503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-03
 * 풀이방법
 * 직사각형 영역을 제외한다.
 * 제외한 영역을 뺴고 bfs를 돌린다.
 **/


public class Main_2583 {
    private static StringBuilder sb= new StringBuilder();
    private static int R,C,K;
    private static boolean[][] map;
    private static ArrayList<Integer> list;
    private static int dr[] = {0,0,1,-1};
    private static int dc[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for ( int width : list){
            sb.append(width).append(" ");
        }
        System.out.println(sb.toString());
    }
    private static void solution() {

        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(map[i][j]) continue;
                bfs(i,j);
            }
        }
    }


    private static void bfs(int i, int j) {
        int totalWidth = 0;
        Queue<int [] > q = new LinkedList<>();
        q.offer(new int [] {i,j});
        map[i][j]= true;

        while(!q.isEmpty()){
            int [] cur = q.poll();
            int r = cur[0];
            int c= cur[1];

            totalWidth++;

            for(int d = 0 ;  d< 4 ; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >=R  || nc < 0 || nc >=C) continue;
                if(map[nr][nc]) continue;
                map[nr][nc]= true;
                q.offer(new int [] {nr,nc});
            }
        }

        //넓이를 리스트에 추가
        list.add(totalWidth);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map =new boolean[R][C];
        list = new ArrayList<Integer>();
        for (int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            int leftC = Integer.parseInt(st.nextToken());
            int leftR = Integer.parseInt(st.nextToken());
            int rightC= Integer.parseInt(st.nextToken());
            int rightR = Integer.parseInt(st.nextToken());

            for(int r = leftR ; r < rightR ; r++){
                for (int c = leftC ; c < rightC ; c++){
                    map[r][c]=true; // 못간다 체크
                }
            }
        }
    }

}
