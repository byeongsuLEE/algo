package day1127;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자   : 이병수
 * 작성날짜 : 2024-11-27
 * 설명    : 파티요파티
 * 문제풀이
 * 1. 단방향이기 떄문에 오는 비용가 되돌아가는 비용이 다름
 * 2. 플로이드워샬을 쓰는 이유가 그거다 1 -> 3 의 최소 거리와  3->1의 최소비용을 저장해서 모든학생 거리를 구하고 오랜시간이 걸리는 친구를 뽑아보자
 * 2. 실패 이유 : X ^ 3 = 1000 ^ 3 = 10 ^9 시간초과남
 * 3. 다익스트라를 두번쓰자 , 학생 마을이 정해져있음 -> 시작점과 끝이 정해져있다.
 * 4. 파티가 열리는 마을을 기준으로 다익스트라를 두번 돌려보자.
 */
public class Main_1238 {
    static int N, M, X;
    static int[] dist;
    static StringTokenizer st = null;
    private static List<ArrayList<Node>> edge;

    public static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        init();
        solution();

    }

    private static void solution() {
        int[] distToX = dijkstra(X, edge); // 모든 마을에서 X로 가는 최단 거리
        int[] distFromX = dijkstra(X, reverseEdge(edge)); // X에서 모든 마을로 돌아오는 최단 거리

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, distToX[i] + distFromX[i]);
        }

        System.out.println(maxTime);
    }

    private static int[] dijkstra(int start, List<ArrayList<Node>> graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int num = node.num;
            int weight = node.weight;

            for (Node curNode : graph.get(num)) {
                int newWeight = weight + curNode.weight; // 새로운 거리 계산
                if (newWeight < dist[curNode.num]) { // 조건 만족 시에만 추가
                    dist[curNode.num] = newWeight;
                    pq.offer(new Node(curNode.num, newWeight)); // 큐에 추가
                }
            }
        }

        return dist;
    }


    private static List<ArrayList<Node>> reverseEdge(List<ArrayList<Node>> graph) {
        List<ArrayList<Node>> reversed = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            reversed.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            for (Node node : graph.get(i)) {
                reversed.get(node.num).add(new Node(i, node.weight));
            }
        }

        return reversed;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edge = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            edge.add(new ArrayList<>()); // 1번부터 시작할꺼니? 이렇게해야할듯
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node node = new Node(endNode, weight);
            edge.get(startNode).add(node);
        }


    }
}
