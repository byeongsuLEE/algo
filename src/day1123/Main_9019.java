package day1123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 작성자   : 이병수
 * 작성날짜 : 2024-11-23
 * 설명    :
 */
public class Main_9019 {
    public static StringBuilder sb ;
    public static StringTokenizer st = null;
    public static boolean [] visited ;
    private static Queue<Register> q;

    static class Register{

        int number ;
        String command ;


        public Register(int number, String command) {
            this.number = number;
            this.command = command;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        sb =new StringBuilder();
        for(int i = 0; i < T; i++) {
            st= new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            visited= new boolean[10000];
            solution(A,B);

        }
        System.out.print(sb.toString());


    }

    private static void solution(int a, int b) {
         q  = new LinkedList<Register>();
        q.add(new Register(a,""));
        visited[a] =true;
        while(!q.isEmpty()) {
            Register curQ = q.poll();

            int curNumber = curQ.number;
            String curCommand = curQ.command;
            if(curNumber == b){
                sb.append(curCommand).append("\n");
                return;
            }



           command('D', curNumber,curCommand);
            command('S', curNumber,curCommand);
            command('L', curNumber,curCommand);
            command('R', curNumber,curCommand);


        }

    }


    public static int command (char c, int number, String curCommand){
        switch (c){
            case 'D':
                number = ( number * 2 ) %10000;

                break;
            case 'S':
                number = (number == 0) ? 9999 : number - 1;
                break;
            case 'L':
                number = (number % 1000) * 10 + (number / 1000);
                break;
                case 'R':
                    number =  (number / 10) + (number % 10) * 1000;
                    break;
        }

        if(!visited[number]) {
            visited[number] = true;
            q.offer(new Register(number,curCommand+c));
        }
        return number;
    }

}
