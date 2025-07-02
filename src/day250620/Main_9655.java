package day250620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-20
 * 풀이방법
 **/


public class Main_9655 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        //상근이 순서를 홀수, 창영이 짝수
        int count =1 ;
        while(true){

            if(N >= 3){
                N -= 3;
            }
            else{
                N -=1;
            }

            if(N ==0){
                break;
            }
            count++;
        }

        sb.append(count % 2 ==0 ?  "CY" : "SK" );


    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
    }

}
