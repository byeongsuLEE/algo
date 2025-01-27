package day250124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-01-24
 * 풀이방법
 * 다익스트라로 풀겠다.
 * 이유 : 양의 값 및 a-> b 까지의 최단경로를 구하기 떄문에.
 * 이전 경로 저장 : pq.offer() 될떄 이전 경로를 저장하여 역추적을 해보자
 * 출력은 stack에 넣고 뺴자
 **/


public class Main_11779 {
    private static int N,M;
    private static int[] dist;
    private static int startNode,endNode;
    private static PriorityQueue<Edge> pq  = new PriorityQueue<>();
    private static boolean[] visited;
    private static ArrayList<ArrayList<Edge>> graph;
    private static int[] prev;

    public static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;

        public Edge(int vertex, int value) {

            this.vertex = vertex;
            this.cost = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost,o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {

        StringBuilder sb = new StringBuilder();
        sb.append(dist[endNode]).append("\n");
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(endNode);
        int prevVertex = 0;
        while((prevVertex=prev[stack.peek()])!=0){
            stack.add(prevVertex);
        }

        sb.append(stack.size()).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void solution() {


        prev = new int[N+1];

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            int vertex = cur.vertex;
            int cost = cur.cost;


            if(visited[vertex]) continue;
            visited[vertex] = true;


            for(Edge adjEdge : graph.get(vertex)){

                int adjVertex = adjEdge.vertex;
                int adjCost = adjEdge.cost;

                if(dist[adjVertex] > cost + adjCost){

                    dist[adjVertex] = cost+ adjCost;
                    pq.offer(new Edge(adjVertex,dist[adjVertex]));
                    prev[adjVertex] = vertex;
                }

            }




        }


    }



    private static void init() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        M =Integer.parseInt(br.readLine());

        dist= new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
         graph = new ArrayList<>();

        StringTokenizer st = null;

        for(int i = 0 ; i <=N ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0; i < M ;i++){
            st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end,cost));
        }

        st= new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        dist[startNode] = 0;
        pq.offer(new Edge(startNode,dist[startNode]));
        visited = new boolean[N+1];
    }
}
