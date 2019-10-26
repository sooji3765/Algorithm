package Practice;

import java.util.*;

public class Array2 {
    static int[][] arr= new int[101][101];
    static int R,C,K;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // INPUT

        R = sc.nextInt()-1;
        C = sc.nextInt()-1;
        K = sc.nextInt();

        for (int i = 0; i < 4;i++) {
            for (int j = 0; j < 4 ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int time = 0;

        int rlen = 3;
        int clen = 3;

        while (arr[R][C]!=K&&arr[R][C]<100){

            // R 연산
            if (rlen>=clen){
                for (int i = 0; i < rlen ; i++) {
                    HashMap<Integer,Integer> map = new HashMap<>();
                    for (int j =0;j<clen;j++){
                        if (arr[i][j]!=0)
                            map.put(arr[i][j],map.getOrDefault(arr[i][j],0)+1);
                    }

                    for(Integer key : map.keySet()){
                        System.out.println("KEY:"+key+" Count:"+map.get(key));
                    }

                    List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());

                    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                            return o1.getValue()-o2.getValue();
                        }
                    });

                    LinkedList<Integer> aa = new LinkedList<>();
                    for (int j = 0; j < list.size(); j++) {
                        aa.add(list.get(j).getKey());
                        aa.add(list.get(j).getValue());
                        System.out.println(list.get(j).getKey()+" : "+list.get(j).getValue());
                    }

                    for (int j = 0; j <aa.size() ; j++) {
                        arr[i][j] = aa.get(j);
                    }
                }

            }
            else{ //C 연산
                int j=0;
                while (j<clen){
                    HashMap<Integer,Integer> map = new HashMap<>();
                    for (int i = 0; i <rlen ; i++) {
                        if (arr[i][j]!=0)
                            map.put(arr[i][j],map.getOrDefault(arr[i][j],0)+1);
                    }

                    List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());

                    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                            return o1.getValue()-o2.getValue();
                        }
                    });

                    LinkedList<Integer> aa = new LinkedList<>();
                    for (int k = 0; k < list.size(); k++) {
                        aa.add(list.get(k).getKey());
                        aa.add(list.get(k).getValue());
                        System.out.println(list.get(k).getKey()+" : "+list.get(k).getValue());
                    }

                    for (int k = 0; k <aa.size() ; k++) {
                        arr[k][j] = aa.get(j);
                    }

                    j++;
                }

            }
            time++;
        }

        System.out.println(time<=100?time:-1);

    }
}
