package day250318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-18
 * 풀이방법
 **/


public class Main_1652 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        int rCount =0;
        int cCount = 0;
        for (int i = 0; i < N; i++) {

            //가로
            int length = 0;
            for (int j = 0; j < N; j++) {
                if(map[i][j] == '.'){
                    length++;
                }
                else{
                    if(length>=2){
                        rCount++;
                    }
                    length=0;
                }
            }


            if(length>=2){
                rCount++;
            }
             length = 0;
            //세로
            for (int j = 0; j < N; j++) {
                if(map[j][i] == '.'){
                    length++;
                }
                else{
                    if(length>=2){
                        cCount++;
                    }
                    length=0;
                }
            }
            if(length>=2){
                cCount++;
            }

        }
        System.out.println(rCount + " "+  cCount);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N =Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
    }
}
