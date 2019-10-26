package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution6 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t=1;t<=test;t++){
            int ans = 0;
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            int[] a= new int[N];
            int[] b= new int[M];

            String[] arr = br.readLine().split(" ");

            for(int i=0;i<N;i++){
                a[i]=Integer.parseInt(arr[i]);
            }

            String[] arr2 = br.readLine().split(" ");

            for(int i=0;i<M;i++){
                b[i]=Integer.parseInt(arr2[i]);
            }

            if(N>=M)
                ans =solution(a,b);
            else
                ans =solution(b,a);


            System.out.printf("#%d %d\n",t,ans);
        }
    }
    public static int solution(int[] a, int[] b){
        long total = -10000;

        int len = a.length-b.length;

        for(int i=0;i<=len;i++){
            int re=0;
            for(int j=0;j<b.length;j++){
                re+=b[j]*a[i+j];
            }

            total = Math.max(total,re);
        }

        return (int)total;
    }
}
