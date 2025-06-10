package day250411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-11
 * 풀이방법
 * 1. 풀이 1(시간초과)
 * 순열 사용
 * 내림차순 판단 : int[] -> Integer[] 변환 후 내림차순 정렬 + equals
 *
 * 2. 풀이 2
 * nextpermutation
 * 1. A[i-1] < A[i] 만족하고 가장 큰 i를 찾는다.
 * 2. A[j] > A[i-1] 인 j를 찾는다.
 * 3. A[J] 와 A[I]를 바꾼다.
 * 4. A[I] 부터 순열을 뒤집는다.
 **/


public class Main_10972 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static Integer[] number;
    private static boolean[] visited;
    private static Integer[] selected;
    private static Integer[] descNumber;
    private static int count;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        int i = N-1 ;
        int j = 0;

        while(i >0  &&  number[i-1] >= number[i]  ){
            i--;
        }
        if (i <= 0) {
            sb.append(-1);
            return;
        }
        j=N-1;
        while( number[j] <= number[i-1]){
            j--;
        }
        int temp = number[i-1];
        number[i-1] = number[j];
        number[j] = temp;
        int left = i;
        int right =N-1;
        while(left<right){
            temp = number[left];
            number[left] = number[right];
            number[right] = temp;
            left++;
            right--;
        }

        for(int num : number){
            sb.append(num).append(" ");
        }



    }



    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        number = new Integer [N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }


    }
}
