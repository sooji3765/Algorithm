package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solutions {
    static int[] dx ;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test =Integer.parseInt(br.readLine());

        for (int t=1;t<=test;t++){
            int k=1;
            int N = Integer.parseInt(br.readLine());


            dx = new int[10];
            while(true){
                long num = N*k;
                seperate(num);

                if (count()) {
                    System.out.printf("#%d %d\n",t,(int)num);
                    break;
                }

                k++;
            }


        }
    }
    private static boolean count(){
        for(int d : dx){
            if(d==0)
                return false;
        }
        return true;
    }
    private static void seperate(long num){
        String s = num+"";

        for(char c: s.toCharArray()){
            int i = c-'0';
            dx[i]++;
        }
    }


}
