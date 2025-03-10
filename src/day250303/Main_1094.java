package day250303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-03
 * 풀이방법
 **/


public class Main_1094 {
    private static StringBuilder sb= new StringBuilder();
    private static int X;
    private static int answer;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
//        dfs(64,0);
        System.out.println(Integer.bitCount(X));
    }

    private static void dfs(int num, int  selected) {

        if(num > X-selected) {
            dfs(num>>1,selected);
            return;
        }
        selected = (selected | num);

        if(selected==X){
            int count = 0;
            for(int i = 1 ; i<=64 ; i=i<<1){
                if((selected & i )>0) count++;
            }
            answer= count;
            return ;
        }

        if( selected < X){
            dfs(num >> 1,  selected);
        }






    }


    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X =Integer.parseInt(br.readLine());


    }
}
