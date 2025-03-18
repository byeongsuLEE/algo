package day250318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-18
 * 풀이방법
 * dfs + 조합 (중복이 없기때문에 visited 변수 사용 x )
 * 조건 찾을 즉시 종료 true 반환
 *
 **/


public class Main_2309 {
    private static StringBuilder sb= new StringBuilder();
    private static int[] selected;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        dfs(0,0,0);
    }

    private static boolean dfs(int cnt, int sum, int beforeNumIndex) {
        if(cnt == 7 ){
            if(sum == 100){
                Arrays.sort(selected);
                for(int num : selected){
                    System.out.println(num);
                }
                return true ;
            }
            return false;

        }

        for(int i = beforeNumIndex ; i<9 ; i++ ){
            selected[cnt] = nums[i];
            if(dfs(cnt+1, sum+nums[i] , i+1)){
                return true;
            }
        }
        return false;
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = new int[9];
        for(int i = 0 ; i < 9 ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        selected =new int [7];
    }
}
