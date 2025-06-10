package day250425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-25
 * 풀이방법 1.dfs(정답)
 * 출력의 규칙을 파악해보자
 * 1. 순서에서 가운데를 출력한다.
 * 2. 왼쪽과 오른쪽을 나눠서 가운데를 출력한다.
 *
 *
 * 2. bfs도 될꺼같은데?
 *
 **/


public class Main_9934 {
    private static int K;
    private static int[] input;
    private static boolean[] visited;
    private static StringBuilder[] sb;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        for (StringBuilder s : sb){
            System.out.println(s.toString());
        }

    }
    private static void solution() {
        //
        bfs();

//        dfs(0,input.length,0);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,input.length-1,0});

        while(!q.isEmpty()){
            int[] arrange = q.poll();
            int start = arrange[0];
            int end = arrange[1];
            int step = arrange[2];

            int middleIndex = (start+end) / 2;

            if(visited[middleIndex]) continue;
            visited[middleIndex] = true;
            q.offer(new int [] {start , middleIndex-1,step+1});
            q.offer(new int [] {middleIndex+1, end, step+1});
            sb[step].append(input[middleIndex]).append(" ");
        }
    }

    private static void dfs(int start, int end,int cnt) {
        if(cnt ==K ){
            return;
        }
       int curIndex = (start+end)/2;

       if (visited[curIndex]) return;
       visited[curIndex] = true;
       sb[cnt].append(input[curIndex]).append(" ");

       dfs(start , curIndex-1, cnt+1);
       dfs(curIndex+1, end, cnt+1);

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        K = Integer.parseInt(br.readLine());
        int length  = (int) Math.pow(2, K) - 1;
        input = new int[length];
        st = new StringTokenizer(br.readLine());
        visited= new boolean[length];
        sb = new StringBuilder[K];
        for(int i = 0 ; i < K ; i++){
           sb[i] = new StringBuilder();
        }
        for(int i = 0 ; i < length ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

    }
}
