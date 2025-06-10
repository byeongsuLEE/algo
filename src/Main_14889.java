import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-15
 * 풀이방법
 * 조합을 이용해보자  n =20 이고  20C10     20! / 10! 10! 되나??
 * 1. 절반을 뽑자.
 * 2. 뽑은 것들을 N/2개에서 2개씩 조합 시키자 (포문)
 **/


public class Main_14889 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[][] map;
    private static boolean[] visited;
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        combination(0,0);
        sb.append(minValue);
    }

    private static void combination(int cnt, int start) {
        if(cnt == N/2){
            // 1. 절반을 뽑자.
            // 2. 뽑은 것들을 N/2개에서 2개씩 조합 시키자 (포문)
            int sumA =0;
            int sumB =0;
            for(int i = 0 ; i< N; i++){
                for(int j = i+1 ; j< N; j++){
                    if(visited[i]  && visited[j]){
                        sumA += map[i][j] + map[j][i];
                    }
                    else if(!visited[i] && !visited[j]){
                        sumB += map[i][j] + map[j][i];
                    }
                }
            }

            minValue  = Integer.min( minValue, Math.abs(sumA-sumB));
            return;
        }

        for (int i = start ; i < N ; i++){

            if(visited[i]) continue;
            visited[i] = true;
            combination(cnt+1, i);
            visited[i] = false;
        }

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N =Integer.parseInt(br.readLine());
        map =new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean [N];
    }
}
