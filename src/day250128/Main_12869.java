package day250128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**

 작성자 : 이병수
 날짜 : 2025-01-28
 풀이 방법
 pq 사용
 이유 : 계산 후 큰 수를 먼저 꺼내기 위해 정렬을 편하게 하기 위해서
 **/
public class Main_12869 {
    private static int N;
    private static int [] damages = {9,3,1};
    private static int[] SCVHp;
    private static int[] num;
    private static Queue <int [] > q;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }
    private static void solution() {
        int scvCount = N;
             q = new ArrayDeque<>();
             visited= new boolean[61][61][61];
        visited[SCVHp[0]][SCVHp[1]][SCVHp[2]] = true;
        q.offer(new int [] {SCVHp[0],SCVHp[1],SCVHp[2],0});

        int answer= 0;

        while(!q.isEmpty()) {

                int [] cur = q.poll();
                int a = cur[0];
                int b = cur[1];
                int c= cur[2];
                int time = cur[3];
                if(a==0&& b ==0  && c == 0) {
                    answer = time;
                    break;
                }
                permutaion(0,cur);
            }

        System.out.println(answer);

    }

    private static boolean [] selected = new boolean[61];

    private static void permutaion(int cnt, int[] n) {
        if(cnt==3){
            int a = Math.max((n[0] - num[0]), 0);
            int b = Math.max((n[1] - num[1]), 0);
            int c = Math.max((n[2] - num[2]), 0);
            if(visited[a][b][c]) return;
            visited[a][b][c] =true;
            q.offer(new int [] {a,b,c,n[3]+1});
            return;
        }

        for(int i = 0 ; i <3;i++){
            if(selected[i]) continue;
            selected[i] = true;
            num[cnt] = damages[i];
            permutaion(cnt+1,n);
            selected[i] = false;
        }
    }

    private static void init() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        SCVHp  = new int [3];
        num = new int [3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SCVHp[i] = Integer.parseInt(st.nextToken());
        }
    }
}