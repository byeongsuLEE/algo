package day250311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-11
 * 풀이방법
 * 1. que 를 이용해서 서브 쿼리 구하기 (실패 : 해당 노드가 루트인지 체크 할 수 없고 서브쿼리의 개수를 구하기가 visited 처리되어 구하기 어려움)
 * 2. dfs 재귀를 이용해보자.
 **/


public class Main_15681 {
    private static StringBuilder sb= new StringBuilder();
    private static int N,R,Q;
    private static int[] dp;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();

    }




    private static int dfs(int curNode) {
        if(dp[curNode]!=0){
            return dp[curNode];
        }

        int count =1;
        visited[curNode] = true;

        for(int adjNode : graph.get(curNode)){
            if(visited[adjNode]) continue;
            visited[adjNode]= true;
            count += dfs(adjNode);
        }

        dp[curNode]=count;
        return count;




//
//        Queue<Integer> q = new ArrayDeque<>();
//        q.offer(curNode);
//        visited[curNode]= true;
//        count++;
//        while(!q.isEmpty()){
//            int cur = q.poll();
//
//            for(int adjNode : graph.get(cur)){
//                if(visited[adjNode]) continue;
//                visited[adjNode]=true;
//
//                if(dp[adjNode]!=0){
//                    count+=dp[adjNode];
//                    continue;
//                }else {
//                    count+=1;
//                    q.offer(adjNode);
//                }
//
//            }
//
//        }
//
//        dp[curNode] = count;
//        sb.append(count).append("\n");

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        dp = new int[N+1];
        graph = new ArrayList<>();

        for(int i = 0 ; i <=N ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ;  i< N-1 ; i++ ){
           st=new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        visited = new boolean[N+1];
        dfs(R);
        for(int step = 0 ; step < Q; step++ ){
            int startNode = Integer.parseInt(br.readLine());

//            int count = dfs(startNode);
            sb.append(dp[startNode]).append("\n");

        }
        System.out.println(sb.toString());

    }

}
