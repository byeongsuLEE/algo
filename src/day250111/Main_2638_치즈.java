package day250111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
    private static int N,M;
    private static Queue<int [] > cheeses;
    private static int[][] map;
    private static int cheesesCount;
    private static int[][] copyMap;

    public static void main(String[] args) throws IOException {

        init();
        solution();







    }

    private static void solution() {
        // 4방면 체크
        // 안에있는 치즈가 아닌 빈 공간은 -1로 둔다.
        // q에? 형태로 치즈를 담는다?
        // 치즈담아서 녹는건지 녹지않은건지 체크

        // 아니다 위의 방법은 틀렸따.
        // 0.0 에서 map을 기준으로 bfs를 돌려야함
        int answer =0;
        while(true){

            if(cheesesCount==0 )
                break;

            simulation();
            answer++;
        }

        System.out.println(answer);
    }

    private static void simulation() {
        copyMap = new int[N][M] ;
        for(int i = 0 ; i < N ; i++){
            copyMap[i] = map[i].clone();
        }
        bfs(0,0);
        updateMap();
    }

    private static int []dr = {0, 0 , 1,-1};
    private static int [] dc = {1, -1 ,0 ,0};

    private static void bfs(int sr, int sc) {

        Queue<int [] > q = new ArrayDeque<>();
        boolean [][] visited  = new boolean[N][M];
        q.offer(new int[]{sr,sc});

        while(!q.isEmpty()){

            int [] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d = 0 ; d <4 ; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >=N || nc >=M || nr < 0 || nc < 0)
                    continue;
                if(visited[nr][nc])
                    continue;
                if(copyMap[nr][nc]!=0){
                    copyMap[nr][nc]++;
                    continue;
                }
                visited[nr][nc]=true;
                copyMap[nr][nc] = -1;
                q.offer(new int []{nr,nc});



                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            }
        }
    }

    private static void updateMap() {

        for(int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < M ; j++){
                if(copyMap[i][j] >=3){
                    cheesesCount--;
                    map[i][j] = 0;
                }else if (copyMap[i][j] ==2 ){
                    map[i][j]=1;

                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cheeses =  new ArrayDeque<>();
        cheesesCount = 0 ;

        for(int i = 0  ; i < N ; i++){
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < M ; j++) {
                int number = Integer.parseInt(st.nextToken());
                if(number ==1){
                    cheeses.offer(new int[] {i,j,0});
                    cheesesCount++;
                }
                map[i][j] = number;
            }
        }
    }
}
