package day250330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : lb
 * 날짜    : 2025-03-30
 * 풀이방법 : 투 포인트
 * 숫자를 정렬 하자
 * left = 0 , right = end
 * 두 수의 합이 m보다 작은 수면 left을 올려서 숫자를 키우자
 * 두 수의 합이 m보다 크면 수면 right를 내리자
 *
 **/


public class Main_1940 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] nums;
    private static int M;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        Arrays.sort(nums);
        int left  = 0 , right = N-1;
        int makeArmorCount = 0 ;
        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum < M ){
                left++;
            }else if(sum >M ){
                right--;
            }else if (sum == M){
                makeArmorCount++;
                left++;
                right--;
            }
        }
        sb.append(makeArmorCount);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
