package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution8 {
    //right, bottom
    public static int N;
    public static int K;
    public static String[][] arr ;
    static class XY{
        int x ;
        int y;
        int cnt;

        public XY(int x,int y,int cnt){
            this.x=x;
            this.y=y;
            this.cnt =cnt;
        }

    }
    static int[][] d= {{0,1},{1,0}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t=1;t<=test;t++){
            int ans =0;
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            K = Integer.parseInt(str[1]);

            arr = new String[N][N];
            for (int i=0; i<N;i++){
                String[] st = br.readLine().split(" ");
                System.arraycopy(st,0,arr[i],0,N);
            }

            int i=0;
            while (i<N){
                int j=0;
                while (j<N){
                    if(arr[i][j].equals("1"))
                        ans += solution(i, j);

                    j++;
                }
                i++;
            }

            System.out.printf("#%d %d\n",t,ans);
        }
    }

    private static int solution(int i,int j) {
        int result=0;

        int rcnt =0,ccnt=0;


       for (int r = j; r < N; r++) {

           if(j>0&&arr[i][j-1].equals("1"))
               break;
           if (arr[i][r].equals("1")) {
               rcnt++;
           } else {
               break;
           }
       }

       for (int b = i; b < N; b++) {
           if(i>0&&arr[i-1][j].equals("1"))
               break;

           if (arr[b][j].equals("1")) {
               ccnt++;
           } else {
               break;

           }
       }

        if(rcnt==K)
            result++;
        if(ccnt==K)
            result++;

        return result;
    }
}
