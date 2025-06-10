package day250418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 25. 4. 18.
 * 풀이방법
 * 1. 계수정렬 값이 1억이상이니 안됨 X
 * 2. map을 이용하여 값을 카운트하는 map이용
 * 들어온 순서를 보장하기 위해서 map-> LinkedMap 사용
 * MAP을 정렬하는 방법은 없다.
 * 따라서, list를 이용한다.
 *
 **/

public class Main_2910 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int C;
    private static ArrayList<String> list;
    private static Map<String,Integer>map;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        list.sort((a,b)-> {
            return map.get(b).compareTo(map.get(a));
        });

        for(String num : list){
            int count = map.get(num);
            while(count-- > 0){
                sb.append(num).append(" ");
            }
        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new LinkedHashMap<>();
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            String number = st.nextToken();
            map.put(number,map.getOrDefault(number,0)+1);
        }
        list = new ArrayList<>(map.keySet());


    }
}
