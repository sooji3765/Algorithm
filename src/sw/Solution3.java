package sw;

import org.omg.PortableInterceptor.INACTIVE;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    public static class Student{
        int id;
        double score;
        String grade;

        public Student(int id, double score){
            this.id=id;
            this.score =score;
        }


        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", score=" + score +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }

    static String[] grade= {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(bufferedReader.readLine());

        for(int i=1;i<=test;i++){
            String ans ="";

            String str = bufferedReader.readLine();
            String[] arr = str.split(" ");
            int n = Integer.parseInt(arr[0]);
            int find = Integer.parseInt(arr[1]);
            ArrayList<Student> students = new ArrayList<>();

            for(int s=0; s < n;s++){
                String[] input = bufferedReader.readLine().split(" ");
                students.add(new Student(s+1,Integer.parseInt(input[0])*0.35+Integer.parseInt(input[1])*0.45+Integer.parseInt(input[2])*0.2));
            }

            students.sort((o1, o2) -> Double.compare(o2.score,o1.score));

            int cnt = n/10;
            for(int j=0; j<students.size();j++) {
                students.get(j).grade = grade[(j / cnt)];

            }

            for(Student s: students){
                System.out.println(s.toString());
            }

            for(Student s: students){
                if(s.id==find)
                    System.out.printf("#%d %s",i,s.grade);
            }


        }
    }
}
