package sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 1285. 아름이의 돌 던지기
 */
public class Solution9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for(int t=1;t<=test;t++){
            int ans = 0;
            long min = 100000;
            int n = Integer.parseInt(br.readLine());

            HashMap<Long,Integer> hashMap = new HashMap<>();
            String[] distance = br.readLine().split(" ");

            for(String d : distance){
                long dis = Math.abs(Long.parseLong(d));
                hashMap.put(dis,hashMap.getOrDefault(dis,0)+1);
            }

            for(long key : hashMap.keySet()){
                if(key<=min){
                    ans=hashMap.get(key);
                    min= key;
                }
            }

            System.out.printf("#%d %d %d\n",t,min,ans);
        }
    }
}
