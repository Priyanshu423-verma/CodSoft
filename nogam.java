//Some library for using in the whole code block
import java.util.Random;
import java.util.Scanner;


//Guess class started here 
class Guess{
    //Some global variable use out of the guess method
    int user_no=0;
    int maxm=10;
    int tru=0;
    int life=5;
    int moves=1;
    //Guess method started here
    public void gues(int no,int tru){
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the right answer");
        System.out.println("Enter your no");
        //take the user guessed number as a Input
        user_no=sc.nextInt();
        //Condition block started here
        if(life!=0){
            if(user_no==no){
                System.out.println("Congrats!, You answer is right ");
                System.out.println("You guess the number");
                tru=1;
            }
            else{
                if(user_no>no){
                    moves++;
                    //Some hint if user not guess in our first attemp
                    System.out.println("Greater than guess number");
                    System.out.println("Remaining moves ="+(life--));
                    //User not guess the number so again coll the guess number
                    gues(no,tru); 
                    tru=1; 
                }
                else{
                    if(user_no<no){
                        moves++;
                        //Some hint if user not guess in our first attemp
                        System.out.println("Smaller than guess number");
                        System.out.println("Remaining moves ="+(life--));
                        //User not guess the number so again coll the guess number
                        gues(no,tru);
                        tru=1;
                    }
                    else{
                        System.out.println("You not guess the no");
                        tru=0;
                    }
                }
            }
        }
        //condition block for user he guessed the number or not 
        if(tru==1){
            if(moves==1){
                System.out.println("Excellent you guess the number in first attempt");
            }
            else{
                if(moves<=5){
                    System.out.println("You guess the number in" +moves+"move");
                }
            }
        }
        else{
            System.out.println("Fail, You not guess the no");
        }
        
    }
}

//Main Class Started here
public class nogam {
    //Main Function Started Below
    public static void main(String[] args) {
        int number = 0; 
        int tru=1;
        //Using Random class which is in-bulit in Java.util. package;
        Random ran = new Random();  //Random nuber generator object
        //Generating random no. at each run of main block with boundation of less or equal to 100 
        number= ran.nextInt(20);
        //System.out.println(number);
        //Creating object to call the guess the number by user
        Guess ges=new Guess();
        //Main function call the guess method for user guess the number
        ges.gues(number,tru);
    }
}