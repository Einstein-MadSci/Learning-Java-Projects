import java.util.*;

public class RockPaperScissors{
    public String ComputerChoice()
    {
        int choiceNum = (int)(Math.random() * 3);
        String choice = "";

        if(choiceNum == 0)
        {
            choice = "Rock";
        }
        else if(choiceNum == 1)
        {
            choice = "Paper";
        }
        else 
        {
            choice = "Scissors";
        }

        return choice;
    }

    public String userChoice(int userCH)
    {
        String userChoice = "";
        if(userCH == 0)
        {
            userChoice = "Rock";
        }
        else if(userCH == 1)
        {
            userChoice = "Paper";
        }
        else if(userCH == 2)
        {
            userChoice = "Scissors";
        }
        // while(inputToLower != "rock" || inputToLower != "paper" || inputToLower != "scissors")
        // {
        //     System.out.println("Make a choice (\"Rock\", \"Paper\", \"Scissors\"): ");
        //     playerChoice = inputReader.nextLine().toLowerCase();
        //     if(playerChoice == "rock" || playerChoice == "paper" || playerChoice == "scissors")
        //     {
        //         break;
        //     }
        // }
        return userChoice;
    }

    public String winOrLose(String user, String comp)
    {
        String result = "";

        if(user == "Rock" && comp == "Scissors")
        {
            result = "You Win!!";
        }
        else if(user == "Paper" && comp == "Rock")
        {
            result = "You Win!!";
        }
        else if(user == "Scissors" && comp == "Paper")
        {
            result = "You Win!!";
        }
        else
        {
            result = "Computer Wins!!";
        }

        return result;
    }

    public static void main(String args[])
    {
        RockPaperScissors gamePlay = new RockPaperScissors();
        String computersChoice = gamePlay.ComputerChoice();

        Scanner inputReader = new Scanner(System.in);
        System.out.print("Make a choice: 0 - Rock, 1 - Paper, 2 - Scissors: ");
        int playerChoice = inputReader.nextInt();

        String userChoice = gamePlay.userChoice(playerChoice);

        String winner = gamePlay.winOrLose(userChoice, computersChoice);

        System.out.println("Computer chose: " + computersChoice + " & You chose: " + userChoice + " Therefore " + winner);
    }
}