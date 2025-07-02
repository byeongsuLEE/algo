package day250617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-17
 * 풀이방법
 **/


public class Main_2578 {


    private static boolean[][] visited;
    private static int bingoCount;

    static public class Location {
        int r;
        int c;
        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static Map<Integer, Location> numLocMap;
    private static StringBuilder sb= new StringBuilder();
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution(int num) {
        // 해당 숫자의 가로, 세로 , 대각선 3가지 경우에 대한 빙고 수 증가시키기
        // 숫자로 행과 열의 위치를 바로 찾을 수 있는 방법은?
        // map <num , loc> 으로 지정해보자
        Location curLoc = numLocMap.get(num);
        int r = curLoc.r;
        int c = curLoc.c;
        visited[r][c] = true;

        // isWidthBingo
        boolean isWidthBingo = true;
        boolean isHeightBingo = true;
        for(int i = 1; i <=5; i++){
            // 가로
            if(!visited[r][i]){
                isWidthBingo = false;
            }
            //세로
            if(!visited[i][c]){
               isHeightBingo = false;
            }

            //가로 세로 모두 false라면
            if(!isWidthBingo && !isHeightBingo) break;
        }
        if(isWidthBingo){
            bingoCount++;
        }
        if(isHeightBingo){
            bingoCount++;
        }

        // 주대각선 체크 (r == c인 경우만)
        if(r == c){
            boolean isCrossBingoDown = true;
            for(int i = 1; i <= 5; i++){
                if(!visited[i][i]){
                    isCrossBingoDown = false;
                    break;
                }
            }
            if (isCrossBingoDown){
                bingoCount++;
            }
        }

        // 반대각선 체크 (r + c == 6인 경우만)
        if(r + c == 6){
            boolean isCrossBingoUp = true;
            for(int i = 1; i <= 5; i++){
                if(!visited[i][6-i]){
                    isCrossBingoUp = false;
                    break;
                }
            }
            if (isCrossBingoUp){
                bingoCount++;
            }
        }



    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        numLocMap = new HashMap<>();
        map =new int [6][6];
        visited = new boolean [6][6];
        bingoCount=0;

        for(int i =1 ; i <= 5; i++){
            st= new StringTokenizer(br.readLine());
            for(int j =1 ; j <= 5 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                numLocMap.put(map[i][j], new Location(i, j));

            }
        }

        for (int i = 1; i <=5 ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =1 ; j <= 5 ; j++){
                int num = Integer.parseInt(st.nextToken());

                solution(num);
                if(bingoCount >=3){
                    sb.append((i-1)*5+ j);
                    return;
                }

            }
        }

    }
}
