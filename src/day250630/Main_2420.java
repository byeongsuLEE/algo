package day250630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-30
 * 풀이방법
 **/


public class Main_2420 {
    private static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution(Long n, Long m ) {
        sb.append(Math.abs(n-m));
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long N = Long.parseLong(st.nextToken());
        Long M = Long.parseLong(st.nextToken());


        BiConsumer<Long, Long> solution = Main_2420::solution;
        solution.accept(N, M);

    }


}
