package day250119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10830 {
    private static int N;
    private static long B;
    private static int[][] matrix ;
    private static int[][] resultMatrix;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        init();
        solution();
    }

    private static void solution() {


        int[][] power = power(matrix, B);
        print(power);


        System.out.println( );
    }

    private static void print(int[][] power) {

        sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                sb.append(power[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int[][] power(int[][] mat, long b) {



        if( b==0){
            return identityMatrix();
        }

        if( b==1){
            return matrix;
        }

        int half[][] = power(mat,b/2);
        int result[][] = multifulMatrix(half,half);


        if(b %2 ==1){
            result = multifulMatrix(result, matrix);
        }

        return result;

    }

    private static int[][] identityMatrix() {

        int temp [][] = new int[N][N];

        for (int i = 0 ; i < N ; i++){
            temp[i][i] =1;
        }
        return temp;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B=  Long.parseLong(st.nextToken());

        matrix = new int[N][N];
        resultMatrix = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N ; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }

            resultMatrix[i] = matrix[i].clone();
        }


    }

    private static int [][]  multifulMatrix(int [][] a,int [][]b ) {
        int result[][] = new int[N][N];
        for(int i = 0 ; i< N ; i++){
            for(int j = 0 ; j < N ; j++){

                for(int k = 0 ; k < N ; k++){
                    result[i][j]+= (a[i][k]*b[k][j]) %1000;


                }
                result[i][j]%=1000;
            }

        }

      return result;
    }
}
