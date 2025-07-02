package day250627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-27
 * 풀이방법
 **/


public class Main_3063 {
    private static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T ;t++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c3 = Integer.parseInt(st.nextToken());
            int r3 = Integer.parseInt(st.nextToken());
            int c4 = Integer.parseInt(st.nextToken());
            int r4 = Integer.parseInt(st.nextToken());

            int width = (c2 - c1) * (r2 - r1);

            int left =  Math.max(c1,c3);
            int right = Math.min(c2,c4);
            int top = Math.min(r2,r4);
            int bottom = Math.max(r1,r3);

            if(left < right && bottom < top){
                width = width - ((right - left) * (top - bottom) );
            }
            sb.append(width).append("\n");
        }
    }

}
