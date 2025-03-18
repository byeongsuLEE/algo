package day250317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-17
 * 풀이방법
 **/


public class Main_15969 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        nums = new int [N];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        System.out.println(nums[N-1]-nums[0]);
    }
}
