package day1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 작성자   : 이병수
 * 작성날짜 : 2024-12-09
 * 설명    :
 */
public class Main_1865 {
    public static StringBuilder sb = new StringBuilder();
    public static List<Edge> edges ;
    private static int N;
    private static int[] dist;
    private static String answer="";

    public static class Edge {
        int start;
        int end;
        int weight ;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());


        for(int t = 1 ; t <= T ; t++ ) {

            answer = "NO";
            init(br);
            solution();
//
//            System.out.println(Arrays.toString(dist));
//            System.out.println();

            sb.append(answer).append("\n");

        }

        System.out.println(sb.toString());

    }

    private static void solution() {
        // 모든 노드를 시작점으로 설정하여 벨만-포드 수행
            // N - 1번 모든 간선을 Relax   N번일떄 최소값이 된다면 음수 사이클 존재
            for (int i = 0; i < N; i++) {
                for (Edge e : edges) {
                    if ( dist[e.end] > dist[e.start] + e.weight) {
                        dist[e.end] = dist[e.start] + e.weight;
                        if(i==N-1){
                            answer = "YES";
                            return;
                        }

                    }
                }
            }


    }

    private static void init(BufferedReader br) throws IOException {
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        Arrays.fill(dist, 123456789);
        dist[1] = 0 ;
        edges = new ArrayList<>();
        for( int i = 0 ; i < M+S ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(i <M){
                edges.add(new Edge(start,end,weight));
                edges.add(new Edge(end, start, weight));
            }
            else{
                edges.add(new Edge(start,end,-weight));
            }

        }
    }
}
