package day250306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-06
 * 풀이방법
 * 모든 합 LIST 만들기 + 해쉬
 * 1. 모든 A의 부분배열 들을 구해서 해쉬에 넣기
 * 2. T-BSUM 에 ASUM 해쉬에 값이 있으면 COUNT
 **/


public class Main_2143_두배열의합 {
    private static StringBuilder sb= new StringBuilder();
    private static int T;
    private static int A,B;
    private static long[] aNum;
    private static long[] bNum;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    // 모든 합을 넣는다.
    // T-합 존재 할 시 COUNT 증가
    private static void solution() {
        Map<Integer, Integer> sumCheckMap = new HashMap<>();
        for ( int i  = 0 ; i < A ;i++){
            int sum = 0;
            for(int j =i ; j< A ;j++){
                sum += aNum[j];
                sumCheckMap.put(sum,sumCheckMap.getOrDefault(sum,0)+1);
            }
        }

        long count =0;
        for ( int i  = 0 ; i < B ;i++){
            int sum = 0;
            for(int j =i ; j< B ;j++){
                sum += bNum[j];
                count +=sumCheckMap.getOrDefault(T - sum, 0);
            }
        }


        System.out.println(count);

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T =Integer.parseInt(br.readLine());
        A = Integer.parseInt(br.readLine());
        aNum = new long [A];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            aNum[i]  =Integer.parseInt(st.nextToken());
        }
        B= Integer.parseInt(br.readLine());
        bNum = new long [B];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            bNum[i]  =Integer.parseInt(st.nextToken());
        }
    }
}
