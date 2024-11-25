package day1114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자   : 이병수
 * 작성날짜 : 2024-11-14
 * 설명    :
 */
public class Main_11403 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        int graph [][] = new int[n+1][n+1];
        for(int i =  1 ; i <=n  ; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }




        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= n ; k++){
                    if(graph[j][i] ==1  && graph[i][k] ==1) {
                        graph[j][k] =1 ;
                    }

                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                System.out.print( graph[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
