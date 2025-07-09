package day250708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자  : lbs
 * 날짜    : 2025-07-08
 * 풀이방법
 **/


public class Main_5596_v2 {
    private static StringBuilder sb= new StringBuilder();
    private static Integer[] sumList;
    private static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        // stream으로만 풀어보기

        // stream의 모든 값이 정렬 후 findFirst()
        int largeNum = list.stream()
                .mapToInt(
                        arrayList -> arrayList.stream()
                                .mapToInt(Integer::intValue)
                                .sum()

                )
                .max().getAsInt();

        sb.append(largeNum);


    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        list = new ArrayList<>();
        for(int i = 0 ; i < 2 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new ArrayList<>());
            for(int j = 0 ; j < 4 ; j++){
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
    }
}
