package day250616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-16
 * 풀이방법
 **/


public class Main_2491 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] bigDp;
    private static int[] input;
    private static int[] shortDp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        bigDp = new int [N+1];
        shortDp = new int [N+1];
        shortDp[1] = 1;
        bigDp[1]= 1;
        int longLength = 1;
        for(int i = 2 ; i <= N ; i++){
            if( input[i] < input[i-1]){
                bigDp[i] = 1;
                shortDp[i] = shortDp[i-1]+1;

            }else if(input[i] > input[i-1]){
                bigDp[i] = bigDp[i-1]+1;
                shortDp[i] =1;
            }else{
                bigDp[i] = bigDp[i-1]+1;
                shortDp[i] = shortDp[i-1]+1;
            }

            longLength = Math.max(longLength, Math.max(bigDp[i], shortDp[i]));

        }

        sb.append(longLength);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        input = new int [N+1];
        st= new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=N ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
    }
}
