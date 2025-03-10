package day250217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-02-17
 * 풀이방법
 * 에라토스테네스의  채
 *
 **/


public class Main_1644 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static boolean[] numbers;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        //에라토스테네스의 채
        for(int i =2 ;  i*i <=N ; i++){
            if (!numbers[i]) {
                for (int j = i * i; j <= N; j += i) {
                    numbers[j] = true;
                }
            }
        }

        List<Integer> number = new ArrayList<>();
        for(int i = 2 ; i <=N;i++){
            if(!numbers[i]){
                number.add(i);
            }

        }
        //Boolean[] array = Arrays.stream(numbers).filter(a -> a).toArray(Boolean[]::new);
        int answer =0;
        int start = 0;
        int end = 0;
        int sum = 0 ;

        //연속된 수의 합
        while(end < number.size()){
            sum +=number.get(end);
            while (sum > N && start <= end) {
                sum -= number.get(start);
                start++;
            }
            // 부분합이 target과 같으면 카운트 증가
            if (sum == N) {
                answer++;
            }
            end++; // 다음 원소로 이동

        }

        System.out.println(answer);

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        numbers = new boolean[N + 1];


    }
}
