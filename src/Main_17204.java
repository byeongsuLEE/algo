import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-05
 * 풀이방법
 **/


public class Main_17204 {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] human;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        int start = 1;
        Queue<int []> q = new LinkedList<>();
        q.offer(new int []{human[0],1});
        boolean[] visited = new boolean[N];
        visited[human[0]] = true;
        while(!q.isEmpty()) {
            int [] num = q.poll();
            int humanNum = num[0];
            int speakNum = num[1];

            if(humanNum == M) {
                sb.append(speakNum);
                return;
            }
            if(human[humanNum] != 0 && !visited[human[humanNum]]) {
                visited[human[humanNum]] = true;
                q.offer(new int []{human[humanNum],speakNum+1});
            }

        }
        sb.append(-1);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        human = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            human[i] = num;

        }
    }
}
