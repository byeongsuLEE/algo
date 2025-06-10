package day250406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-06
 * 풀이방법
 **/


public class Main_3474 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        int fiveCount= 0;
        for(int i = 5 ; N / i > 0 ; i*=5){

            fiveCount = fiveCount + (N/i);



        }
        sb.append(fiveCount).append("\n");
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t <T ; t++){
            N =Integer.parseInt(br.readLine());
            solution();
        }
    }
}
