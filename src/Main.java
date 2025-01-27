import java.io.*;
import java.util.*;

public class Main {
    private static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        d = new int[N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            d[i] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(d);

            for(int i = 0 ; i<N/2;i++){
                int temp = d[i];
                d[i] = d[N-i-1];
                d[N-i-1] = temp;
            }



            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));






       boolean flag = false;
        for(int i=2 ; i<=K;i++){

            for (int j = 0; j < N; j++){

                    if(N>1 &&j==0) {
                        if(d[j]/i > d[N-1]  && d[j]/i==0 ){
                            break;
                        }
                    }
                int curVlaue = d[j]/i;
                int cnt =0;
                    for(int k = 0 ;k<N;k++){
                        cnt+=d[k]/curVlaue;
                    }

                if(cnt==K){
                    System.out.println(curVlaue);
                    flag=true;

                    break;
                }
            }
            if(flag)break;
        }


        System.out.println();
    }
}
