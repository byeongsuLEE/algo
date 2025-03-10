package day250215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-02-15
 * 풀이방법
 **/


public class Main_2440 {
    private static StringBuilder sb= new StringBuilder();
    private static int x ;
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        for(int i = 0 ; i <x ; i++){
            for(int j = x-i ; j > 0 ; j--){
                sb.append("*");
            }
                sb.append("\n");

        }
        System.out.println(sb.toString());
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        x=Integer.parseInt(br.readLine());

    }
}
