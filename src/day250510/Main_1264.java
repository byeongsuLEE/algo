package day250510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-10
 * 풀이방법
 **/


public class Main_1264 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        Map<Character, Character> moum = new HashMap<Character, Character>();
        moum.put('a','a');
        moum.put('e','e');
        moum.put('o','o');
        moum.put('u','u');
        moum.put('i','i');


        while (!(str = br.readLine()).equals("#")) {
            int count = 0 ;
            for( char ch : str.toCharArray()){
                char lowerCase = Character.toLowerCase(ch);
                if(moum.containsKey(lowerCase)) count++;
            }
            sb.append(count).append("\n");
        }

    }

}
