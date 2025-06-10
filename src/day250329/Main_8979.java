package day250329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : lb
 * 날짜    : 2025-03-29
 * 풀이방법
 **/


public class Main_8979 {
    private static int N;
    private static int searchCountryInDex;
    private static Country[] countries;

    public static class Country implements Comparable<Country> {
        int countryNum ;
        int goldMedalCount;//금
        int silverMedalCount; // 은
        int bronzeMedalCount ; // 동

        public Country(int countryNum , int goldMedalCount, int silverMedalCount, int bronzeMedalCount) {
            this.countryNum = countryNum;
            this.goldMedalCount = goldMedalCount;
            this.silverMedalCount = silverMedalCount;
            this.bronzeMedalCount = bronzeMedalCount;
        }

        @Override
        public int compareTo(Country o){
            if(goldMedalCount == o.goldMedalCount){
                if (silverMedalCount == o.silverMedalCount){
                    if(bronzeMedalCount == o.bronzeMedalCount){

                    }
                    return Integer.compare(o.bronzeMedalCount, this.bronzeMedalCount);
                }
                else{
                    return Integer.compare(o.silverMedalCount, this.silverMedalCount);
                }
            }else {
                return  Integer.compare(o.goldMedalCount,this.goldMedalCount);
            }
        }


    }
    private static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        Arrays.sort(countries);
        int beforeCountLevel = 0;
        int beforeGoldMedalCount = 0;
        int beforeSilverMedalCount = 0;
        int beforeBronzeMedalCount = 0;


        for( int i = 1 ; i <=N ;i++){
            Country curCountry = countries[i];
            int curCountLevel = 0;
            if(curCountry.goldMedalCount== beforeGoldMedalCount
            && curCountry.silverMedalCount== beforeSilverMedalCount
                    && curCountry.bronzeMedalCount== beforeBronzeMedalCount
            ){
                curCountLevel = beforeCountLevel;
            }
            else {
                curCountLevel = i;
            }

            if(countries[i].countryNum == searchCountryInDex){
                sb.append(curCountLevel);
                return ;
            }
            beforeCountLevel = curCountLevel;
            beforeGoldMedalCount = curCountry.goldMedalCount;
            beforeSilverMedalCount =curCountry.silverMedalCount;
            beforeBronzeMedalCount = curCountry.bronzeMedalCount;

        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        searchCountryInDex = Integer.parseInt(st.nextToken());
        countries = new Country[N+1];
        countries[0] = new Country(0,1_000_001,0,0);

        for (int i = 1; i <=N; i++) {
            st= new StringTokenizer(br.readLine());
            int countryNum = Integer.parseInt(st.nextToken());
            int goldMedalCount = Integer.parseInt(st.nextToken());
            int silverMedalCount = Integer.parseInt(st.nextToken());
            int bronzeMedalCount = Integer.parseInt(st.nextToken());
            countries[i] = new Country(countryNum,goldMedalCount, silverMedalCount, bronzeMedalCount);
        }





    }

}
