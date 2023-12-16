import java.util.Scanner;//package to get Userinput
import java.util.Random;//package to generate random number

class Game{
    public int number;//stores the number generated by random package
    public int inputnumber;//stores number given by user
    public int numberofguess=0;//stores the number of guesses by the user

    Game()//constructor of Game class
    {
        Random r = new Random();
        this.number = r.nextInt(100);
    }
    void takeuserinput()//method to take user input
    {
        System.out.println("guess the number");
        Scanner sc = new Scanner(System.in);
        inputnumber =sc.nextInt();
    }
    boolean correctnumber()//method for correct number
    {
        numberofguess++;
        if(inputnumber==number)//if the user input number and computer generated number are same print your guess is correct also print number of guesses
        {
            System.out.format("hurray..! you guessed the correct number ,the number was %d\n",number);
            System.out.format("\n the number of times you guessed is %d",numberofguess);
            return true;
        }
        else if (inputnumber<number)//if input number is smaller than computer generated number print your guess is smaller than the actual number
        {
            System.out.println("Number guessed is too low as of actual number,please guess a higher number");
        }
        else if (inputnumber>number)//if input number is greater than computer generated number print your guess is greater than the actual number
        {
            System.out.println("number guessed  is too high as of actual number,please guess a smaller number ");
        }
        return false;

    }

}
public class guessthenumber {
    public static void main(String[] args) {

        Game g =new Game();//g is object of Game class
        boolean b = false;
        while(!b)//until the value of b turns to be true it will keep taking input from user.
        {
            g.takeuserinput();
            b = g.correctnumber();
        }

    }
}