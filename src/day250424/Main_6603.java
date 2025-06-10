package day250424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-24
 * 풀이방법
 **/


public class Main_6603 {
    private static StringBuilder sb= new StringBuilder();
    private static int K;
    private static int[] input;
    private static int[] selected;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        combination(0,0);
        sb.append("\n");
    }

    private static void combination(int cnt, int start) {
        if(cnt == 6){

            for(int num : selected){
                sb.append(num).append(" ");
            }

            sb.append("\n");
            return;
        }

        for(int i = start ; i < K ; i++){
            selected[cnt] =input[i];
            combination(cnt + 1, i+1);
        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        while(true){
            st= new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K ==0) break;
            input= new int [K] ;
            for(int i = 0 ; i < K ; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            selected = new int[6];
            solution();
        }
    }
}
