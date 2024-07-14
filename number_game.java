import java.util.Random;
import java.util.Scanner;

class Game {
    public int number;
    public int inputNumber;
    public int noOfGuess = 0;
    int getNoOfGuess(){
        return  noOfGuess;
    }
    void setNoOfGuess(int noOfGuess){
        this.noOfGuess = noOfGuess;
    }
    Game(){
        Random rand = new Random();
        this.number = rand.nextInt(100);
    }
    void takeUserInputNumber(){
        System.out.println("Guess the number");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }
    boolean isCorrectNumber(){
        noOfGuess++;
        if (inputNumber == number){
            System.out.printf("Yes you have guessed it right, you guessed %d\nYou guessed it %d attemps", inputNumber, noOfGuess);
            return true;
        } else if (inputNumber < number) {
            System.out.println("Too low...");
        } else if (inputNumber > number) {
            System.out.println("Too high...");
        }
        return false;
    }
}

public class number_game {
    public static void main(String[] args) {
        Game g = new Game();
        boolean b = false;
        while (!b){
            g.takeUserInputNumber();
            b = g.isCorrectNumber();
        }
    } 
}
