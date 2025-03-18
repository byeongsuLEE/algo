package day250312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 서로소 쌍
 * 작성자  : 이병수
 * 날짜    : 2025-03-12
 * 풀이방법
 **/


public class Main_13412 {
    private static StringBuilder sb= new StringBuilder();
    private static int T;
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb.toString());
    }

    private static void solution() {
        long count =0;
        for(long i=1 ;  i*i<=N ; i++){
            if(N%i!=0) continue;
            long gcdNum = gcd(i,N/i);

            if(gcdNum==1 && (gcdNum * i * N/i) ==N ){
                count++;
            }
        }
        sb.append(count).append("\n");
    }

    private static long gcd(long a, long b) {
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T; t++){
            N = Integer.parseInt(br.readLine());
            solution();

        }

    }
}
