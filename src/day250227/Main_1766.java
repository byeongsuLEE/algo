package day250227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-02-27
 * 풀이방법 :
 * 위상정렬
 * 1. 각 노드의 진입차수를 적는다.
 * 2. 진입차수가 0인 노드를 q에 넣는다.
 * 3. q에 하나 꺼내서 연결된 노드들의 진입차수를 제거한다.
 * 4. q가 빌때까지 반복하면서 q가 꺼낸 순서를 저장한다.
 *
 * 풀이방법
 * arrayList<arrayList<Integer>> 노드끼리의 연결정보를 이중 arraylist로 표현한다.
 * int [N+1] = 해당 노드의 개수를 구한다.
 * pq를 이용해 숫자가 낮은거부터 두면될듯? 기본적으로 오름차순이니 pq만 이용해보자.
 *
 *
 **/


public class Main_1766 {
    private static StringBuilder sb= new StringBuilder();
    private static int[] enterCount;
    private static int N;
    private static int M;
    private static List<ArrayList<Integer>> graph;
    private static PriorityQueue<Integer> pq;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        // 위상정렬
        StringBuilder sb = new StringBuilder();
        visited = new boolean[N+1];
        pushPQ();
        while(!pq.isEmpty()){
            Integer curNode = pq.poll();
            sb.append(curNode).append(" ");

            for(int adjNode : graph.get(curNode)){
                if(--enterCount[adjNode] == 0 ){
                    pq.offer(adjNode);
                    visited[adjNode]= true;
                }
            }

        }

        System.out.println(sb.toString());
    }

    public static void pushPQ(){
        for(int i = 1 ; i <=N ; i++ ){
            if(visited[i]) continue;
            if(enterCount[i] == 0) {
                pq.offer(i);
                visited[i]= true;
            }
        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        enterCount = new int [N+1];
        pq = new PriorityQueue<>();

        graph = new ArrayList<>();
        for(int i = 0 ; i <=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ;  i < M ; i++) {
            st= new StringTokenizer(br.readLine());
            int firstSolveNode = Integer.parseInt(st.nextToken());
            int lastSolveNode = Integer.parseInt(st.nextToken());
            graph.get(firstSolveNode).add(lastSolveNode);
            enterCount[lastSolveNode]++;
        }


    }

}
