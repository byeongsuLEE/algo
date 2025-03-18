package day250318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-18
 * 풀이방법
 **/


public class MaiN_2979 {
    private static StringBuilder sb= new StringBuilder();
    private static int[] cost;
    private static int[] timeCount;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cost = new int[4];
        timeCount = new int [101];
        for(int i = 1 ; i <=3 ; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1 ; i <=3 ; i++){
            st=new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int time = startTime ; time <end; time++ ){
                timeCount[time]++;
            }
        }
        int sum = 0 ;
        for(int count : timeCount){
            sum += (count *cost[count]);
        }
        sb.append(sum);
        System.out.println(sb.toString());



    }
}
