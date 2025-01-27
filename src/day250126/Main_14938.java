    package day250126;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.StringTokenizer;

    /**
     * 작성자  : 이병수
     * 날짜    : 2025-01-26
     * 풀이방법
     * 1. dfs  + 백트래킹
     * 완탐을 하면서 값이 수색범위 m 보다 크면 가지치기
     * bfs로 하면 방문처리를 어떻게 할 지 모르겠음 -> 고로 dfs함
     * <p>
     * 질문
     * 1. java의 재귀호출의 제한은?
     * 재귀 호출 깊이가 10,000 이상이 예상되거나(언어마다 다름) 그래프의 크기가
     * 정도일 경우, 재귀 기반 DFS는 비효율적일 수 있습니다.
     * m≤15**로 제한적이므로, 재귀 호출로 인한 스택 오버헤드 문제는 크지 않습니다.
     *
     * 2. 시간복잡도는 ?
     * O ( n  * (n + r) ) 이라는데 잘모르겟음
     * dfs의 시간복잡도  =  n+r
     *  n * dfs() = n*(n+r) = O ( n* (n+r) )
     *
     *  3. 재귀의 깊이 제한
     *  재귀가 10^4 이상의 깊이가 되면 stakoverflow가 발생한다고한다.
     *
     **/


    public class Main_14938 {
        private static StringBuilder sb = new StringBuilder();
        private static int N, M, R;
        private static int[] items;
        private static boolean[] visited;
        private static int answer;
        private static int sum;
        private static boolean[] selected;

        private static class Edge {
            int vertex;
            int dist;

            public Edge(int vertex, int dist) {
                this.vertex = vertex;
                this.dist = dist;
            }

        }

        private static ArrayList<ArrayList<Edge>> graph;


        public static void main(String[] args) throws IOException {
            init();
            solution();
        }

        private static void solution() {

            answer = 0;
            for (int i = 1; i <= N; i++) {
                visited= new boolean[N+1];
                selected=new boolean[N+1];
                answer= Math.max(answer, dfs(0, i, 0));
            }

            System.out.println(answer);
        }

        // 기저조건 = 더크면 안된다. 깊이가 n보다 크면 안됨
        // 매개변수 : cnt (깊이) , curNode 현재노드 , dist ( 지금까지의 거리)
        // 방문한 노드를 체크 한다.
        private static int dfs(int cnt, int curNode, int dist) {

            // 거리가 m보다 커버리면 버리기 (가지치기)
            if(dist > M){
                return 0 ;
            }
            visited[curNode] = true;
            int totalItems = 0;

            // 해당 노드를 방문하지않을 때 아이템 수 더하기
            if (!selected[curNode]) {
                selected[curNode] = true;
                totalItems += items[curNode];
            }

            for (Edge adjEgde  : graph.get(curNode)){
                int adjVertex = adjEgde.vertex;
                int adjDist = adjEgde.dist;

                if (!visited[adjVertex] && dist + adjDist <= M) {
                    totalItems += dfs(cnt+1, adjVertex, dist + adjDist);
                }

            }
            visited[curNode] = false;


            return totalItems;
        }


        private static void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            items = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                items[i] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Edge(end, dist));
                graph.get(end).add(new Edge(start, dist));

            }

        }


    }
