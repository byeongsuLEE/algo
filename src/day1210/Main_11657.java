package day1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 작성자   : 이병수
 * 작성날짜 : 2024-12-10
 * 설명    : 타임머신! - 벨만포드를 연습해봅시다.
 */
public class Main_11657 {
    private static long[] dist;
    private static List<Edge> edges;
    private static int N;

    private static class Edge {
        int start ;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        
        init();
        solution();
    }

    private static void solution() {

        for(int i = 0 ; i < N ; i++){
            for(Edge e : edges) {
                if(dist[e.start] != Long.MAX_VALUE && dist[e.end] > dist[e.start]+e.weight) {
                    if(i == N-1){
                        // 음수 사이클 발생
                        System.out.print(-1);
                        return ;
                    }
                    dist[e.end] = dist[e.start]+e.weight;
                }
            }


        }

        StringBuilder sb = new StringBuilder();


        for (int i = 2 ; i<=N ;i++){
            if(dist[i] == Long.MAX_VALUE) {
                dist[i] = -1;
            }
            sb.append(dist[i]).append("\n");
        }
        System.out.print(sb.toString());



    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수

        dist  = new long [N+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[1] =  0 ;
        edges =  new ArrayList<>();


        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start,end,weight));
        }


    }
}
