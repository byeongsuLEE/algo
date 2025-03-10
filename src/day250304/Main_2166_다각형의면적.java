package day250304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-04
 * 풀이방법
 * 0번을 기준으로 다각형 삼각형으로 나눠 면적을 구한다.
 * 헤론의 공식 s =  |(c1-c0)(r2-r0)-(c2-c0)(r1-r0)|/2
 * width * 10 곱해서 첫쨰자리수를 정수로 만든다음 둘쨰 소수점을 반올림
 **/


public class Main_2166_다각형의면적 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static double[][] diffNums;


    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        // 외적공식 s =  |(c1-c0)(r2-r0)-(c2-c0)(r1-r0)|/2

        double width = 0;
        for(int i = 2; i <N ; i++){
            double rectangleWidth = (diffNums[i-1][1]* diffNums[i][0] - diffNums[i][1] * diffNums[i-1][0]) /2.0;
            width+=rectangleWidth;
        }
        System.out.printf("%.1f\n", Math.abs(width));
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        diffNums =new double[N][2];

        int sr = 0;
        int sc = 0;
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(i ==0 ) {
                sr= r;
                sc = c;
                continue;
            }
            diffNums[i][0] = (r-sr);
            diffNums[i][1] = (c-sc);
        }
    }

}
