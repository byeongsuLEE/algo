package day250528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-05-28
 * 풀이방법
 **/


public class Main_11034 {
    private static StringBuilder sb= new StringBuilder();
    private static int[] input;

    public static void main(String[] args) throws IOException {
        initSolution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        int answer = 0;




        sb.append(Math.max(input[2] - input[1] , input[1]-input[0])-1).append("\n");

    }

    private static void initSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        input = new int[3];
        String str ;
        while((str = br.readLine())!=null){
            st= new StringTokenizer(str);

            for(int i = 0 ; i < 3 ; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            solution();
        }
    }

}
