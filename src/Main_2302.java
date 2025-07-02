import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-10
 * 풀이방법
 **/


public class Main_2302 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int M;
    private static int[][] dp;
    private static boolean[] isFixNum;

    public static void main(String[] args) throws IOException {
        init();
//        solution();
        solution2();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        dp[1][0]= 0;
        dp[1][1]=1;
        dp[2][0]=1;
        dp[2][1]=1;

        //  자리수를 기준으로 개수를 파악하면안되나?
        //dp[i][0] = i번째 자리수에 i-1 값이 오는 경우의수
        //dp[i][1] = i번쨰 자리수에 i 값이 오는 경우의 수
        for(int i = 3; i <=N; i++){
            if(isFixNum[i]){
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                dp[i][1] = 0;
            }else{
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                if(isFixNum[i-1]) continue;
                dp[i][1] = dp[i-2][0] + dp[i-2][1];
            }
        }


        //1    1
        //2    12 ,21
        //3    123 ,  213    132
        //4    1234 ,2134, 1324
        //5    12345  21345  13245
        sb.append(dp[N][0]+dp[N][1]);
    }

    public static void solution2() {
        int dp2[] = new int [N+1];
        dp2[1]=1;
        dp2[2]= isFixNum[2] | isFixNum[1] ? 1: 2;

        for(int i = 3; i <=N; i++){
            if(isFixNum[i]){
                dp2[i] = dp2[i-1];
            }
            else if(isFixNum[i-1]){
                dp2[i] = dp2[i-1];
            }
            else {
                dp2[i]= dp2[i-1]+ dp2[i-2];
            }
        }
        sb.append(dp2[N]);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        M= Integer.parseInt(br.readLine());
        dp = new int[N+1][2];

        isFixNum = new boolean[N+1];


        for(int i = 0 ; i < M ; i++){
            int num = Integer.parseInt(br.readLine());
            isFixNum[num] = true;
        }


    }
}
