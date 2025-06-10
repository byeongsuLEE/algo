package day250511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-11
 * 풀이방법
 **/


public class Main_2605 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] input;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];

        List<Integer> list = new LinkedList<>();
//        list.add(0,2);
//
//        for(int i : list){
//            System.out.println(i);
//        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> front = new ArrayDeque<>();
        Deque<Integer> total = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++){
            input[i] = Integer.parseInt(st.nextToken());

            if(input[i] ==0 ){
                total.add(i+1);
            }else{
                int index = i - input[i];
                if(index==0){
                    total.addFirst(i+1);
                    continue;
                }
                while(index-- > 0){
                    front.add(total.pollFirst());
                }

                total.addFirst(i+1);

                while(!front.isEmpty()){
                    total.addFirst(front.pollLast());
                }
            }
        }
        while(!total.isEmpty()){
            sb.append(total.pollFirst()).append(" ");
        }

    }
}
