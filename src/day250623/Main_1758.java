package day250623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-23
 * 풀이방법
 **/


public class Main_1758 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static Integer[] input;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        long sumTip = 0;
        Arrays.sort(input, Collections.reverseOrder());
        for (int i = 0 ; i < N ; i++){
            long tip = input[i] - (i);

            if(tip > 0){
                sumTip += tip;
            }
        }
        sb.append(sumTip);

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        input = new Integer [N];

        for(int i = 0 ; i < N ; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
    }

}
