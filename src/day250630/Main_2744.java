package day250630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-30
 * 풀이방법
 **/


public class Main_2744 {
    private static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();


        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution(String str) {
        str.chars()
                .mapToObj(ch -> (char)ch)
                .map(((ch)->
                    Character.isUpperCase(ch) ? Character.toLowerCase(ch): Character.toUpperCase(ch)
                ))
                .forEach(sb::append);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        solution(str);
    }
}
