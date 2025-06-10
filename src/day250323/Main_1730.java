package day250323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-23
 * 풀이방법
 **/


public class Main_1730 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static char[][] map;
    private static String directs;
    private static int nr,nc;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        for(int i = 0 ; i < N ; i++){
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void solution() {

        int r = 0 ,c =0;

        for(int i = 0 ; i < directs.length(); i++){
            char ch = directs.charAt(i);

            //로봇 움직이기
            movetoDirect(ch, r, c);

            // 범위에 벗어나면 무시하기
            if(nr < 0 || nr >=N  || nc < 0 || nc >=N ) continue;

            //현재 방향과 다음 방향 선 긋기
            setLine(r,c,ch);
            setLine(nr,nc,ch);

            // 로봇 위치 바꾸기
            r=nr;
            c=nc;
        }

    }

    private static void setLine(int r, int c, char ch) {
       if(ch == 'R' || ch =='L') {
           if(map[r][c] == '.') {
               map[r][c] = '-';
           }
           else if(map[r][c] == '|'){
                map[r][c]= '+';
           }
       }else{
           if(map[r][c] == '.'){
               map[r][c] = '|';
           }else if(map[r][c] == '-'){
               map[r][c]= '+';
           }
       }

    }

    private static void movetoDirect(char ch, int r, int c) {

        if(ch == 'R'){
            nr = r;
            nc = c +1;
        }else if (ch == 'L'){
            nr = r;
            nc = c -1;
        }else if(ch == 'U'){
            nr = r -1;
            nc = c;
        }else if (ch == 'D'){
            nr = r +1;
            nc = c;
        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N =Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(map[i],'.');
        }
         directs = br.readLine();

    }
}
