package day250422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-22
 * 풀이방법
 * n= 8  순열 완탐 8!
 **/


public class Main_10819 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] num;
    private static int maxSum = -1;
    private static boolean[] visited;
    private static int[] selected;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        sb.append(maxSum);
        System.out.println(sb.toString());
    }
    private static void solution() {
        permutation(0,0);
    }

    private static void permutation(int cnt, int sum) {
        if(cnt ==N ){

            maxSum = Math.max(sum,maxSum);
            return;
        }


        for(int i  = 0  ; i < N ; i++){
            if(visited[i])  continue;
            visited[i] = true;
            selected[cnt] = num[i];
            if(cnt ==0 ){
             permutation(cnt+1,0);
            }else{
                permutation(cnt+1,sum + Math.abs(selected[cnt]-selected[cnt-1]));
            }
            visited[i] = false;

        }
        return;
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ;  i< N ; i++ ) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        visited=new boolean[N];
        selected = new int[N];
    }

}
