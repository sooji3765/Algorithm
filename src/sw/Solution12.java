package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution12 {
    static int T;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            double dir = 0;
            String str = br.readLine();
            int north =0;
            int west =0;
            int n=0;
            int i=str.length();

            if(str.substring(i-4,i).equals("west")){
                i-=4;
                dir=90;
                west++;
            }else{
                i-=5;
                dir =0;
                north++;
            }

            while (i!=0){

                if(north==west)
                    n=north;

                if(str.substring(i-4,i).equals("west")){
                    i-=4;
                    west++;
                    dir+=(90/2^n);

                }else{
                    i-=5;
                    north++;
                    dir-=(90/2^n);
                }
            }
            System.out.println("#"+t+" "+dir);
        }
    }
}
