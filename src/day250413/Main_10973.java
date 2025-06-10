package day250413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-13
 * 풀이방법
 **/


public class Main_10973 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        //A[I] < A[I-1]

        int i= N-1;
        while(i>0 && A[i-1] <= A[i]) {
            i--;
        }
        if (i == 0) {
            sb.append(-1);
            return;
        }


        //54123  -> 53124
        //53421
        //현재보다 작은 수 중 가장 큰 수를 찾아야 하기 때문에
        //A[j] < A[i - 1] 이 되도록, A[j] >= A[i - 1]인 동안 계속 줄여야 해.
        int j = N -1;
        while(A[j] >= A[i-1] ){
            j--;
        }

        int temp = A[j];
        A[j] = A[i-1];
        A[i-1] = temp;

        int left = i;
        int right = N-1;
        while(left < right){
            int temp2 = A[left];
            A[left] = A[right];
            A[right] = temp2;
            left++;
            right--;
        }

        for(int num : A){
            sb.append(num).append(" ");
        }

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N =Integer.parseInt(br.readLine());
        A = new int[N];
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

    }
}
