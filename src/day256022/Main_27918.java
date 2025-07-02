package day256022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-22
 * 풀이방법
 **/


public class Main_27918 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static char[] input;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        int dangoCount = 0;
        int pohixCount = 0 ;
        for(int i = 0 ; i < N ; i++){
            if(input[i] == 'D'){
                dangoCount++;
            }else{
                pohixCount++;
            }

            if(Math.abs(pohixCount-dangoCount) >=2) break;
        }
        sb.append(dangoCount).append(':').append(pohixCount);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        input = new char[N];
        for(int i=0;i<N;i++){
            input[i] = br.readLine().charAt(0);
        }
    }
}
