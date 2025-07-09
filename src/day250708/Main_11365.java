package day250708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 작성자  : lbs
 * 날짜    : 2025-07-08
 * 풀이방법
 **/


public class Main_11365 {
    private static StringBuilder sb= new StringBuilder();
    private static ArrayList<String> strList;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        strList.stream()
                .forEach(
                        str -> sb.append(new StringBuilder(str)
                                        .reverse()
                                )
                                .append("\n")
                );


    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strList = new ArrayList<>();
        String input = null;
        while(!(input=br.readLine()).equals("END")){
            strList.add(input);
        }

    }
}
