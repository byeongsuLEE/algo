package day250318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-18
 * 풀이방법 구현
 * 변수를 줄이고 더 효울적인 코드 없을까?
 **/


public class Main_1110 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
       int count  = 0 ;
       int calculatedNum = N ;
        while (true){
           int sum = calculatedNum /10 + calculatedNum%10;
            calculatedNum =calculatedNum%10 *10 + sum %10 ;
           count++;
           if(calculatedNum ==N) break;

       }
        sb.append(count);
        System.out.println(sb.toString());
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

    }

}
