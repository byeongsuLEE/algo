package day1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16928 {
    static int N, M ;
    static StringTokenizer st =null;
    private static int [] goPoint;
    private static int answer=123456789;
    private static boolean[] visited;

    static class Location implements Comparable<Location>{
        int r ;
        int time ;

         public Location(int r, int time) {
             this.r = r;
             this.time = time;
         }

        @Override
        public int compareTo(Location o) {

                 if(this.time == o.time){
                     return Integer.compare(o.r, this.r);
                 }
                 return Integer.compare(this.time, o.time);
//            return Integer.compare(o.r, this.r);
        }

     }
    public static void main(String[] args) throws IOException {

        init();
        solution();

        System.out.print(answer);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 뱀의 수;

        goPoint = new int [101];

        for(int i = 0 ; i < N+M ; i++){
            st= new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            goPoint[start] = end;
        }

        visited = new boolean[101];

    }

    public static void solution() {
        /**
         * 1. location 객체를 만들자
         * 2. int r int c  ,
         * 3. bfs 를 돌려서 먼저 돌아 오는거랑
         * 4. bfs 안에 time 을 넣자..
         */

        PriorityQueue<Location> pq = new PriorityQueue<>();
        pq.offer(new Location(1,0));


        while(!pq.isEmpty()){
            Location curPq = pq.poll();
            int r = curPq.r;
            int time  = curPq.time;

            if(r==100){
               answer = time;
                return  ;
            }


            for(int i = 1 ; i <= 6 ; i ++){
                int nr = r + i;


                if(nr>100) {
                    continue;
                }

                if(visited[nr]) continue;
                while(goPoint[nr]>0){
                    int temp = nr;
                    nr = goPoint[nr];
                    goPoint[temp] = 0;
                }

                //여기서 이전에 들어간게 있다면 ? 체크를해봅시다.
               visited[nr] = true;
                pq.offer(new Location(nr,time+1));
            }
        }







    }
}

