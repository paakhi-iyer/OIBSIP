package NumberGuessingGame;
import java.util.Random;
import java.util.Scanner;
public class NumberGuessing {
        static int randomno;
        static void guessno(int cnum) {
            System.out.println("You have 5 chances");
            System.out.println("Random number is: "+cnum);
            Scanner sc = new Scanner(System.in);
            int i = 0;
            int score = 5;
            while (i < 5) {
                System.out.print("\nGuess a number:  ");
                int unum = sc.nextInt();

                if (0 > unum || unum > 100) {
                    System.out.println("Please input number between 1 to 100.\n");
                    score = score+1;
                    i--;
                }

                else if (unum != cnum) {

                    System.out.println("You Lost a Point\n");
//                System.out.println("Remaining points to score is:- " + score);
                    if (cnum>unum){
                        if(cnum-unum>15){
                            System.out.println("Enter number is less than 15, Try for bigger number");
                        }
                        else if(cnum - unum > 7 && cnum - unum < 15){
                            System.out.println("Entered number difference is between 7 and 15, try for a bigger one");
                        }
                        else {
                            System.out.println("You are closer, try for bigger number");
                        }
                    }
                    else{
                        if(unum-cnum>15){
                            System.out.println("You enter a bigger number than 15 , Try for smaller number");
                        }
                        else if(unum - cnum > 7 && unum - cnum < 15){
                            System.out.println("Entered number difference is between 7 and 15, Try for smaller number");
                        }
                        else{
                            System.out.println("You are closer, try for smaller number");
                        }
                    }
                } else {
//                System.out.println("Your Score is: " + score);
                    break;
                }
                score = score - 1;
                i++;


            }
            if (score == 0) {
                System.out.println("You Lost the Game");
            }else{
                System.out.println("Your Score is: " + score);
            }
        }

        public static void main(String[] args){

            int cnum = random();
            guessno(cnum);

        }

        static int random(){
            Random random = new Random();
            randomno= random.nextInt(100)+1;
//        System.out.println("Random number is: "+rnum);
            return randomno;
        }
}
