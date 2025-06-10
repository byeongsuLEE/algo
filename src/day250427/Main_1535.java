package day250427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-27
 * 풀이방법
 **/


public class Main_1535 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] hp;
    private static int[] pleasure;
    private static int maxValue;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        sb.append(maxValue);
        System.out.println(sb.toString());
    }
    private static void solution() {
        combination(0,0,100,0);
    }

    private static void combination(int cnt, int start, int hpSum, int happy) {
        if(hpSum <= 0 ){
            return;
        }

        if(cnt==N){
            maxValue = Math.max(maxValue,happy);
            return;
        }

        maxValue = Math.max(maxValue,happy);

        for(int i = start ; i < N; i++){

            combination(cnt+1,i+1,hpSum-hp[i],happy+pleasure[i]);
        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N= Integer.parseInt(br.readLine());

        hp= new int [N];
        pleasure= new int [N];
        maxValue = -1 ;
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            hp[i]= Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            pleasure[i]= Integer.parseInt(st.nextToken());
        }
    }
}
