package day250626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-26
 * 풀이방법
 **/


public class Main_13322 {
    private static StringBuilder sb= new StringBuilder();
    private static String input;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        String arrayStr[] = new String[input.length()];

        for(int i = 0 ; i < input.length(); i++){
            String str = "";

            for(int j = 0 ; j <= i ; j++){
                str += input.charAt(j);
            }
            arrayStr[i] = str;
        }

        Arrays.sort(arrayStr);



    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        input = br.readLine();
    }

}
