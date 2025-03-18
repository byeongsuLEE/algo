package day250317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-17
 * 풀이방법
 **/


public class Main_17389 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static String oxStr;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        //0 점일 떄 보너스 점수를 더한다.-> 보너스 값 증가
        int sum = 0 ;
        int bonusScore = 0;
        //기본점수는 i+1점
        for (int i = 0; i < oxStr.length(); i++) {
            if(oxStr.charAt(i)=='O'){
                sum+= (i+1 + bonusScore++);
            }else{
                bonusScore=0;
            }
        }
        sb.append(sum);
        System.out.println(sb.toString());
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N =Integer.parseInt(br.readLine());
        oxStr = br.readLine();

    }
}
