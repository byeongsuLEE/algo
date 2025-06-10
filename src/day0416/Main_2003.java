package day0416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-16
 * 풀이방법
 **/


public class Main_2003 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int M;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        int count= 0;
        int start= 0;
        int end =0;
        int sum = 0;
        while(start<N  ){
            //작으면 더해준다.
            if(sum < M  && end < N ){
                sum+= numbers[end];
                end++;
            }
            else if(sum==M) {
                sum-=numbers[start];
                start++;
                count++;
            }
            //작지 않다면 뺴준다.
            else {
                sum -= numbers[start];
                start++;
            }
        }
        sb.append(count);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N] ;
        st=new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}
