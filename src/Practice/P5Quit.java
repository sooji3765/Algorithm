package Practice;

import java.util.Scanner;

public class P5Quit {
    public static int N,Max=Integer.MIN_VALUE ;
    static int[] T;
    static int[] P;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
           T[i] = scanner.nextInt();
           P[i]= scanner.nextInt();
        }


        dfs(0,0);
        System.out.println(Max);
    }

    public static void dfs(int day, int result){
        if (day>=N){
            Max = Math.max(Max,result);
            return;
        }
        if(day+T[day]<=N)
            dfs(day + T[day], result + P[day]);

        dfs(day+1,result);

        }

}
