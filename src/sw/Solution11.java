package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());


        for(int t=1;t<=test;t++){
            int distance = 0;
            int total =0;
            int N = Integer.parseInt(br.readLine());

            for(int i=0;i<N;i++){
                StringTokenizer str = new StringTokenizer(br.readLine());

                while (str.hasMoreTokens()){
                    String speed = str.nextToken();

                    switch (speed){
                        case "1" :
                            int incre = Integer.parseInt(str.nextToken());
                            distance+=incre;
                            break;
                        case "2" :
                            int decre = Integer.parseInt(str.nextToken());
                            if(decre > distance)
                                distance=0;
                            else
                                distance-=decre;
                            break;
                        default :
                            break;
                    }

                    total+=distance;
                }
            }
            System.out.printf("#%d %d",t,total);

        }

    }
}
