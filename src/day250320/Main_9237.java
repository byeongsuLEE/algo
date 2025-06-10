package day250320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-20
 * 풀이방법
 **/


public class Main_9237 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static Integer[] tree;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        //q에 넣기
        // 하루가 지나면 모든 q를 다꺼내서 다 지우고 다시집어넣기
        Arrays.sort(tree, (a, b) -> Integer.compare(b,a));

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ;i++){
            max = Math.max(max ,tree[i] + i+1 );

        }

//        Queue<Integer> q = new ArrayDeque<>();
//        Queue<Integer> tempQ = new ArrayDeque<>();
//        q.offer(tree[0]);
//        int plantedTreeIndex=1;
//        int grantedDay=2;
////        while(!q.isEmpty()){
////
////            // 나무를 심는다.
////            // 모든 큐에 있는걸 뺴자 날짜를 빼자
////            while(!q.isEmpty()){
////                int day = q.poll();
////                if( --day ==0) continue;  // 다 자랐으면 q에 넣지마
////                tempQ.offer(day);
////            }
////
////            // 나무를 심을 수 있으면
////            if(plantedTreeIndex < N ){
////                int treeDay =tree[plantedTreeIndex];
////
////                tempQ.offer(treeDay);
////                plantedTreeIndex++;
////            }
////            q = new ArrayDeque<>(tempQ);
////            tempQ.clear();
////
////            grantedDay++;
////        }

        sb.append(max+1);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        tree = new Integer [N];
        st =new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
    }
}
