package day250318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-18
 * 풀이방법
 **/


public class Main_10808 {
    private static StringBuilder sb= new StringBuilder();
    private static String str;
    private static int[] alphabetCount;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        for(int i = 0 ; i < str.length(); i++){
             alphabetCount[str.charAt(i)- 'a']++;
        }

        for(int count : alphabetCount){
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str= br.readLine();
        alphabetCount = new int[26];
    }
}
