import java.util.*;

public class GuessingGame
{
	public static void main(String args[])
	{
		int numberToGuess = (int)(Math.random() * 99) + 1;
		int tries = 0;

		Scanner inputReader = new Scanner(System.in);
		System.out.print("Choose a difficulty level (0 for easy) & (1 for hard): ");
		int levelSelector = inputReader.nextInt();

		while(levelSelector > 1 || levelSelector < 0)
		{
			System.out.print("Choose a difficulty level (0 for easy) & (1 for hard): ");
			levelSelector = inputReader.nextInt();
		}

		if(levelSelector == 0)
		{
			tries = 10;
			// for(tries; tries > 0; tries++)
			while(tries > 0)
			{
				System.out.print("Make a guess between 1 and 100: ");
				int userGuess = inputReader.nextInt();

				if(userGuess < numberToGuess)
				{
					System.out.println("Too low!");
					tries--;
					System.out.println("Tries left: " + tries);
				}
				else if(userGuess > numberToGuess)
				{
					System.out.println("Too high!");
					tries--;
					System.out.println("Tries left: " + tries);
				}
				else
				{
					System.out.println(numberToGuess + " You're correct!");
					tries = 0;
				}
			}
		}		
		
		if(levelSelector == 1)
		{
			tries = 5;
			// for(tries; tries > 0; tries++)
			while(tries > 0)
			{
				System.out.print("Make a guess between 1 and 100: ");
				int userGuess = inputReader.nextInt();

				if(userGuess < numberToGuess)
				{
					System.out.println("Too low!");
					tries--;
					System.out.println("Tries left: " + tries);
				}
				else if(userGuess > numberToGuess)
				{
					System.out.println("Too high!");
					tries--;
					System.out.println("Tries left: " + tries);
				}
				else
				{
					System.out.println(numberToGuess + " You're correct!");
					tries = 0;
				}
			}
		}		
	}
}