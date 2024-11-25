package day1023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 작성자   : user
 * 작성날짜 : 2024-10-23
 * 설명    :
 */
public class Main_30804 {
    private static int N;
    private static int answer;
    private static Map<Integer, Integer> fruitsKind;
    private static int[] fruits;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        // 투포인터 0,0 에서 n 만큼 반복
        int left=1;
        int right= 1;
        fruitsKind.put(fruits[left],1);

        while(left<=right){
            if(isOverTwoKindFruit()){
                fruitsKind.put(fruits[left],fruitsKind.get(fruits[left])-1);
                left++;
            }else{
                right++;
                if(right>N) break;
                fruitsKind.put(fruits[right],fruitsKind.get(fruits[right])+1);
            }


        }

        System.out.println(answer);
    }

    private static boolean isOverTwoKindFruit() {
        int fruitKindCount= 0 ;
        int totalCount = 0 ;
        for(int i = 1 ; i<=9;i++){
            if(fruitsKind.get(i) > 0) {
                fruitKindCount++;
                totalCount += fruitsKind.get(i);
            }
            if(fruitKindCount>=3)return true;
        }
        answer= Math.max(answer, totalCount);
        return false;

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0 ;

        fruitsKind = new HashMap<>();
        for(int i = 1 ; i <= 9 ; i++){
            fruitsKind.put(i, 0);
        }
        fruits = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <=N ; i++) {
            int kindNum = Integer.parseInt(st.nextToken());
            fruits[i] =kindNum;
        }

    }
}
