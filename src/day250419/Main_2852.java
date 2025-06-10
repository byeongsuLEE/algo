package day250419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-19
 * 풀이방법
 * start - end 를 가지는?
 *
 **/


public class Main_2852 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static Team[] input;

    static class Team{
        int num;
        String time;

        public Team ( int num, String time){
            this.num = num;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        int count1 = 0;
        int count2 = 0 ;
        int sumA = 0;
        int sumB = 0;
        ArrayList<Team> teamA = new ArrayList<>();
        ArrayList<Team> teamB = new ArrayList<>();



        for (int i = 0 ; i < N ; i++){
            int teamNum = input[i].num;
            String time = input[i].time;
            int secondTime = getSecondTime(time);


            if(teamA.size() == teamB.size() ){
                if(teamNum == 1){
                    teamA.add(input[i]);
                }else {
                    teamB.add(input[i]);
                }
                continue;
            }

            if(teamNum == 1){
                teamA.add(input[i]);
            }else {
                teamB.add(input[i]);
            }

            // 처음값은 이긴 시간 계산 x

            int diffSecondTime = secondTime - getSecondTime(input[i - 1].time);
            //무승부 일때
            if(teamA.size() == teamB.size()){

                if(teamNum==1){
                    sumB+=diffSecondTime;
                }else{
                    sumA+=diffSecondTime;
                }

            }else if(teamA.size() > teamB.size()){
                sumA+=diffSecondTime;
            }else{
                sumB+=diffSecondTime;
            }



        }


        //마지막 값 처리
        int lastSecondTime =  48 * 60;
        int diffSecondTime = lastSecondTime - getSecondTime(input[N-1].time);
         if(teamA.size() > teamB.size()){
            sumA+= diffSecondTime;
        }else if (teamA.size() < teamB.size()){
            sumB+=diffSecondTime;
        }

        getTime(sumA);
        getTime(sumB);



    }


    public static void getTime(int sum ){

        int minuteA = sum / 60;
        int secondA = sum % 60;
        if(minuteA >= 0 && minuteA <=9){
            sb.append("0");
        }
        sb.append(minuteA);
        sb.append(":");
        if(secondA >= 0 && secondA <=9){
            sb.append("0");
        }
        sb.append(secondA);
        sb.append("\n");
    }
    public static int getSecondTime (String time){
        String minute = time.substring(0, 2);
        String second = time.substring(3);
        int secondTime = Integer.parseInt(minute) * 60 + Integer.parseInt(second);
        return secondTime;
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        input = new Team[N];
        for(int i = 0 ; i < N ; i++){
            st= new StringTokenizer(br.readLine());
           int num = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            input[i] = new Team(num, time);
        }
    }
}
