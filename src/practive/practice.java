package practive;

/**
 * 작성자  : lbs
 * 날짜    : 2025-07-02
 * 풀이방법
 **/


public class practice {
    public static void main(String[] args) {

        //
        String space = " ";
        String star = "*";
        int size = 3;

        int i,j;
        for( i = 0 ; i <=size; i++){
            for(j = 0; j < size - i - 1; j++) {
                System.out.print(space);
            }

            for(j= 0; j < 2 * i + 1; j++) {
                System.out.print(star);
            }
            System.out.println();
        }

    }
}
