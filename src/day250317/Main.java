package day250317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-17
 * 풀이방법
 **/


public class Main {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static long[] A;
    private static long[] B;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        long sum=0;
        for(int i = 1 ; i <=N ; i++){
           A[i]=i* B[i]-sum;
           sum += A[i];
           sb.append(A[i]).append(" ");

        }
        System.out.println(sb.toString());

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        A = new long[N+1];
        B = new long[N+1];
        st= new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=N ; i++){
            B[i] = Long.parseLong(st.nextToken());
        }
    }
}
