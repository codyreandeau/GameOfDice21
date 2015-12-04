
import java.util.Random;
import java.util.Scanner;

public class Dice
{
  public static void main(String[] args)
  {
    //declare choice variable
    char choice;
    
    //Iterate through program, if user wants to play multiple times
    do{
    
    //declare variables
    Random dice = new Random();
    int dice1 = 0;
    int dice2 = 0;
    int compDice1 = 0;
    int compDice2 = 0;
    int userTotal = 0;
    int compTotal = 0;
    String input;
    
    //Create scanner object for keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    //Roll dice for the computer
    compDice1 = dice.nextInt(6) + 1;
    compDice2 = dice.nextInt(6) + 1;
    compTotal += compDice1 + compDice2;
    
    //Display the users first roll
    System.out.print("Your first roll is a ");
    dice1 = dice.nextInt(6) + 1;
    dice2 = dice.nextInt(6) + 1;
    System.out.println(dice1 + " and a " + dice2);
    userTotal = dice1 + dice2;
    System.out.println("Your current total is: " + userTotal);
    
    //Ask if they would like to roll again?
    System.out.print("Would you like to roll again? (Y/N): ");
    input = keyboard.nextLine();
    choice = input.charAt(0);
    
    //Execute while statement if user wants to play again.
    while (choice == 'Y' || choice == 'y')
    {
      //Roll for user
      dice1 = dice.nextInt(6) + 1;
      dice2 = dice.nextInt(6) + 1;
      System.out.println("you rolled a " + dice1 + " and a " + dice2);
      userTotal += dice1 + dice2;
      //Roll for computer
      compDice1 = dice.nextInt(6) + 1;
      compDice2 = dice.nextInt(6) + 1;
      compTotal += compDice1 + compDice2;
      
      //If user gets a blackjack
      if(userTotal == 21)
      {
        System.out.println("21! That's a BLACKJACK! You Win!");
        break;
      }
      //If user goes over 21
      else if (userTotal > 21)
      {
        System.out.println("You just rolled a: " + userTotal);
        System.out.println("Sorry, you went over 21, the computer automatically wins.");
        break;
      }
      //Display current total to user
      System.out.println("Your current total is: " + userTotal);
    
    //Ask user if they would like to roll again.
    System.out.print("Would you like to roll again?");
    input = keyboard.nextLine();
    choice = input.charAt(0); 
    }
    
    //If the computer goes over 21
    if(compTotal > 21 && userTotal < 21)
    {
      System.out.println("The computer went over 21. You Win!");
    }
    //If the computer gets a blackjack
    else if(compTotal == 21)
    {
      System.out.println("The computer got a blackjack. You lose.");
    }
    
    if(compTotal > 21 || compTotal == 21 || userTotal > 21 || userTotal == 21)
    {
      //In case of any of the above conditions, do nothing.
    }
    //If the computer wins
    else if (compTotal > userTotal)
    {
      System.out.println("The Computers score is: " + compTotal + "." +
                                   " Your score is: " + userTotal + ".");
      System.out.println("The Computer has a higher score. You lose.");
    }
    //If the user wins
    else if (userTotal > compTotal)
    {
      System.out.println("Your score is: " + userTotal + "." +
                         " the Computers score is: " + compTotal + ".");
      System.out.println("You have a higher score than the Computer. You Win!");
    }
      
    //Ask user if they would like to play again.
    System.out.print("Would you like to play again? ");
    input = keyboard.nextLine();
    choice = input.charAt(0); 
      
    } while (choice == 'Y' || choice == 'y'); //If the user does want to play again, loop through the program again
    System.out.println("Thanks for playing!"); //If the user does not want to play again.
  }
}
