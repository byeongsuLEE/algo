package day250302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-02
 * 풀이방법
 * 1. i,j 두포인터 사용
 * 2. 조건에 부합 할때 까지 j 증가
 * 3. j는 고정시키고 num[i] 를 뺴면서 최소길이를 찾는다.
 * 4. 맨 왼쪽 값인 num[i++]를 빼서 다음 단계로 넘어간다.
*/


public class Main_1806 {
    private static StringBuilder sb = new StringBuilder();
    private static double targetNum;
    private static int N;
    private static int[] num;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }
    private static void solution() {

        int i = 0;
        int j = 0;
        int minLength = 100_001;
        double sum = 0;
        while(i < N && j < N){
            while(j<N && sum < targetNum){
                sum += num[j++];
            }

            while(i < j-1 && sum-num[i] >= targetNum){
                sum-=num[i++];
            }

            if(sum >= targetNum){
                int partSumLength = j-i;
                minLength= Math.min(minLength,partSumLength);
                sum -= num[i++];
            }



        }

        sb.append(minLength == 100_001 ? 0 : minLength);
        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        targetNum = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
}
