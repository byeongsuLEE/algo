package day250318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-18
 * 풀이방법
 **/


public class Main_2816 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int kb1Index,kb2Index;
    private static int[] num;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        int curIndex = 0 ;
        while(true){
            if(kb1Index ==0 && kb2Index==1) break;

            //K1 를 먼저 위로 보낸다.
            while ( curIndex != kb1Index){
                curIndex++;
                sb.append(1);
            }

            while(kb1Index != 0){
                int temp = num[curIndex];
                num[curIndex] = num[curIndex-1];
                num[curIndex-1]= temp;
                if(num[curIndex] ==2){
                    kb2Index++;
                }
                curIndex--;
                kb1Index--;
                sb.append(4);
            }
            //k2 를 위로보내보자.
            while(curIndex!=kb2Index){
                curIndex++;
                sb.append(1);
            }

            while(kb2Index != 1){
                int temp = num[curIndex];
                num[curIndex] = num[curIndex-1];
                num[curIndex-1]= temp;

                curIndex--;
                kb2Index--;
                sb.append(4);
            }
            //K2 = 위로보낸다.


//            if(kb1Index<kb2Index){
//                while(curIndex!=kb1Index){
//                    curIndex++;
//                    sb.append(1);
//                }
//
//
//
//                while ( kb2Index!= kb1Index+1){
//                    kb2Index--;
//                    curIndex--;
//                    sb.append(4);
//                }
//            }else{
//
//            }
        }
        System.out.println(sb.toString());
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        kb1Index = 0;
        kb2Index = 0;
        num = new int [N];
        for (int i = 0 ; i < N; i++){
            String str = br.readLine();
            num[i]=0;
            if(str.equals("KBS1")){
                kb1Index=i;
                num[i]=1;
            }else if(str.equals("KBS2")){
                kb2Index=i;
                num[i]=2;
            }
        }
    }
}
