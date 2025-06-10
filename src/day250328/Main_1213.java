package day250328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 작성자  : lb
 * 날짜    : 2025-03-28
 * 풀이방법
 **/


public class Main_1213 {
    private static StringBuilder sb= new StringBuilder();
    private static String str;
    private static char[] charArray;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        //팰린드롬 1 N 2 N-1 이 같은것
        int [] alphabet = new int[26];

        Map<Character, Integer> alphabetCountMap = new TreeMap<>();

        for(char ch : charArray) {
            alphabetCountMap.put(ch, alphabetCountMap.getOrDefault(ch,0)+1);
        }
        StringBuilder frontSb  =new StringBuilder();
        StringBuilder backSb =new StringBuilder();
        char remainChar = '0';
        for(Character ch  :  new ArrayList<> (alphabetCountMap.keySet())){
            int chCount = alphabetCountMap.get(ch);
            while(chCount>1){
                frontSb.append(ch);
                backSb.append(ch);
                chCount-=2;
            }
            if(chCount==1){
                 remainChar = ch;
            }else if(chCount==0){
                alphabetCountMap.remove(ch);
            }
        }

        if(alphabetCountMap.size()>1){
            sb.append("I'm Sorry Hansoo");
            return ;
        }

        if(remainChar !='0') frontSb.append(remainChar);
        backSb.reverse();
        sb.append(frontSb).append(backSb);


//        int processedCount = 0;
//
//        for(int i = 0 ; i< 26 ; i++){
//            while(true){
//                if(alphabet[i]>=2){
//                    alphabet[i]-=2;
//                    processedCount+=2;
//                    frontSb.append((char)('A' + (char)i));
//                    backSb.append((char)('A'+ i));
//                }else{
//                    break;
//                }
//            }
//        }
//        int remainCharCount = charArray.length-processedCount;
//        if(remainCharCount >1){
//            sb.append("I'm Sorry Hansoo");
//            return ;
//        }
//
//        for(int i = 0 ; i< 26 ; i++){
//            if(alphabet[i]==1){
//                frontSb.append((char)('A' + i));
//            }
//        }
//
//        backSb.reverse();
//        sb.append(frontSb.toString()).append(backSb.toString());

        // 26 전체를 검색하는 대신 input만 된 것들 중에서만 검색하는 방법을 쓰고싶다.




    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        str= br.readLine();
        charArray = str.toCharArray();
    }

}
