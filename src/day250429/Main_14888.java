package day250429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-29
 * 풀이방법
 * 순열 완탐
 * 10! 360만 x 연산횟수 11 = 360 x11  = 4천만정도
 **/


public class Main_14888 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] num;
    private static int[] operate;
    private static int maxValue = Integer.MIN_VALUE;
    private static int minValue = Integer.MAX_VALUE;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        sb.append(maxValue).append("\n");
        sb.append(minValue).append("\n");
        System.out.println(sb.toString());
    }
    private static void solution() {
        visited= new boolean[N-1];
        permutation(0,num[0]);
    }

    private static void permutation(int cnt,int result) {
        if(cnt ==N-1){

            maxValue = Math.max(maxValue,result);
            minValue = Math.min(minValue,result);
            return;
        }

        for(int i = 0 ; i < N -1 ; i++){
            if(visited[i]) continue;
            visited[i] = true;
            //계산
            int operateReuslt = oper(result,operate[i], num[cnt+1]);
            permutation(cnt+1,operateReuslt);
            visited[i]= false;
        }
    }

    private static int oper(int beforeResult, int operateNum, int nextNum) {
       int result = 0;
        if(operateNum == 0){
            result = beforeResult + nextNum;
        }else if(operateNum == 1){
            result = beforeResult - nextNum;
        }else if ( operateNum ==2){
            result = beforeResult * nextNum;
        }else{
            result = beforeResult /  nextNum;
        }
        return result;
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            num[i] =  Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        operate = new int[N-1];
        int index = 0;
        for(int i = 0 ; i < 4; i++){
            int count = Integer.parseInt(st.nextToken());
            while(count-- > 0 ){
                operate[index++] = i;
            }
        }

    }

}
