import java.util.*;

public class perc{
    @SuppressWarnings("unused")
    public static void main(String [] args){
        float obtain=0;
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the student name\n");
        @SuppressWarnings("unused")
        String name=sc.nextLine();
        System.out.println("Enter the student rollno.");
        @SuppressWarnings("unused")
        long roo=sc.nextLong();
        System.out.println("Mention the no. of subject");
        int nsubj=sc.nextInt();
        System.out.println("Enter the total marks of paper");
        int toat=sc.nextInt();
        for(int i=1;i<=nsubj;i++){
            System.out.println("Mention the student obtained marks in subj=" +i);
            float sub=sc.nextInt();
            obtain=obtain+sub;
        }
        // System.out.println("Mention the student obtained marks in subj2");
        // float sub2=sc.nextInt();
        // System.out.println("Mention the student obtained marks in subj3");
        // float sub3=sc.nextInt();
        // System.out.println("Mention the student obtained marks in subj4");
        // float sub4=sc.nextInt();
        // System.out.println("Mention the student obtained marks in subj5");
        // float sub5=sc.nextInt();

        System.out.println(obtain);
        double perct=obtain/(nsubj);
        System.out.println(perct);
        double cgp=perct/9.5;
        System.out.println(cgp);
    }
}