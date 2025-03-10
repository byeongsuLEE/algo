package day250205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-02-05
 * 풀이방법
 * pq
 * 1. 보석을  큰 무게 부터 둔다.
 *🔥 효율적인 방법 (Greedy + Heap)
 * 보석을 무게 기준으로 오름차순 정렬
 *
 * 무거운 보석을 먼저 선택하면 작은 가방에 넣기 어려우므로, 무게가 가벼운 보석부터 확인하는 것이 유리함.
 * → 이렇게 하면 각 가방에 넣을 수 있는 보석을 순차적으로 확인 가능함.
 * 가방을 무게 제한 기준으로 오름차순 정렬
 *
 * 작은 가방부터 차례대로 처리하면, 남은 가방 중 가장 큰 가방만 고려하면 됨.
 * 가방을 작은 것부터 고려하면서 넣을 수 있는 보석 중 가장 비싼 보석을 선택하는 것이 핵심.
 * 가방을 하나씩 보면서 넣을 수 있는 보석을 힙에 저장 (최대 힙 사용)
 *
 * 현재 가방에 넣을 수 있는 모든 보석을 최대 힙(Max Heap, 우선순위 큐)에 추가
 * 우선순위 큐에서 가장 비싼 보석을 선택해서 가방에 넣음
 * → 이 과정을 반복하면 최적의 해를 찾을 수 있음
 **/


public class Main_1202 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int K;
    private static ArrayList<int[] > jewels = new ArrayList<>();
    private static ArrayList<Integer> bags = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        long sum = 0;
        int index = 0;
        PriorityQueue<Integer>  q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0 ; i < bags.size();i++ ){
            int currentBagWeight = bags.get(i); // 현재 가방의 무게

            for(int j = index ; j < jewels.size(); j++){

                int jewelWeight = jewels.get(j)[0];
                int cost = jewels.get(j)[1];

                if(currentBagWeight < jewelWeight) break;

                q.offer(cost);
                index=j+1;

            }
            if(q.isEmpty()) continue;
            int highCostJewel = q.poll();
            sum+=highCostJewel;

        }
        System.out.println(sum);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken()); // 보석
        K = Integer.parseInt(st.nextToken()); //

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            jewels.add(new int[]{weight,cost});
        }

        jewels.sort((a,b)-> Integer.compare(a[0],b[0]));


        for (int i = 0; i < K; i++) {
            int weight = Integer.parseInt(br.readLine());
            bags.add(weight);
        }
        Collections.sort(bags);


    }

}
