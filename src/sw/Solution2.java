package sw;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        for(int i =1;i<=N;i++){
            String num = String.valueOf(i);
            boolean cont = false;
            String check= "";
            for(char ch : num.toCharArray()){
               if(ch=='3'||ch=='6'||ch=='9'){
                   check+="-";
                   cont=true;
               }
            }
            if (cont){
                System.out.print(check);
            }else{
                System.out.print(num);
            }
            System.out.print(" ");
        }
    }
}
