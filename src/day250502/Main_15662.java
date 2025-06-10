package day250502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-02
 * 풀이방법
 **/


public class Main_15662 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[][] tobnibaque;
    private static int K;
    private static int targetIndex;
    private static int direct;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        print();

        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.nativeOrder();
        System.out.println("이 시스템은 " + byteOrder + " 입니다.");
    }

    private static void print(){
        int count = 0;
        for(int i = 1 ; i <=N ; i++){
            if(tobnibaque[i][0] == 1){
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb.toString());
    }
    private static void solution() {
        // 바퀴 먼저 움직이기전에 양옆확인
        //2 and 6 index 확인
        int dr[] = {-1,1};
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {targetIndex,direct});
        visited= new boolean[N+1];
        visited[targetIndex]=true;

        while(!q.isEmpty()){
            int [] cur = q.poll();
            int n = cur[0]; // 1~ n까지의 톱니바퀴
            int dir = cur[1];
            int leftValue = tobnibaque[n][6];
            int rightValue = tobnibaque[n][2];


            for(int d = 0 ; d <2 ; d ++){
                int next = n + dr[d];
                if(next <= 0 || next >N ) continue;
                if(visited[next]) continue;

                int curValue  = d==0 ? leftValue: rightValue;
                int nextValue =  d==0 ? tobnibaque[next][2]: tobnibaque[next][6];
                if(curValue == nextValue) continue; // 같으면 회전하지 않는다.

                // s = r 극이 같지 않을 때 q에 넣자
                // 방향은 다르게, 방문체크
                q.offer(new int [] {next,dir * -1});
                visited[next]=true;
            }

            // 양옆을 q에 다 넣었다면 현재 바퀴를 돌려보자
            rotation(n,dir);

        }


    }

    private static void rotation(int n, int dir) {
        // dir =1 이면 시계방향 ->

        int lastValue = tobnibaque[n][7];
        if(dir == 1){
            for(int i = 7 ; i >0  ; i--){
                tobnibaque[n][i]= tobnibaque[n][i-1];
            }
            tobnibaque[n][0]=lastValue;
        }else{
            int firstValue = tobnibaque[n][0];
            for(int i = 0; i < 7; i++){
                tobnibaque[n][i] = tobnibaque[n][i+1];
            }
            tobnibaque[n][7] =firstValue;
        }


    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        tobnibaque = new int [N+1][8];
        for(int i = 1 ; i <= N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < 8 ; j++){
                tobnibaque[i][j] = s.charAt(j)-48;
            }
        }

        K = Integer.parseInt(br.readLine());
        for( int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            targetIndex = Integer.parseInt(st.nextToken());
            direct = Integer.parseInt(st.nextToken());
            solution();
        }

    }
}
