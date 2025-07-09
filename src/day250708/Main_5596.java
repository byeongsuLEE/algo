package day250708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-07-08
 * 풀이방법
 **/


public class Main_5596 {
    private static StringBuilder sb= new StringBuilder();
    private static Integer[] sumList;

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

        // stream의 모든 값이 같을 때 판단
        boolean isSameNum = Arrays.stream(sumList)
                .allMatch(sum -> sumList[0].equals(sum));


        // 값이 다를 떄 정렬 후 findFirst()
        Integer largeValue = Arrays.stream(sumList)
                .sorted(Collections.reverseOrder())
                .findFirst().get();

        sb.append(largeValue);


    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sumList = new Integer[2];

        for(int i = 0 ; i < 2 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j = 0 ; j < 4 ; j++){
               sum += Integer.parseInt(st.nextToken());
            }
            sumList[i] = sum;
        }
    }
}
