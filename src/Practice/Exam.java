package Practice;

import java.util.Scanner;

public class Exam {
    static int N, B,C;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = System.currentTimeMillis();

        N = sc.nextInt();
        arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        B = sc.nextInt();
        C = sc.nextInt();

        int sum =0;
        for (int n: arr) {
            sum+=1;
            n-=B;

            if (n>0) {
                int x = n / C;
                int y = (n % C) == 0 ? 0 : 1;
                sum += (x + y);
            }

        }

        System.out.println(sum);
        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );


    }
}
