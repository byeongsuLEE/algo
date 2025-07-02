package day0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-13
 * 풀이방법
 **/


public class Main_5543 {
    private static StringBuilder sb= new StringBuilder();
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
        int minValue = Integer.MAX_VALUE ;

        for(int i = 0 ; i < 3; i++){
            minValue = Math.min(minValue, Math.min(input[3],input[4])+input[i]-50);
        }
        sb.append(minValue);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input= new int[5];
        for(int i = 0 ;  i<5; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        int ddd [] = new int[5];
            
    }
}
