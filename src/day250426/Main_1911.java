package day250426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-26
 * 풀이방법
 **/


public class Main_1911 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int L;
    private static Integer[][] input;
    private static int length;
    private static boolean[] map;
    private static int count;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        int lastIndex = -1;
        for (Integer[] water : input) {
            int start = Math.max(water[0], lastIndex); // 이미 덮은 부분 넘어가야 함
            int end = water[1];
            if(start < end){
                int diff = end - start;
                int boardCount = 0 ;
                boardCount = diff/L;
                boardCount = diff % L ==0 ? boardCount : boardCount+1;
                count += boardCount;

                lastIndex = start+boardCount *L;
            }
        }
        sb.append(count);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        input = new Integer [N][2];
        length = 0;
        for(int i = 0 ; i < N ; i++){
            st= new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            length = Math.max(length, input[i][1]);
        }

        Arrays.sort(input,(a,b)-> Integer.compare(a[0],b[0]));


//        map = new boolean [length+1];
//        for(int i = 0 ; i < N ; i++){
//            int start =input[i][0];
//            int end =input[i][1];
//            for(int j =  start; j <end ; j++){
//                map[j] = true;
//            }
//        }

    }

}
